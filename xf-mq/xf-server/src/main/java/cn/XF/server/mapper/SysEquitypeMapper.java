package cn.XF.server.mapper;

import cn.XF.server.entity.SysEquitype;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * 设备类型管理表(SysEquitype)表数据库访问层
 *
 * @author cz
 * @since 2023-09-27 16:07:52
 */
@Mapper
@Component
public interface SysEquitypeMapper extends BaseMapper<SysEquitype> {


}

