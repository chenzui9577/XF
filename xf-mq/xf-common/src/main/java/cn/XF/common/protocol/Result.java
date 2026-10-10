package cn.XF.common.protocol;


import cn.XF.common.constant.ResultStatus;
import lombok.Data;

import java.util.Objects;

/**
 * 返回结果类
 *
 * @author cz
 **/
@Data
public class Result<T> {

    /**
     * 返回码
     */
    private String resultCode;

    /**
     * 返回信息
     */
    private String message;

    /**
     * 返回真实的数据体
     **/
    private T data;

    /**
     * 别在贱手删掉了，如果删掉的话会造成JSON转化是提示该类没有构造函数
     * cz
     */
    public Result() {

    }

    private Result(String resultCode, String message) {
        this.resultCode = resultCode;
        this.message = message;
    }

    private Result(String resultCode, T data) {
        this.data = data;
        this.resultCode = resultCode;
        if (resultCode.equals(ResultStatus.SUCCESS.resultCode)) {
            this.message = "请求成功";
        }
    }

    /**
     * 构建成功结果
     *
     * @return 结果类
     */
    public static Result buildSuccess() {
        return new Result(ResultStatus.SUCCESS.resultCode, ResultStatus.SUCCESS.message);
    }


    /**
     * 构建成功结果
     *
     * @param data 返回数据
     * @return 结果类
     */
    public static Result buildSuccess(Object data) {
        return new Result(ResultStatus.SUCCESS.resultCode, data);
    }

    /**
     * 构建失败结果
     *
     * @param resultCode 状态码
     * @param message    说明信息
     * @return 结果类
     */
    public static Result buildFailure(String resultCode, String message) {
        return new Result(resultCode, message);
    }

    /**
     * 构建失败结果
     *
     * @param status 状态
     * @return 结果类
     */
    public static Result buildFailure(ResultStatus status) {
        if (Objects.nonNull(status)) {
            return new Result(status.resultCode, status.message);
        }
        return null;
    }
}
