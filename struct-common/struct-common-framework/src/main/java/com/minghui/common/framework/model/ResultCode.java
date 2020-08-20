package com.minghui.common.framework.model;

/**
 * @Classname:ResuleCodeEnum
 * @Auther:chenqinglin
 * @Date:2018/12/13 20:49
 * @Version: 1.0
 */
public enum ResultCode implements IErrorCode{

    SUCCESS(0, "操作成功"),
    ERROR(1, "操作失败"),
    VALIDATE_FAILED(404, "参数检验失败"),
    UNAUTHORIZED(401, "暂未登录或token已经过期"),
    FORBIDDEN(403, "没有相关权限");

    private int code;

    private String message;

    ResultCode(Integer code){
        this.code = code;
    }

    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
