package cn.XF.common.constant;

/**
 * Result状态
 *
 * @author cz
 **/
public enum ResultStatus {
    SUCCESS("0000", "操作成功"),
    PARAM_ERROR("5001", "数据请求参数异常,详情参见msg返回信息"),
    SERVER_ERROR("5002", "服务不可用，请稍后重试"),
    RESOURCE_NOT_FOUND("5003", "资源未找到"),


    EXPIRATION_REQUEST("5025", "请求已超出有效期"),
    REPEATED_REQUEST("5026", "重复请求"),
    INVALID_SIGNATURE("5027", "无效签名"),
    INVALID_REMOTE_IP("5028", "无效请求IP地址"),
    INVALID_DATA_REQUEST("5029", "无效用户数据请求(数据不存在)"),
    NO_OPERATION_ALLOWED("5030", "不允许操作(特定业务场景不允许)"),
    SERVICE_INVOKE_ERROR("5031", "服务调用错误"),

    BAD_REQUEST("5400", "http 400错误,Bad Request"),
    METHOD_NOT_ALLOWED("5405", "http 405错误,Method Not Allowed"),
    UNSUPPORTED_MEDIA_TYPE("5415", "http 415错误,Unsupported Media Type"),
    INTERNAL_SERVER_ERROR("5500", "http 500错误,Internal Server Error"),
    ;


    public final String resultCode;
    public final String message;

    ResultStatus(String resultCode, String message) {
        this.resultCode = resultCode;
        this.message = message;
    }
}
