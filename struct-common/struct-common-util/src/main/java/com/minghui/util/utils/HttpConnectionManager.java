package com.minghui.util.utils;

import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpRequest;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.client.LaxRedirectStrategy;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.ssl.SSLContextBuilder;

import javax.net.ssl.SSLException;
import java.io.InterruptedIOException;
import java.net.UnknownHostException;
import java.util.Map;

/**
 * @Author:chenql
 * @Description: 基于httpclient 4.5版本实现,提供统一的http访问工具类,支持https访问
 * @Date:Created in 16:38 2019/3/21
 * @Modified By:
 */
@Builder
@Slf4j
public class HttpConnectionManager {

    private static PoolingHttpClientConnectionManager poolingHttpClientConnectionManager = null;

    private static LaxRedirectStrategy redirectStrategy = null;

    private static HttpRequestRetryHandler requestRetryHandler = null;

    private static SSLConnectionSocketFactory sslConnectionSocketFactory = null;

    private static Map<String,Object> headers;

    private static final Integer maxTotal = 300;

    private static final Integer maxPreRoute = 200;

    private static int connectTimeout;

    private static int socketTimeout;

    private static int connectionRequestTimeout;

    public static final long RELEASE_CONNECTION_WAIT_TIME = 5000;

    private final static Object syncLock = new Object();


    static{
        initHttpClient();
    }

    private static void initHttpClient() {

        try {
            // 重定向策略初始化
            redirectStrategy = new LaxRedirectStrategy();
            // 请求重试机制,默认关闭
            requestRetryHandler = (exception,executionCount,context)->{
                if (executionCount >= 3){
                    return false;
                }
                if (exception instanceof InterruptedIOException
                        || exception instanceof UnknownHostException
                        || exception instanceof ConnectTimeoutException
                        || exception instanceof SSLException){
                    return false;
                }
                HttpClientContext clientContext = HttpClientContext.adapt(context);
                HttpRequest request = clientContext.getRequest();
                boolean idempotent = !(request instanceof HttpEntityEnclosingRequest);
                if (idempotent){
                    return true;
                }
                return false;
            };
            SSLContextBuilder builder = new SSLContextBuilder();
            builder.loadTrustMaterial(null,new TrustSelfSignedStrategy());
            sslConnectionSocketFactory = new SSLConnectionSocketFactory(builder.build(),NoopHostnameVerifier.INSTANCE);
            Registry<ConnectionSocketFactory> registry = RegistryBuilder.<ConnectionSocketFactory>create()
                    .register("http",new PlainConnectionSocketFactory())
                    .register("https",sslConnectionSocketFactory).build();
            poolingHttpClientConnectionManager = new PoolingHttpClientConnectionManager(registry);
            poolingHttpClientConnectionManager.setDefaultMaxPerRoute(maxPreRoute);
            poolingHttpClientConnectionManager.setMaxTotal(maxTotal);
        }catch (Exception e){
            log.error("初始化httpclient连接池失败",e);
        }
    }


    public static CloseableHttpClient getHttpClient(){
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(connectTimeout)
                .setSocketTimeout(socketTimeout)
                // 忽略cookie,
                .setCookieSpec(CookieSpecs.IGNORE_COOKIES)
                .setConnectionRequestTimeout(connectionRequestTimeout)
                // 设置代理ip
                // .setProxy(ip)
                .build();
        // 连接池设置
        CloseableHttpClient httpClient = HttpClients.custom()
                .setSSLSocketFactory(sslConnectionSocketFactory)
                .setConnectionManager(poolingHttpClientConnectionManager)
                .setDefaultRequestConfig(requestConfig)
                .setRedirectStrategy(redirectStrategy)
                //不进行重试
//                .setRetryHandler(requestRetryHandler)
                .build();
        log.warn("当前活动的线程数量为:",poolingHttpClientConnectionManager.getTotalStats().getAvailable());
        System.out.println("当前活动的线程数量为:"+poolingHttpClientConnectionManager.getTotalStats().getAvailable());
        return httpClient;
    }

}
