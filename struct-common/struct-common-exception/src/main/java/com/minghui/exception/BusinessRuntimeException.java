package com.ropeok.exception;

/**
 * @Author:chenql
 * @Description:
 * @Date:Created in 17:23 2019-04-03
 * @Modified By:
 */
public class BusinessRuntimeException extends CustomRuntimeException {

    private int stateCode = 999999999;

    public BusinessRuntimeException(){
        super("自定义运行异常,请联系系统管理员处理!");
    }

    public BusinessRuntimeException(int stateCode,String message){
        super(message);
        this.stateCode = stateCode;
    }

    public BusinessRuntimeException(int stateCode,String message,Throwable cause){
        super(message,cause);
        this.stateCode = stateCode;
    }

    public BusinessRuntimeException(int stateCode,Throwable cause){
        super(cause);
        this.stateCode = stateCode;
    }

    public BusinessRuntimeException(String message){
        super(message);
    }

    public BusinessRuntimeException(String message,Throwable cause){
        super(message,cause);
    }

    public BusinessRuntimeException(Throwable cause){
        super(cause);
    }

    public int getStateCode() {
        return stateCode;
    }

    public void setStateCode(int stateCode) {
        this.stateCode = stateCode;
    }
}
