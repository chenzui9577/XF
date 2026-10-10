package cn.XF.server.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 部件明细表(SysEquideti)表实体类
 *
 * @author cz
 * @since 2023-09-27 16:07:51
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@SuppressWarnings("serial")
public class SysEquideti implements Serializable {
    private static final long serialVersionUID = 422903178797247258L;


    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 控制器编码，例：37XF190000142
     */
    @ApiModelProperty(name = "engicode", value = "控制器编码，例：37XF190000142")
    private String engicode;

    /**
     * 部件名称，（简称）与部件类型名称同
     */
    @ApiModelProperty(name = "name", value = "部件名称，（简称）与部件类型名称同")
    private String name;

    /**
     * 部件注释
     */
    @ApiModelProperty(name = "addr", value = "部件注释")
    private String addr;

    /**
     * 用户编码，对于总线设备：机号+回路+地址码；对多线设备：盘号+手动键号
     */
    @ApiModelProperty(name = "usercode", value = "用户编码，对于总线设备：机号+回路+地址码；对多线设备：盘号+手动键号")
    private String usercode;
    /**
     * 机号
     */
    @ApiModelProperty(name = "number", value = "机号")
    private String number;
    /**
     * 回路
     */
    @ApiModelProperty(name = "loops", value = "回路")
    private Integer loops;

    /**
     * 地址码
     */
    @ApiModelProperty(name = "eaddr", value = "地址码")
    private String eaddr;
}

