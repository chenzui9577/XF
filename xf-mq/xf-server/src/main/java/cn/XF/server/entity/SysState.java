package cn.XF.server.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 设备状态标准表(SysState)表实体类
 *
 * @author cz
 * @since 2023-09-27 16:07:52
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@SuppressWarnings("serial")
public class SysState implements Serializable {
    private static final long serialVersionUID = -76121841576835538L;


    /**
     * 状态值
     */
    @TableId(type = IdType.AUTO)
    private String states;

    /**
     * 状态名称
     */
    @ApiModelProperty(name = "statename", value = "状态名称")
    private String statename;

    /**
     * 描述
     */
    @ApiModelProperty(name = "notes", value = "描述")
    private String notes;
}

