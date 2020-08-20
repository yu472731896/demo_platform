package com.minghui.util.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.Objects;

/**
 * @Author:chenql
 * @Description:
 * @Date:Created in 18:26 2019-02-19
 * @Modified By:
 */
@Slf4j
public class ServletUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(ServletUtils.class);

    /**
     * <p>Description:[获取请求的ip地址]</p>
     * Created on 2019-02-19 18:27
     *
     * @param request
     * @return java.lang.String
     * @author chenql
     */
    public static String getIpAddr(HttpServletRequest request) {
        String ip = "";
        if (request != null) {
        	ip = request.getHeader("x-forwarded-for");
        	if (ip == null || ip.length() == 0 || " unknown ".equalsIgnoreCase(ip)) {
        		ip = request.getHeader("Proxy-Client-IP");
        	}
        	if (ip == null || ip.length() == 0 || " unknown ".equalsIgnoreCase(ip)) {
        		ip = request.getHeader("WL-Proxy-Client-IP");
        	}
        	if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
        		ip = request.getHeader("HTTP_CLIENT_IP");
        	}
        	if (ip == null || ip.length() == 0 || " unknown ".equalsIgnoreCase(ip)) {
        		ip = request.getHeader("HTTP_X_FORWORD_FOR");
        	}
        	if (ip == null || ip.length() == 0 || " unknown ".equalsIgnoreCase(ip)) {
        		ip = request.getHeader("X-Real-IP");
        	}
            if (ip == null || ip.length() == 0 || " unknown ".equalsIgnoreCase(ip)) {
                ip = request.getHeader("HTTP_X_FORWARDED_FOR");
            }
        	if (ip == null || ip.length() == 0 || " unknown ".equalsIgnoreCase(ip)) {
        		ip = request.getRemoteAddr();
        		if(StringUtils.equals("127.0.0.1",ip) || StringUtils.equals("0:0:0:0:0:0:0:1",ip)){
        			// 根据网卡获取
        			InetAddress inetAddress = null;
        			try {
        				inetAddress = InetAddress.getLocalHost();
        			}catch (UnknownHostException e){
        				LOGGER.error("获取网卡失败!",e);
        			}
        			if (inetAddress == null) {
        			    return "无法识别!";
                    }
        			ip = inetAddress.getHostAddress();
        		}
        	}
            if(ip != null && ip.indexOf(",") > 0){
                ip = ip.substring(0,ip.indexOf(","));
            }
        	if (StringUtils.isNotBlank(ip)){
        	    if (ip.indexOf("::ffff:") != -1){
                    if (ip.indexOf(",") != -1){
                        ip = ip.substring(7,ip.indexOf(","));
                    }else{
                        ip = ip.substring(7);
                    }
                }else if (ip.indexOf("::1, ") != -1){
                    ip = ip.replace("::1,","").trim();
                }
            }
        }
        return ip;
    }

    /**
     * <p>Description:[获取本机IP]</p>
     * Created on 2019-02-19 18:27
     *
     * @param
     * @return java.lang.String
     * @author chenql
     */
    public static String getHostIP(){
        try {
            Enumeration<NetworkInterface> netInterfaces = NetworkInterface.getNetworkInterfaces();
            while (netInterfaces.hasMoreElements()){
                NetworkInterface networkInterface = netInterfaces.nextElement();
                Enumeration<InetAddress> addresses = networkInterface.getInetAddresses();
                while (addresses.hasMoreElements()){
                    InetAddress inetAddress = addresses.nextElement();
                    if(!inetAddress.isLoopbackAddress()){
                        String ipAddress = inetAddress.getHostAddress();
                        if(!ipAddress.contains("::") && !ipAddress.contains("0:0:") && !ipAddress.contains("fe80")){
                            return ipAddress;
                        }
                    }
                }
            }
        }catch (Exception e){
            LOGGER.error("获取ip发生异常",e);
        }
        return null;
    }

    /**
     * <p>Description:[获取本机计算机名称]</p>
     * Created on 2019/4/9 18:33
     *
     * @param
     * @return java.lang.String
     * @author chenql
     */
    public static String getHostName(){
        try {
            InetAddress address = InetAddress.getLocalHost();
            return address.getHostName();
        }catch (Exception e){
            return "exception";
        }
    }

    /**
     * <p>Description:[将文件结果输出response]</p>
     * Created on 2019/7/20 12:29
     *
     * @param filePath
     * @param fileName
     * @param response
     * @return void
     * @author chenql
     */
    public static void writeResponseByFilePath(String filePath,String fileName, HttpServletResponse response) throws IOException {
        if (StringUtils.isBlank(filePath)){
            return;
        }
        File file = new File(filePath);
        if (file.exists()){
            response.setCharacterEncoding("UTF-8");
            response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
            response.addHeader("Content-Disposition", "attachment;filename="+ URLEncoder.encode(fileName,"utf-8"));
            response.setContentLengthLong(file.length());
            FileInputStream stream = new FileInputStream(file);
            // 防止一次性读取文件过大,导致内存溢出
            if (file.length() > 10240){
                OutputStream os = new BufferedOutputStream(response.getOutputStream());
                byte[] buf = new byte[1024];
                int i = -1;
                while ((i = stream.read(buf)) != -1){
                    os.write(buf,0,i);
                }
                os.flush();
                os.close();
            }else{
                IOUtils.copy(stream,response.getOutputStream());
            }
            stream.close();
            response.flushBuffer();
            if (file.delete()){
                LOGGER.warn("删除临时下载文件:{}",filePath);
            }
        }else {
            writeStrResponse("未找到下载文件!",response);
        }
    }

    /**
     * <p>Description:[将字符串输出到response]</p>
     * Created on 2019/7/24 12:01
     *
     * @param content
     * @param response
     * @return void
     * @author chenql
     */
    public static void writeStrResponse(String content, HttpServletResponse response) throws IOException {
        if (StringUtils.isBlank(content)){
            return;
        }
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        PrintWriter out = response.getWriter();
        out.print(content);
    }

    /**
     * <p>Description:[将字符串输出到response]</p>
     * Created on 2019/7/24 12:01
     *
     * @param obj
     * @param response
     * @return void
     * @author chenql
     */
    public static void writeObjectResponse(Object obj, HttpServletResponse response) throws IOException {
        if (Objects.isNull(obj)){
            return;
        }
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        PrintWriter out = response.getWriter();
        out.print(JsonUtil.toJson(obj));
    }

    /**
     * <p>Description:[将信息写入到log文件中,返回log文件在服务器的路径]</p>
     * Created on 2019/8/23 9:57
     *
     * @param message
     * @param fileName
     * @return java.lang.String
     * @author chenql
     */
    public static String createLogFileByMessage(String message, String fileName) {
        String srcDest = System.getProperty("java.io.tmpdir");
        String tempLogFile = srcDest + File.separator + fileName + "_" + System.currentTimeMillis() + ".log";
        PrintWriter pw = null;
        try {
            File file = new File(tempLogFile);
            pw = new PrintWriter(new FileOutputStream(file));
            pw.println(message);
        } catch (Exception e) {
            log.error("将异常日志写入出现异常!", e);
        } finally {
            IOStreamUtils.closeStream(pw);
        }
        return tempLogFile;
    }
}
