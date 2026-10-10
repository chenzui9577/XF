package cn.XF.server.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * (Engistates)表实体类
 *
 * @author cz
 * @since 2023-09-27 15:55:59
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@SuppressWarnings("serial")
public class Engistates implements Serializable {
    private static final long serialVersionUID = 258416304398941082L;


    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 工程名称
     */
    @ApiModelProperty(name = "unitname", value = "工程名称")
    private String unitname;

    /**
     * 控制器编码（项目代码），通过sys_controller表内的Ccode查询获取
     */
    @ApiModelProperty(name = "engicode", value = "控制器编码（项目代码），通过sys_controller表内的Ccode查询获取")
    private String engicode;

    /**
     * 控制器名称（项目名称），通过sys_controller表内的Ccode查询获取
     */
    @ApiModelProperty(name = "enginame", value = "控制器名称（项目名称），通过sys_controller表内的Ccode查询获取")
    private String enginame;

    /**
     * 部件名称，通过sys_equideti表，使用Engicode+Usercode字段查询
     */
    @ApiModelProperty(name = "equiname", value = "部件名称，通过sys_equideti表，使用Engicode+Usercode字段查询")
    private String equiname;

    /**
     * 部件注释
     */
    @ApiModelProperty(name = "addr", value = "部件注释")
    private String addr;

    /**
     * 状态描述
     */
    @ApiModelProperty(name = "statename", value = "状态描述")
    private String statename;

    /**
     * 用户编码，来源于采集数据上行
     */
    @ApiModelProperty(name = "usercode", value = "用户编码，来源于采集数据上行")
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
    private String loops;

    /**
     * 地址码
     */
    @ApiModelProperty(name = "eaddr", value = "地址码")
    private String eaddr;

    /**
     * 入库时间
     */
    @ApiModelProperty(name = "dt", value = "入库时间")
    private String dt;
}

