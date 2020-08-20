package com.ropeok.exception;

/**
 * @Author:chenql
 * @Description:
 * @Date:Created in 18:28 2019-04-03
 * @Modified By:
 */
public class ObjectNotFoundException extends DAOException {


    public ObjectNotFoundException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public ObjectNotFoundException(String msg) {
        super(msg);
    }
}
