package cn.XF.server.mapper;

import cn.XF.server.entity.SysProgram;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * (SysProgram)表数据库访问层
 *
 * @author cz
 * @since 2023-09-27 16:07:52
 */
@Mapper
@Component
public interface SysProgramMapper extends BaseMapper<SysProgram> {


}

