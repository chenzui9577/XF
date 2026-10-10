package org.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.example.entity.User;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper  extends BaseMapper<User> {
}
