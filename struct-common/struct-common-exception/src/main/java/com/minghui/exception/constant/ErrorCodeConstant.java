package com.minghui.exception.constant;

/**
 * @Author:chenql
 * @Description: 异常错误编码
 * @Date:Created in 11:12 2019-02-21
 * @Modified By:
 */
public class ErrorCodeConstant {

    /**
     * 请求成功编码
     */
    public static final int SUCCESS_CODE = 200;

    /**
     * 请求成功信息
     */
    public static final String SUCCESS_MESSAGE = "请求成功!";

    /**
     * 系统异常编码
     */
    public static final int SYSTEM_ERROR_CODE = 0;

    /**
     * 系统异常信息
     */
    public static final String SYSTEM_ERROR_MESSAGE = "系统异常!";

    /**
     * 业务异常编码
     */
    public static final int BUSSINESS_ERROR_CODE = 1;

    /**
     * 业务异常信息
     */
    public static final String BUSSINESS_ERROR_MESSAGE = "业务处理失败!";

    /**
     * 统一异常编码
     */
    public static final int DEFAULT_ERROR_CODE = 400;

    /**
     * 授权异常
     */
    public static final int AUTHORIZED_ERROR_CODE = 1000;

    /**
     * 权限不足
     */
    public static final int FORBIDDEN_ERROR_CODE = 403;

    /**
     * 找不到路径
     */
    public static final int NOT_FOUND_ERROR_CODE = 404;

    /**
     *
     */
    public static final int ERROR_CODE = 405;


}
