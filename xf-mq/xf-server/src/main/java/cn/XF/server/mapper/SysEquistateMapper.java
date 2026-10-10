package cn.XF.server.mapper;

import cn.XF.server.entity.SysEquistate;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * (SysEquistate)表数据库访问层
 *
 * @author cz
 * @since 2023-09-27 16:07:52
 */
@Mapper
@Component
public interface SysEquistateMapper extends BaseMapper<SysEquistate> {


}

