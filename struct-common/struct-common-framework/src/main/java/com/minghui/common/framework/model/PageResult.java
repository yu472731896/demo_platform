package com.minghui.common.framework.model;

import com.minghui.exception.constant.ErrorCodeConstant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Classname:PageResult
 * @Auther:chenqinglin
 * @Date:2019/1/14 18:33
 * @Version: 1.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PageResult<T> implements Serializable {

    private static final long serialVersionUID = 1056465346126486913L;

    private int code;

    private String message;

    private boolean success;

    private T result;

    /**
     * <p>Description:[返回成功消息]</p>
     * Created on 2019-02-21 11:06
     *
     * @param obj
     * @return com.ropeok.common.framework.model.PageResult
     * @author chenql
     */
    public static PageResult ok(Object obj){
        PageResult pageResult = new PageResult();
        pageResult.setSuccess(true);
        pageResult.setCode(200);
        pageResult.setResult(obj);
        return pageResult;
    }

    /**
     * <p>Description:[成功结果]</p>
     * Created on 2019-02-21 11:31
     *
     * @param obj
     * @param message
     * @return com.ropeok.common.framework.model.PageResult
     * @author chenql
     */
    public static PageResult ok(Object obj, String message){
        PageResult pageResult = new PageResult();
        pageResult.setSuccess(true);
        pageResult.setCode(200);
        pageResult.setResult(obj);
        pageResult.setMessage(message);
        return pageResult;
    }


    /**
     * <p>Description:[异常结果]</p>
     * Created on 2019-02-21 11:31
     *
     * @param message
     * @return com.ropeok.common.framework.model.PageResult
     * @author chenql
     */
    public static PageResult error(String message){
        PageResult pageResult = new PageResult();
        pageResult.setSuccess(false);
        pageResult.setCode(ErrorCodeConstant.DEFAULT_ERROR_CODE);
        pageResult.setMessage(message);
        return pageResult;
    }

    /**
     * <p>Description:[异常结果]</p>
     * Created on 2019-02-21 11:06
     *
     * @param errorCode
     * @param message
     * @return com.ropeok.common.framework.model.PageResult
     * @author chenql
     */
    public static PageResult error(int errorCode, String message){
        PageResult pageResult = new PageResult();
        pageResult.setSuccess(false);
        pageResult.setCode(errorCode);
        pageResult.setMessage(message);
        return pageResult;
    }

    /**
     * <p>Description:[失败结果]</p>
     * Created on 2019/4/2 9:50
     *
     * @param errorCode
     * @param obj
     * @param message
     * @return com.ropeok.common.framework.model.PageResult
     * @author chenql
     */
    public static PageResult error(int errorCode,Object obj, String message){
        PageResult pageResult = new PageResult();
        pageResult.setSuccess(false);
        pageResult.setCode(errorCode);
        pageResult.setResult(obj);
        pageResult.setMessage(message);
        return pageResult;
    }
}
