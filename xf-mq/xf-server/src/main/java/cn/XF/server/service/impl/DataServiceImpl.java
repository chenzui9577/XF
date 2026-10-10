package cn.XF.server.service.impl;

import cn.XF.server.dto.request.CollectDataRequest;
import cn.XF.server.entity.*;
import cn.XF.server.entity.customize.CoreInfo;
import cn.XF.server.mapper.SysControllerMapper;
import cn.XF.server.mapper.SysEquidetiMapper;
import cn.XF.server.mapper.SysProgramMapper;
import cn.XF.server.mapper.SysStateMapper;
import cn.XF.server.service.DataService;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * <p>数据处理的服务接口</p>
 *
 * @author XF
 **/
@Service
public class DataServiceImpl implements DataService {
    private static final Logger logger = LoggerFactory.getLogger(DataServiceImpl.class);

    @Resource
    private SysControllerMapper sysControllerMapper;
    @Resource
    private SysEquidetiMapper sysEquidetiMapper;
    @Resource
    private SysProgramMapper sysProgramMapper;
    @Resource
    private SysStateMapper sysStateMapper;

    /**
     * 原始消防数据拆解
     *
     * @param dataRequest 待分析的数据
     * @return 分析后的信息数组
     */
    @Override
    public List<Engistates> analyseData(CollectDataRequest dataRequest) {

        List<Engistates> engistatesList = new ArrayList<>();

        //初始数据构建
        String engicode = null;
        String enginame = null;
        String unitname = null;

        Date date = new Date(dataRequest.getCreatTime());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dt = simpleDateFormat.format(date);

        //获取控制信息
        SysController sysController = getSysController(dataRequest.getSn());
        if (sysController == null) {
            return null;
        }
        engicode = sysController.getEngicode();
        enginame = sysController.getEnginame();

        SysProgram sysProgram = getSysProgram(engicode);
        if (sysProgram == null) {
            return null;
        }
        unitname = sysProgram.getUnitname();
        List<String> strList = splitData(dataRequest.getData());
        for (String str : strList) {
            if (StrUtil.isBlank(str)) {
                continue;
            }
            CoreInfo coreInfo = getCoreInfo(str);
            if (coreInfo == null) {
                continue;
            }

            SysEquideti sysEquideti = getSysEquideti(engicode, coreInfo.getUserCode());
            if (sysEquideti == null) {
                logger.warn("未找到有效数据1：{},原始数据为:{}", str, dataRequest);
                Engistates eng = new Engistates();
                eng.setUnitname("");
                eng.setEngicode("");
                eng.setEnginame("");
                eng.setEquiname("");
                eng.setUsercode(coreInfo.getUserCode());
                eng.setNumber("");
                eng.setLoops("");
                eng.setEaddr("");
                eng.setAddr("");
                eng.setStatename("");
                eng.setDt(dt);
                engistatesList.add(eng);
                continue;
            }
            String stateName;
            if (coreInfo.getState().length() > 2) {
                //如果状态大于2位，则直接sys_state表查询
                stateName = getStateName2(coreInfo.getState());
            } else {
                stateName = getStateName(sysEquideti.getName(), coreInfo.getState());
            }

            if (StrUtil.isBlank(stateName)) {
                logger.error("未找到有效数据2：{},原始数据为:{}", str, dataRequest);
                continue;
            }

            Engistates eng = new Engistates();
            eng.setUnitname(unitname);
            eng.setEngicode(engicode);
            eng.setEnginame(enginame);
            eng.setEquiname(sysEquideti.getName());
            eng.setUsercode(sysEquideti.getUsercode());
            eng.setNumber(sysEquideti.getNumber());
            eng.setLoops(sysEquideti.getLoops().toString());
            eng.setEaddr(sysEquideti.getEaddr());
            eng.setAddr(sysEquideti.getAddr());
            eng.setStatename(stateName);
            eng.setDt(dt);
            engistatesList.add(eng);
        }

        return engistatesList;
    }

    /**
     * 获取控制器信息表数据
     *
     * @param sn 设备串号
     * @return 控制器信息
     */
    private SysController getSysController(String sn) {
        LambdaQueryWrapper<SysController> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SysController::getCcode, sn);
        return sysControllerMapper.selectOne(queryWrapper);
    }

    /**
     * 获取项目信息
     *
     * @param code 控制器编码
     * @return 项目信息
     */
    private SysProgram getSysProgram(String code) {
        LambdaQueryWrapper<SysProgram> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SysProgram::getEngicode, code);
        return sysProgramMapper.selectOne(queryWrapper);
    }

    /**
     * 分拆采集数据
     *
     * @param str 待分拆的数据
     * @return 分拆完毕的数据
     */
    private List<String> splitData(String str) {
        if (StrUtil.isBlank(str)) {
            return Collections.emptyList();
        }

        List<String> split = StrUtil.split(str, ';');
        if (CollectionUtil.isEmpty(split)) {
            return Collections.emptyList();
        }
        return split;
    }

    /**
     * 获取信息采集的核心关键数据
     *
     * @param str 待分拆的消防数据
     * @return 信息数据
     */
    private CoreInfo getCoreInfo(String str) {
        try {
            CoreInfo coreInfo = new CoreInfo();
            List<String> split = StrUtil.split(str, ',');
            coreInfo.setUserCode(split.get(1));
            coreInfo.setState(split.get(2));
            return coreInfo;
        } catch (Exception ex) {
            logger.error("信息采集的核心关键数据错误:{}", ex.getMessage());
            return null;
        }
    }

    /**
     * 获取部件信息
     *
     * @param code     控制器编码
     * @param userCode 用户编码
     * @return 部件信息
     */
    private SysEquideti getSysEquideti(String code, String userCode) {
        LambdaQueryWrapper<SysEquideti> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SysEquideti::getEngicode, code);
        queryWrapper.eq(SysEquideti::getUsercode, userCode);
        return sysEquidetiMapper.selectOne(queryWrapper);
    }

    /**
     * 获取状态描述
     *
     * @param engiName 部件名称
     * @param reState  消息状态
     * @return 状态描述
     */
    private String getStateName(String engiName, String reState) {
        return sysStateMapper.getStateName(engiName, reState);
    }

    /**
     * 获取状态描述，只有状态码为3位时使用
     *
     * @param reState 消息状态
     * @return 状态描述
     */
    private String getStateName2(String reState) {
        LambdaQueryWrapper<SysState> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SysState::getStates, reState);
        queryWrapper.last("limit 1");
        SysState sysState = sysStateMapper.selectOne(queryWrapper);
        return sysState == null ? null : sysState.getStatename();
    }
}
