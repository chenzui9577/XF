package org.example.entity;

import cn.hutool.core.annotation.Alias;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("user")
public class User {

    @TableId(type= IdType.AUTO)
    @Alias("序号")
    private Integer id;
    @Alias("用户名")
    private String username;
    @Alias("密码")
    private String password;

    @TableField(exist = false)
    private String token;
}
