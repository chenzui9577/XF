package cn.XF.server.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * (SysEquistate)表实体类
 *
 * @author cz
 * @since 2023-09-27 16:07:51
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@SuppressWarnings("serial")
public class SysEquistate implements Serializable {
    private static final long serialVersionUID = -25376025069588385L;


    @TableId(type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(name = "typecode", value = "$column.comment")
    private String typecode;

    @ApiModelProperty(name = "code", value = "$column.comment")
    private String code;

    @ApiModelProperty(name = "retcode", value = "$column.comment")
    private String retcode;

    @ApiModelProperty(name = "states", value = "$column.comment")
    private String states;

    @ApiModelProperty(name = "retstate", value = "$column.comment")
    private String retstate;

    @ApiModelProperty(name = "statename", value = "$column.comment")
    private String statename;
}

