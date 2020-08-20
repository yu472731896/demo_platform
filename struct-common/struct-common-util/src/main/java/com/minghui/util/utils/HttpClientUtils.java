package com.minghui.util.utils;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.http.MediaType;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author:chenql
 * @Description:
 * @Date:Created in 16:44 2019/3/21
 * @Modified By:
 */
@Slf4j
public class HttpClientUtils {

    public static final int CONNECTION_TIMEOUT = 30000;

    public static final int SOCKET_TIMEOUT = 30000;

    /**
     * <p>Description:[将Map转成url参数格式]</p>
     * Created on 2019/3/21 16:45
     * 
     * @param paramMap
     * @return java.lang.String 
     * @author chenql
     */
    public static String getConcatUrlParam(Map<String, Object> paramMap) {
        StringBuffer sb = new StringBuffer();
        for (String key : paramMap.keySet()) {
            if (paramMap.get(key) != null) {
                sb.append("&");
                sb.append(key);
                sb.append("=");
                sb.append(paramMap.get(key));
            }
        }
        return StringUtils.isBlank(sb.toString())?"":StringUtils.substring(sb.toString(), 1);
    }

    /**
     * <p>Description:[jsonObject发送对象]</p>
     * Created on 2019/3/21 16:47
     *
     * @param url
     * @param jsonParam
     * @return java.lang.String
     * @author chenql
     */
    public static String httpPost(String url, JsonObject jsonParam) throws Exception {
        return httpPost(url,jsonParam,null);
    }

    public static String httpPost(String url, JsonObject jsonParam, Map<String,String> headers) throws Exception {
        String result = null;
        if(jsonParam == null){
            return null;
        }
        long start = System.currentTimeMillis();
        CloseableHttpClient client = HttpConnectionManager.getHttpClient();
        HttpPost httpPost = new HttpPost(url);
        StringEntity entity = new StringEntity(jsonParam.toString(),"utf-8");
        entity.setContentEncoding("utf-8");
        entity.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        httpPost.setEntity(entity);
        if (headers != null && !headers.isEmpty()){
            for (Map.Entry entry:headers.entrySet()){
                httpPost.addHeader(String.valueOf(entry.getKey()),String.valueOf(entry.getValue()));
            }
        }
        CloseableHttpResponse response = client.execute(httpPost);
        result = EntityUtils.toString(response.getEntity(),"utf-8");
        EntityUtils.consume(response.getEntity());
        long end = System.currentTimeMillis() - start;
        if(log.isDebugEnabled()){
            log.debug("this's connect cost {},param's -> {},result's -> {}",end,jsonParam.toString(),result);
        }
        return result;
    }



    /**
     * <p>Description:[post请求传输,使用textbody格式]</p>
     * Created on 2019/3/21 16:47
     *
     * @param url
     * @param map
     * @return java.lang.String
     * @author chenql
     */
    public static String httpPost(String url,Map<String,String> map) throws Exception {
        return httpPost(url,map,null);
    }

    public static String httpPost(String url,Map<String,String> map,Map<String,String> headers) throws Exception {
        String result = null;
        if(CollectionUtils.isEmpty(map)){
            return null;
        }
        long start = System.currentTimeMillis();
        CloseableHttpClient client = HttpConnectionManager.getHttpClient();
        HttpPost httpPost = new HttpPost(url);
        MultipartEntityBuilder multipartEntityBuilder = MultipartEntityBuilder.create();
        for (Map.Entry e:map.entrySet()){
            if(e.getKey() != null && e.getValue() != null){
                multipartEntityBuilder.addTextBody(e.getKey().toString(),e.getValue().toString(),ContentType.APPLICATION_FORM_URLENCODED);
            }
        }
        httpPost.setEntity(multipartEntityBuilder.build());
        if (headers != null && !headers.isEmpty()){
            for (Map.Entry entry:headers.entrySet()){
                httpPost.addHeader(String.valueOf(entry.getKey()),String.valueOf(entry.getValue()));
            }
        }        HttpResponse response = client.execute(httpPost);
        result = EntityUtils.toString(response.getEntity(),"utf-8");
        EntityUtils.consume(response.getEntity());
        long end = System.currentTimeMillis() - start;
        if(log.isDebugEnabled()){
            log.debug("this's connect cost {},param's -> {},result's -> {}",end,new Gson().toJson(map),result);
        }
        return result;
    }




    /**
     * <p>Description:[post请求传输String参数,例如:name=张三&sex=男...]</p>
     * Created on 2019/3/21 16:50
     *
     * @param url
     * @param params
     * @return java.lang.String
     * @author chenql
     */
    public static String httpPost(String url,String params) throws Exception{
        return httpPost(url,params,null);
    }

