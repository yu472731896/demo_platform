package com.ropeok.exception;

/**
 * @Author:chenql
 * @Description:
 * @Date:Created in 18:31 2019-04-03
 * @Modified By:
 */
public class SystemRuntimeException extends NestableRuntimeException {

    private static final long serialVersionUID = 3232218557199326753L;

    private int stateCode = 999999999;

    public SystemRuntimeException(String msg) {
        super(msg);
    }

    public SystemRuntimeException(Throwable cause) {
        super(cause);
    }

    public SystemRuntimeException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public SystemRuntimeException(int stateCode){
        this.stateCode = stateCode;
    }

    public SystemRuntimeException(int stateCode,String message){
        super(message);
        this.stateCode = stateCode;
    }

    public SystemRuntimeException(int stateCode,Throwable cause){
        super(cause);
        this.stateCode = stateCode;
    }

    public SystemRuntimeException(int stateCode,String message,Throwable cause){
        super(message,cause);
        this.stateCode = stateCode;
    }

    public int getStateCode() {
        return stateCode;
    }

    public void setStateCode(int stateCode) {
        this.stateCode = stateCode;
    }
}
