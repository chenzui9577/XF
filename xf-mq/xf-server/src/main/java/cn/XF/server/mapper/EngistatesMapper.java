package cn.XF.server.mapper;

import cn.XF.server.entity.Engistates;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * (Engistates)表数据库访问层
 *
 * @author cz
 * @since 2023-09-27 15:56:00
 */
@Mapper
@Component
public interface EngistatesMapper extends BaseMapper<Engistates> {


}

