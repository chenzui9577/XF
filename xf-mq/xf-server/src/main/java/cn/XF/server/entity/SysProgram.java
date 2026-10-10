package cn.XF.server.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * (SysProgram)表实体类
 *
 * @author cz
 * @since 2023-09-27 16:07:52
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@SuppressWarnings("serial")
public class SysProgram implements Serializable {
    private static final long serialVersionUID = -42726966905916272L;


    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 项目名称
     */
    @ApiModelProperty(name = "enginame", value = "项目名称")
    private String enginame;

    /**
     * 项目代码
     */
    @ApiModelProperty(name = "engicode", value = "项目代码")
    private String engicode;

    /**
     * 项目地址
     */
    @ApiModelProperty(name = "address", value = "项目地址")
    private String address;

    /**
     * 项目隶属机构
     */
    @ApiModelProperty(name = "client", value = "项目隶属机构")
    private String client;

    /**
     * 项目类型名称
     */
    @ApiModelProperty(name = "protypename", value = "项目类型名称")
    private String protypename;

    /**
     * 工程名称（委托单位）
     */
    @ApiModelProperty(name = "unitname", value = "工程名称（委托单位）")
    private String unitname;
}

