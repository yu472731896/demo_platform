package com.minghui.exception.enmus;


import com.minghui.exception.constant.ErrorCodeConstant;

/**
 * @Author:chenql
 * @Description:
 * @Date:Created in 11:07 2019-02-21
 * @Modified By:
 */
public enum ErrorCodeEnum {

    /**
     * 请求成功
     */
    RESULT_SUCCESS(ErrorCodeConstant.SUCCESS_CODE,ErrorCodeConstant.SUCCESS_MESSAGE),

    /**
     * 业务异常
     */
    BUSSINESS_ERROR(ErrorCodeConstant.BUSSINESS_ERROR_CODE,ErrorCodeConstant.BUSSINESS_ERROR_MESSAGE),

    /**
     * 系统错误
     */
    SYSTEM_ERROR(ErrorCodeConstant.SYSTEM_ERROR_CODE,ErrorCodeConstant.SYSTEM_ERROR_MESSAGE);



    private Integer errorCode;

    private String message;

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    ErrorCodeEnum(Integer errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }
}
