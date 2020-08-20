package com.ropeok.exception;


import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.List;

/**
 * @Author:chenql
 * @Description:
 * @Date:Created in 18:23 2019-04-03
 * @Modified By:
 */
public class IgnoreLoggerCustomRuntimeException extends IllegalArgumentException {

    private List<String> errorMessages;

    public IgnoreLoggerCustomRuntimeException(){}

    public IgnoreLoggerCustomRuntimeException(String message){
        super(message);
        this.errorMessages = Arrays.asList(message);
    }

    public IgnoreLoggerCustomRuntimeException(String message,Throwable cause){
        super(message, cause);
        this.errorMessages = Arrays.asList(message);
    }

    public IgnoreLoggerCustomRuntimeException(Throwable cause){
        super(cause);
    }

    public IgnoreLoggerCustomRuntimeException(String message,String[] reset){
        super(message);
        this.errorMessages = Lists.asList(message,reset);
    }

    public List<String> getErrorMessages(){
        return this.errorMessages;
    }
}
