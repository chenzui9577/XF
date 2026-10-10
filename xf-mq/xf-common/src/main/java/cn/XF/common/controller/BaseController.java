package cn.XF.common.controller;


import cn.XF.common.constant.ResultStatus;
import cn.XF.common.protocol.Result;

/**
 * 基础控制类，提供分页数据封装，结果返回功能
 *
 * @author cz
 **/
public class BaseController {

    /**
     * 构建成功结果
     *
     * @return 结果类
     */
    public Result success() {
        return Result.buildSuccess();
    }


    /**
     * 构建成功结果
     *
     * @param data 返回数据
     * @return 结果类
     */
    public Result success(Object data) {
        return Result.buildSuccess(data);
    }

    /**
     * 构建失败结果
     *
     * @param resultCode 状态码
     * @param message    说明信息
     * @return 结果类
     */
    public Result failure(String resultCode, String message) {
        return Result.buildFailure(resultCode, message);
    }

    /**
     * 构建失败结果
     *
     * @param status 失败状态
     * @return 结果类
     */
    public Result failure(ResultStatus status) {
        return Result.buildFailure(status);
    }

}
