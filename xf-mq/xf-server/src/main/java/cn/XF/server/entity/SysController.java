package cn.XF.server.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 控制器信息表(SysController)表实体类
 *
 * @author cz
 * @since 2023-09-27 16:07:51
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@SuppressWarnings("serial")
public class SysController implements Serializable {
    private static final long serialVersionUID = -61466142014081079L;


    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 控制器编码（项目代码）
     */
    @ApiModelProperty(name = "engicode", value = "控制器编码（项目代码）")
    private String engicode;

    /**
     * 控制器名称（项目名称）
     */
    @ApiModelProperty(name = "enginame", value = "控制器名称（项目名称）")
    private String enginame;

    /**
     * 控制器返回码
     */
    @ApiModelProperty(name = "ccode", value = "控制器返回码")
    private String ccode;

    /**
     * 部件系统类型代码
     */
    @ApiModelProperty(name = "typecode", value = "部件系统类型代码")
    private String typecode;

    /**
     * 部件系统类型名称
     */
    @ApiModelProperty(name = "typename", value = "部件系统类型名称")
    private String typename;

    /**
     * 备注
     */
    @ApiModelProperty(name = "notes", value = "备注")
    private String notes;
}

