package cn.XF.server.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 设备类型管理表(SysEquitype)表实体类
 *
 * @author cz
 * @since 2023-11-20 14:31:59
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@SuppressWarnings("serial")
public class SysEquitype implements Serializable {
    private static final long serialVersionUID = -84005623300967804L;


    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 部件代码
     */
    @ApiModelProperty(name = "code", value = "部件代码")
    private String code;

    /**
     * 部件名称
     */
    @ApiModelProperty(name = "nameEqt", value = "部件名称")
    private String nameEqt;

    /**
     * 系统类型，对应设备类型表，报警系统、消火栓系统、喷淋系统…
     */
    @ApiModelProperty(name = "systype", value = "系统类型，对应设备类型表，报警系统、消火栓系统、喷淋系统…")
    private String systype;

    /**
     * 总线类型，0多线部件，1总线部件
     */
    @ApiModelProperty(name = "bus", value = "总线类型，0多线部件，1总线部件")
    private String bus;

    /**
     * 备注
     */
    @ApiModelProperty(name = "notes", value = "备注")
    private String notes;
}

