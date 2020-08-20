package com.minghui.util.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/**
 * @Author:chenql
 * @Description: 此处使用jackjson来做转化
 * @Date:Created in 14:13 2019/3/21
 * @Modified By:
 */
public final class JsonUtil {

    public static final ObjectMapper MAPPER = new ObjectMapper();

    private static ThreadLocal<ObjectMapper> threadLocal = new ThreadLocal<ObjectMapper>();

    /**
     * <p>Description:[将对象转为json]</p>
     * Created on 2019/3/21 14:15
     *
     * @param obj
     * @return java.lang.String
     * @author chenql
     */
    public static String toJson(Object obj){
        try {
            return MAPPER.writeValueAsString(obj);
        }catch (JsonProcessingException e){
            throw new RuntimeException(e);
        }
    }

    /**
     * <p>Description:[将对象转为json(忽略为null的属性)]</p>
     * Created on 2019/7/24 10:31
     *
     * @param obj
     * @return java.lang.String
     * @author chenql
     */
    public static String toJsonIgnoreNull(Object obj){
        try {
            MAPPER.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            return MAPPER.writeValueAsString(obj);
        }catch (JsonProcessingException e){
            throw new RuntimeException(e);
        }
    }

    /**
     * <p>Description:[反序列化]</p>
     * Created on 2019/3/21 14:17
     *
     * @param json
     * @param claz
     * @return T
     * @author chenql
     */
    public static <T> T fromJson(String json,Class<T> claz){
        try {
            return MAPPER.readValue(json,claz);
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    /**
     * <p>Description:[反序列化]</p>
     * Created on 2019/3/21 14:19
     *
     * @param json
     * @param valueTypeRef
     * @return T
     * @author chenql
     */
    public static <T> T fromJson(String json, TypeReference<T> valueTypeRef){
        try {
            return MAPPER.readValue(json,valueTypeRef);
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }


    /**
     * <p>Description:[反序列化]</p>
     * Created on 2019/3/21 14:21
     *
     * @param stream
     * @param claz
     * @return T
     * @author chenql
     */
    public static <T> T fromJson(InputStream stream,Class<T> claz){
        try {
            return MAPPER.readValue(stream,claz);
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    /**
     * <p>Description:[对象转map]</p>
     * Created on 2019/7/20 16:22
     *
     * @param obj
     * @return java.util.Map<?,?>
     * @author chenql
     */
    public static Map<?,?> objToMap(Object obj){
        if (obj == null){
            return null;
        }
        try {
            Map<?,?> object = MAPPER.convertValue(obj,Map.class);
            return object;
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException(e);
        }
    }

    public static Object mapToObj(Map<String,Object> map,Class<?> claz){
        if (map == null){
            return null;
        }
        try {
            return MAPPER.convertValue(map,claz);
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException(e);
        }
    }

    public static String toJsonCustom(Object obj) {
        try {
            return getCustomMapper().writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    private static ObjectMapper getCustomMapper() {
        ObjectMapper customMapper = threadLocal.get();
        if (customMapper == null) {
            customMapper = new ObjectMapper();
            SimpleModule simpleModule = new SimpleModule();
            simpleModule.addSerializer(Long.class, ToStringSerializer.instance);
            simpleModule.addSerializer(Long.TYPE, ToStringSerializer.instance);
            customMapper.registerModule(simpleModule);
            threadLocal.set(customMapper);
        }
        return customMapper;
    }
}
