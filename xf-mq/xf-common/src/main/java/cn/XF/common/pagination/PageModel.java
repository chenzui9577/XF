package cn.XF.common.pagination;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * 分页工具类
 *
 * @author wpx
 */
@Data
@ApiModel("分页数据实体")
public class PageModel<T> {
    /**
     * 总数据条数
     **/
    @ApiModelProperty(value = "总数据条数")
    private int total;
    /**
     * 当页条数
     **/
    @ApiModelProperty(value = "当页条数")
    private int size;
    /**
     * 当前页
     **/
    @ApiModelProperty(value = "当前页")
    private int current;
    /**
     * 总页数
     **/
    @ApiModelProperty(value = "总页数")
    private int pages;
    /**
     * 当前页数据
     **/
    @ApiModelProperty(value = "当前页数据对象")
    private List<T> list;
}
