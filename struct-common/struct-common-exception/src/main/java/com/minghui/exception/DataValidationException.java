package com.ropeok.exception;

/**
 * @Author:chenql
 * @Description:
 * @Date:Created in 18:22 2019-04-03
 * @Modified By:
 */
public class DataValidationException extends IgnoreLoggerCustomRuntimeException {

    public DataValidationException(){}

    public DataValidationException(String message){
        super(message);
    }

    public DataValidationException(String message,Throwable cause){
        super(message, cause);
    }

    public DataValidationException(Throwable cause){
        super(cause);
    }
}
