package cn.XF.server.mapper;

import cn.XF.server.entity.SysState;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * 设备状态标准表(SysState)表数据库访问层
 *
 * @author cz
 * @since 2023-09-27 16:07:52
 */
@Mapper
@Component
public interface SysStateMapper extends BaseMapper<SysState> {


    /**
     * 获取状态描述
     *
     * @param engiName 部件名称
     * @param reState  消息状态
     * @return 状态描述
     */
    String getStateName(@Param("engiName") String engiName, @Param("reState") String reState);

}

