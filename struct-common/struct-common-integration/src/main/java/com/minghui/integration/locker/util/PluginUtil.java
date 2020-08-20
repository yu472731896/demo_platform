package com.ropeok.integration.locker.util;

import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

import java.lang.reflect.Proxy;

/**
 * @Author:chenql
 * @Description:
 * @Date:Created in 17:37 2018/5/9
 * @Modified By:
 */
public class PluginUtil {

    private PluginUtil(){}

    /**
     * @Author:chenql
     * @Description: 如果有多个plugin,那么可能导致出问题
     * @Date: 17:50 2018/5/9
     */
    public static Object processTarget(Object target){
        if(Proxy.isProxyClass(target.getClass())){
            MetaObject metaObject = SystemMetaObject.forObject(target);
            return processTarget(metaObject.getValue("h.target"));
        }
        return target;
    }
}
