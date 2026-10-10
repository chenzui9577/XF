package cn.XF.common.exception;

import cn.XF.common.constant.ResultStatus;
import lombok.Data;

/**
 * 平台服务层异常，主要是在业务数据或者状态异常时使用
 *
 * @author cz
 **/
@Data
public class ServiceException extends RuntimeException {

    private String resultCode;

    public ServiceException(String message) {
        super(message);
        this.resultCode = ResultStatus.SERVER_ERROR.resultCode;
    }

    public ServiceException(String resultCode, String message) {
        super(message);
        this.resultCode = resultCode;
    }

    public ServiceException(String resultCode, String message, Throwable cause) {
        super(message, cause);
        this.resultCode = resultCode;
    }
}
