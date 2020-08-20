package com.ropeok.exception;

/**
 * @Author:chenql
 * @Description:
 * @Date:Created in 18:21 2019-04-03
 * @Modified By:
 */
public class DAOException extends NestableRuntimeException {

    private static final long serialVersionUID = -493386896267059270L;

    public DAOException(String msg,Throwable cause){
        super(msg,cause);
    }

    public DAOException(String msg){
        super(msg);
    }
}
