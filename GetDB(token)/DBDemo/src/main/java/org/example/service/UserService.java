package org.example.service;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.entity.User;
import org.example.exception.ServiceException;
import org.example.mapper.UserMapper;
import org.example.util.TokenUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService extends ServiceImpl<UserMapper, User> {

    @Resource
    UserMapper userMapper;


    @Override
    public boolean save(User entity) {
        if (StrUtil.isBlank(entity.getPassword())) {
            entity.setPassword("admin");   // 默认密码admin
        }
        return super.save(entity);
    }

    public User selectByUsername(String username) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);  //  eq => ==   where username = #{username}
        // 根据用户名查询数据库的用户信息
        return getOne(queryWrapper); //  select * from user where username = #{username}
    }

    // 验证用户账户是否合法
    public User login(User user) {
        User dbUser = selectByUsername(user.getUsername());
        if (dbUser == null) {
            // 抛出一个自定义的异常
            throw new ServiceException("用户名或密码错误");
        }
        if (!user.getPassword().equals(dbUser.getPassword())) {
            throw new ServiceException("用户名或密码错误");
        }
        // 生成token
        String token = TokenUtils.createToken(dbUser.getId().toString(), dbUser.getPassword());
        dbUser.setToken(token);
        return dbUser;
    }
}
