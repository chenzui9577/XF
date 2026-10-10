package cn.XF.common.exception;

import cn.XF.common.constant.ResultStatus;
import cn.XF.common.protocol.Result;
import cn.hutool.core.util.StrUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolationException;
import java.util.List;

/**
 * 全局异常控制类
 *
 * @author wpx
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private final static Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 异常处理数据处理
     */
    private Result commonHandler(String httpCode, String message) {
        return Result.buildFailure(httpCode, message);
    }


    /**
     * 400异常处理
     *
     * @param exception 异常
     * @return Result
     */
    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    @ResponseBody
    public Result errorHandler(HttpMessageNotReadableException exception) {
        logger.error("异常信息：", exception);
        return commonHandler(ResultStatus.BAD_REQUEST.resultCode, exception.getMessage());
    }

    /**
     * 405异常处理
     *
     * @param exception 异常
     * @return result
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseBody
    public Result errorHandler(HttpRequestMethodNotSupportedException exception) {
        logger.error("异常信息：", exception);
        return commonHandler(ResultStatus.METHOD_NOT_ALLOWED.resultCode, exception.getMessage());
    }

    /**
     * 415异常处理
     *
     * @param exception 异常
     * @return Result 结果
     */
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    @ResponseBody
    public Result errorHandler(HttpMediaTypeNotSupportedException exception) {
        logger.error("异常信息：", exception);
        return commonHandler(ResultStatus.UNSUPPORTED_MEDIA_TYPE.resultCode, exception.getMessage());
    }

    /**
     * 500异常处理
     *
     * @param exception 异常
     * @return Result
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result errorHandler(Exception exception) {
        logger.error("异常信息：", exception);
        return commonHandler(ResultStatus.INTERNAL_SERVER_ERROR.resultCode, exception.getMessage());
    }


    /**
     * 参数校验异常处理(post方式)
     *
     * @param exception 异常
     * @return 返回类
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public Result parameterExceptionHandlerPost(MethodArgumentNotValidException exception) {
        logger.error("异常信息：", exception);
        // 获取异常信息
        BindingResult exceptions = exception.getBindingResult();
        // 判断异常中是否有错误信息，如果存在就使用异常中的消息，否则使用默认消息
        if (exceptions.hasErrors()) {
            List<ObjectError> errors = exceptions.getAllErrors();
            if (!errors.isEmpty()) {
                FieldError fieldError = (FieldError) errors.get(0);
                return commonHandler(ResultStatus.PARAM_ERROR.resultCode, fieldError.getDefaultMessage());
            }
        }
        return Result.buildFailure(ResultStatus.PARAM_ERROR);
    }

    /**
     * 参数校验异常处理（get方式）
     *
     * @param exception 异常
     * @return 返回类
     */
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseBody
    public Result parameterExceptionHandlerGet(ConstraintViolationException exception) {
        logger.error("异常信息：", exception);
        String message = exception.getMessage();
        String[] split = StrUtil.split(message, ",");
        String splitMessage = split[0];
        String errorMessage = StrUtil.subAfter(splitMessage, ":", false).trim();
        return commonHandler(ResultStatus.PARAM_ERROR.resultCode, errorMessage);
    }

    /**
     * 业务异常处理
     *
     * @param exception 异常
     * @return Result
     */
    @ExceptionHandler(value = ServiceException.class)
    @ResponseBody
    public Result errorHandler(ServiceException exception) {
        logger.error("异常信息：", exception);
        return commonHandler(exception.getResultCode(), exception.getMessage());
    }
}

