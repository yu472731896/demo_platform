package com.ropeok.exception;

/**
 * @Author:chenql
 * @Description:
 * @Date:Created in 18:31 2019-04-03
 * @Modified By:
 */
public class ValidateRuntimeException extends NestableRuntimeException {

    private static final long serialVersionUID = -4351434024575400964L;

    public ValidateRuntimeException(String msg) {
        super(msg);
    }

    public ValidateRuntimeException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
