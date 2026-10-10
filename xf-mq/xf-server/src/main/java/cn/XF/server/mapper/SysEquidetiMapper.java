package cn.XF.server.mapper;

import cn.XF.server.entity.SysEquideti;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * 部件明细表(SysEquideti)表数据库访问层
 *
 * @author cz
 * @since 2023-09-27 16:07:51
 */
@Mapper
@Component
public interface SysEquidetiMapper extends BaseMapper<SysEquideti> {


}

