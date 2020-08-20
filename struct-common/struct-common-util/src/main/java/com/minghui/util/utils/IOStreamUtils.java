package com.minghui.util.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;

import java.io.*;

/**
 * @Author:chenql
 * @Description:
 * @Date:Created in 17:44 2018-10-24
 * @Modified By:
 */
@Slf4j
public class IOStreamUtils {

    final static int BUFFER_SIZE = 4096;

    public static String inputStreamToString(InputStream inputStream) throws IOException{
        return IOUtils.toString(inputStream,"utf-8");
    }

    public static String inputStreamToBase64Str(InputStream in) throws IOException {
        return Base64ToImgUtils.getBase64Str(IOUtils.toByteArray(in));
    }

    public static InputStream StringToInputStream(String in) throws IOException {
        return StringToInputStream(in,"utf-8");
    }

    public static InputStream StringToInputStream(String in,String encoding) throws IOException {
        return IOUtils.toInputStream(in,encoding);
    }

    public static void closeStreams(Closeable... streams){
        if(streams != null && streams.length >0){
            for (Closeable stream:streams){
                if (stream != null) {
                    try {
                        stream.close();
                    } catch (IOException e) {
                        log.error("",e);
                    }
                }
            }
        }
    }

    public static void closeStream(Closeable stream){
        if (stream != null){
            try {
                stream.close();
            } catch (IOException e) {
                log.error("",e);
            }
        }
    }

    public static String getJsonData(File file) throws IOException {
        String str = "";
        InputStream is = null;
        try{
            is = new FileInputStream(file);
           /* byte[] bytes = new byte[2048];
            int n = -1;
            while((n = is.read(bytes,0,bytes.length)) != -1){
                 str = new String(bytes,0,n,"GBK");
                System.out.println(str);
            }*/
        } catch (Exception e){
            log.error("",e);
        }
        return inputStreamToString(is);

    }
}