    public static String httpPost(String url,String params,Map<String,String> headers) throws Exception{
        String result = null;
        if(StringUtils.isBlank(params)){
            return null;
        }
        long start = System.currentTimeMillis();
        CloseableHttpClient client = HttpConnectionManager.getHttpClient();
        HttpPost httpPost = new HttpPost(url);
        StringEntity entity = new StringEntity(params,"utf-8");
        entity.setContentEncoding("utf-8");
        entity.setContentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE);
        httpPost.setEntity(entity);
        if (headers != null && !headers.isEmpty()){
            for (Map.Entry entry:headers.entrySet()){
                httpPost.addHeader(String.valueOf(entry.getKey()),String.valueOf(entry.getValue()));
            }
        }        CloseableHttpResponse response = client.execute(httpPost);
        result = EntityUtils.toString(response.getEntity(),"utf-8");
        EntityUtils.consume(response.getEntity());
        long end = System.currentTimeMillis() - start;
        if(log.isDebugEnabled()){
            log.debug("this's connect cost {},param's -> {},result's -> {}",end,params,result);
        }
        return result;
    }



    /**
     * <p>Description:[提供get请求]</p>
     * Created on 2019/3/21 16:51
     *
     * @param url
     * @return java.lang.String
     * @author chenql
     */
    public static String httpGet(String url) throws Exception {
        return httpGet(url,null);
    }

    public static String httpGet(String url,Map<String,String> headers) throws Exception {
        String result = null;
        long start = System.currentTimeMillis();
        CloseableHttpClient client = HttpConnectionManager.getHttpClient();
        // 发送get请求
        HttpGet get = new HttpGet(url);
        if (headers != null && !headers.isEmpty()){
            for (Map.Entry entry:headers.entrySet()){
                get.addHeader(String.valueOf(entry.getKey()),String.valueOf(entry.getValue()));
            }
        }        CloseableHttpResponse response = client.execute(get);
        // 读取服务器返回过来的字符串结果
        HttpEntity entity = response.getEntity();
        result = EntityUtils.toString(entity,"utf-8");
        // 会自动释放连接
        EntityUtils.consume(entity);
        long end = System.currentTimeMillis() - start;
        if(log.isDebugEnabled()){
            log.debug("this's connect cost {},param's -> {},result's -> {}",end,result);
        }
        return result;
    }

    /**
     * <p>Description:[]</p>
     * Created on 2019/3/21 16:51
     * 
     * @param url
     * @param contentType
     * @return java.lang.String 
     * @author chenql
     */
    public static String httpPostNoParam(String url,String contentType) throws Exception {
        return httpPostNoParam(url,contentType,null);
    }

    public static String httpPostNoParam(String url,String contentType,Map<String,String> headers) throws Exception {
        if(StringUtils.isBlank(url) || StringUtils.isBlank(contentType)){
            throw new RuntimeException("请求参数不允许为空!");
        }
        long start = System.currentTimeMillis();
        String result = "";
        CloseableHttpClient httpClient = HttpConnectionManager.getHttpClient();
        List<BasicNameValuePair> list = new ArrayList<>();
        HttpPost httpPost = new HttpPost(url);
        if (headers != null && !headers.isEmpty()){
            for (Map.Entry entry:headers.entrySet()){
                httpPost.addHeader(String.valueOf(entry.getKey()),String.valueOf(entry.getValue()));
            }
        }        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list,"utf-8");
        entity.setContentType(contentType);
        httpPost.setEntity(entity);
        CloseableHttpResponse response = httpClient.execute(httpPost);
        result = EntityUtils.toString(response.getEntity(),"utf-8");
        EntityUtils.consume(response.getEntity());
        long end = System.currentTimeMillis() - start;
        if(log.isDebugEnabled()){
            log.debug("this's connect cost {},param's -> {},result's -> {}",end,result);
        }
        return result;
    }


    public static Object sendPost(String url,String contentType,Class claz) throws Exception {
        Gson gson = new Gson();
        String result = httpPostNoParam(url,contentType);
        if(log.isDebugEnabled()){
            log.debug("请求路径:{},请求参数:{},请求结果:{}",url,result);
        }
        try {
            if(StringUtils.isNotBlank(result)){
                return gson.fromJson(result,claz);
            }
        }catch (Exception e){
            throw new RuntimeException("返回请求结果为:"+result+",转换实体异常.",e);
        }
        return null;
    }

    public static Object sendPost(String url,String contentType,Class claz,Map<String,String> headers) throws Exception {
        Gson gson = new Gson();
        String result = httpPostNoParam(url,contentType,headers);
        if(log.isDebugEnabled()){
            log.debug("请求路径:{},请求参数:{},请求结果:{}",url,result);
        }
        try {
            if(StringUtils.isNotBlank(result)){
                return gson.fromJson(result,claz);
            }
        }catch (Exception e){
            throw new RuntimeException("返回请求结果为:"+result+",转换实体异常.",e);
        }
        return null;
    }



    public static Object sendPostByBean(String url, Object o,Class claz) throws Exception {
        Gson gson = new Gson();
        String result = httpPost(url,gson.toJsonTree(o).getAsJsonObject());
        if(log.isDebugEnabled()){
            log.debug("请求路径:{},请求参数:{},请求结果:{}",url,gson.toJson(o),result);
        }
        try {
            if(StringUtils.isNotBlank(result)){
                return gson.fromJson(result,claz);
            }
        }catch (Exception e){
            throw new RuntimeException("返回请求结果为:"+result+",转换实体异常.",e);
        }
        return null;
    }

    public static Object sendPostByBean(String url, Object o,Class claz,Map<String,String> headers) throws Exception {
        Gson gson = new Gson();
        String result = httpPost(url,gson.toJsonTree(o).getAsJsonObject(),headers);
        if(log.isDebugEnabled()){
            log.debug("请求路径:{},请求参数:{},请求结果:{}",url,gson.toJson(o),result);
        }
        try {
            if(StringUtils.isNotBlank(result)){
                return gson.fromJson(result,claz);
            }
        }catch (Exception e){
            throw new RuntimeException("返回请求结果为:"+result+",转换实体异常.",e);
        }
        return null;
    }

    public static Object sendPostByMap(String url, Map map, Class claz) throws Exception {
        Gson gson = new Gson();
        String result = httpPost(url,map);
        if(log.isDebugEnabled()){
            log.debug("请求路径:{},请求参数:{},请求结果:{}",url,gson.toJson(map),result);
        }
        try {
            if(StringUtils.isNotBlank(result)){
                return gson.fromJson(result,claz);
            }
        }catch (Exception e){
            throw new RuntimeException("返回请求结果为:"+result+",转换实体异常.",e);

        }
        return null;
    }


    public static Object sendPostByMap(String url, Map map, Class claz,Map<String,String> headers) throws Exception {
        Gson gson = new Gson();
        String result = httpPost(url,map,headers);
        if(log.isDebugEnabled()){
            log.debug("请求路径:{},请求参数:{},请求结果:{}",url,gson.toJson(map),result);
        }
        try {
            if(StringUtils.isNotBlank(result)){
                return gson.fromJson(result,claz);
            }
        }catch (Exception e){
            throw new RuntimeException("返回请求结果为:"+result+",转换实体异常.",e);

        }
        return null;
    }

    public static Object sendPostByStr(String url,String params,Class claz) throws Exception {
        Gson gson = new Gson();
        String result = httpPost(url,params);
        if(log.isDebugEnabled()){
            log.debug("请求路径:{},请求参数:{},请求结果:{}",url,params,result);
        }
        try {
            if(StringUtils.isNotBlank(result)){
                return gson.fromJson(result,claz);
            }
        }catch (Exception e){
            throw new RuntimeException("返回请求结果为:"+result+",转换实体异常.",e);

        }
        return null;
    }

    public static Object sendPostByStr(String url,String params,Class claz,Map<String,String> headers) throws Exception {
        Gson gson = new Gson();
        String result = httpPost(url,params,headers);
        if(log.isDebugEnabled()){
            log.debug("请求路径:{},请求参数:{},请求结果:{}",url,params,result);
        }
        try {
            if(StringUtils.isNotBlank(result)){
                return gson.fromJson(result,claz);
            }
        }catch (Exception e){
            throw new RuntimeException("返回请求结果为:"+result+",转换实体异常.",e);

        }
        return null;
    }

    public static Object sendGet(String url,Class claz) throws Exception {
        Gson gson = new Gson();
        String result = httpGet(url);
        if(log.isDebugEnabled()){
            log.debug("请求路径:{},请求参数:{},请求结果:{}",url,result);
        }
        try {
            if(StringUtils.isNotBlank(result)){
                return gson.fromJson(result,claz);
            }
        }catch (Exception e){
            throw new RuntimeException("返回请求结果为:"+result+",转换实体异常.",e);

        }
        return null;
    }

    public static Object sendGet(String url,Class claz,Map<String,String> headers) throws Exception {
        Gson gson = new Gson();
        String result = httpGet(url,headers);
        if(log.isDebugEnabled()){
            log.debug("请求路径:{},请求参数:{},请求结果:{}",url,result);
        }
        try {
            if(StringUtils.isNotBlank(result)){
                return gson.fromJson(result,claz);
            }
        }catch (Exception e){
            throw new RuntimeException("返回请求结果为:"+result+",转换实体异常.",e);

        }
        return null;
    }

}
