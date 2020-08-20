package com.ropeok.exception;

/**
 * @Author:chenql
 * @Description:
 * @Date:Created in 17:20 2019-04-03
 * @Modified By:
 */
public abstract class CustomRuntimeException extends  Exception{

    public CustomRuntimeException(){
        super("自定义运行异常,请联系系统管理员处理!");
    }

    public CustomRuntimeException(String message){
        super(message);
    }

    public CustomRuntimeException(Throwable cause){
        super(cause);
    }

    public CustomRuntimeException(String message,Throwable cause){
        super(message,cause);
    }
}
