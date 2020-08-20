package com.ropeok.exception;

/**
 * @Author:chenql
 * @Description:
 * @Date:Created in 18:29 2019-04-03
 * @Modified By:
 */
public class ServiceException extends NestableRuntimeException {

    private static final long serialVersionUID = 6837718024001171022L;

    public ServiceException(String message,Throwable cause){
        super(message,cause);
    }

    public ServiceException(String message){
        super(message);
    }
}
