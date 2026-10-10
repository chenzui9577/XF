package org.example.controller;

import cn.hutool.core.util.StrUtil;
import org.example.common.AuthAccess;
import org.example.common.HoneyLogs;
import org.example.common.LogType;
import org.example.common.Result;
import org.example.entity.User;
import org.example.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 登录
 */

@RestController
@RequestMapping("/user")
public class WebController {
    @Resource
    UserService userService;

    @AuthAccess
    @GetMapping("/")
    public Result hello() {
        return Result.succeed("success");
    }
    //@AuthAccess @RequestBody
    @HoneyLogs(operation = "管理员", type = LogType.LOGIN)
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public Result login(User user) {
        if (StrUtil.isBlank(user.getUsername()) || StrUtil.isBlank(user.getPassword())) {
            return Result.error("数据输入不合法");
        }
        user = userService.login(user);
        return Result.succeed(user);
    }

}

