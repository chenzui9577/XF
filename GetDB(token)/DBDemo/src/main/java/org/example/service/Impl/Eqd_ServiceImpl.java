package org.example.service.Impl;

import org.example.entity.PartComparisonResult;
import org.example.entity.Sys_equideti;
import org.example.mapper.Sys_equidetiMapper;
import org.example.service.Eqd_Service;
import org.example.util.ExcelReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class Eqd_ServiceImpl implements Eqd_Service {

    //调用Sys_equidetiMapper查询数据
    //@Resource或者@Autowired注解都可
    @Resource
    @Autowired
    private Sys_equidetiMapper sys_eqdMapper;
    private static final Logger LOGGER = LoggerFactory.getLogger(Eqd_ServiceImpl.class);
    @Autowired
    public Eqd_ServiceImpl(Sys_equidetiMapper sys_eqdMapper) {
        this.sys_eqdMapper = sys_eqdMapper;
    }

    @Override
    public List<Sys_equideti> selectByEngicode(String Engicode) {
        return sys_eqdMapper.selectByEngicode(Engicode);
    }
    @Override
    public  void deleteByEngicode(String Engicode){
        sys_eqdMapper.deleteByEngicode(Engicode);
    }
    @Override
    public List<Sys_equideti> selectAll() {
        List<Sys_equideti> eqd = sys_eqdMapper.selectAll();
        return eqd;
    }

    /*@Override
    public List<Sys_equideti> getLatestComparisonResult(){
        List<Sys_equideti> eqd = sys_eqdMapper.getLatestComparisonResult();
        return eqd;
    }*/
    @Override
    public  List<Sys_equideti> queryByid(int id) {
        return sys_eqdMapper.queryByid(id);
    }

    @Override
    public int deleteSys_equideti(int id) {
        return sys_eqdMapper.deleteSys_equideti(id);
    }

    @Override
    public int updateSys_equideti(Sys_equideti syseqd) {
        return sys_eqdMapper.updateSys_equideti(syseqd);
    }
    @Override
    public int addSys_equideti(Sys_equideti eqd) {
        return sys_eqdMapper.addSys_equideti(eqd);
    }

    @Override
    public void deleteBatch(List<Integer> ids) {
        sys_eqdMapper.deleteBatchByIds(ids);
    }
    @Override
    @Transactional
    public void processExcelFile(InputStream inputStream) {
        List<String> failedRecords = new ArrayList<>(); // 存储导入失败的记录

        try {
            List<Sys_equideti> dataList = ExcelReader.readExcel(inputStream);

            // 使用 Set 存储所有唯一的 Engicode
            Set<String> engicodes = dataList.stream()
                    .map(Sys_equideti::getEngicode)
                    .collect(Collectors.toSet());

            for (String engicode : engicodes) {
                // 删除每个 Engicode 对应的旧记录
                sys_eqdMapper.deleteByEngicode(engicode);

                // 导入新的记录
                dataList.stream()
                        .filter(data -> engicode.equals(data.getEngicode()))
                        .forEach(data -> {
                            try {
                                sys_eqdMapper.addexcel(data);
                            } catch (Exception e) {
                                // 记录失败的数据和异常信息
                                failedRecords.add("导入失败: " + data.toString() + "，错误: " + e.getMessage());
                            }
                        });
            }
        } catch (Exception e) {
            throw new RuntimeException("处理Excel文件时出错", e);
        }

        // 打印或返回失败记录
        if (!failedRecords.isEmpty()) {
            for (String record : failedRecords) {
                System.out.println(record); // 或者添加到一个响应对象中返回给前端
            }
        }
    }

    @Override
    public List<String> getUsercodeByEngicode(String engicode) {
        return sys_eqdMapper.getUsercodeByEngicode(engicode);
    }
    @Override
    public List<Sys_equideti> getUsercodeByEngicode1(String engicode) {
        return sys_eqdMapper.getUsercodeByEngicode1(engicode);
    }
    @Override
    public void savePartComparisonResult(PartComparisonResult result) {
        sys_eqdMapper.savePartComparisonResult(result);
    }

    @Override
    public PartComparisonResult getPartComparisonResult() {
        return sys_eqdMapper.getPartComparisonResult();
    }
 /*
    @Override
    public List<String> getUsercodeByEngicode(String engicode) {
        List<Sys_equideti> sysEquidetiList = sys_eqdMapper.getUsercodeByEngicode(engicode);
        List<String> usercodes = new ArrayList<>();
        for (Sys_equideti sysEquideti : sysEquidetiList) {
            usercodes.add(sysEquideti.getUsercode());
        }
        return usercodes;
    }

  @Override
    public void compareParts(List<String> parts) {
        // 固定的 Engicode
        String engicode = "37XF210000154";

        // 查询数据库中的 Usercode
        List<String> usercodes = getUsercodeByEngicode(engicode);

        // 对比 Parts 和 Usercode
        for (String part : parts) {
            if (!usercodes.contains(part)) {
                System.out.println("不同的部件：" + part);
            }
        }
    }

    // 将 JSON 字符串转换为 SysEquideti 列表
    public List<Sys_equideti> jsonToSysEquidetiList(String json) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, objectMapper.getTypeFactory().constructCollectionType(List.class, Sys_equideti.class));
    }*/

}
