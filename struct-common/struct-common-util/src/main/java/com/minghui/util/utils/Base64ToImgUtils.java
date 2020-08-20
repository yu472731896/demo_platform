package com.minghui.util.utils;

import org.apache.commons.codec.binary.Base64;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.*;

/**
 *
 * base64与图片转换工具类
 *
 * @author lhp 2016-11-24 下午03:46:26
 */
public class Base64ToImgUtils {

    /**
     * 将图片文件转化为字节数组字符串，并对其进行Base64编码处理
     *
     * @param fileName
     *            图片文件名称
     *@return
     *@author lhp 2016-11-29 上午08:35:02
     */
    public static String getImageStr(String fileName) {
        InputStream in = null;
        byte[] data = null;
        // 读取图片字节数组
        try {
            in = new FileInputStream(fileName);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new String(Base64.encodeBase64(data));
    }

    /**
     * 对字节数组字符串进行Base64解码并生成图片
     *
     * @param imgStr
     *            base64字符串
     *@param fileName
     *            文件名称
     *@return 是否生成成功
     *@author lhp 2016-11-29 上午08:34:27
     */
    public static boolean generateImage(String imgStr, String fileName) {
        if (imgStr == null) // 图像数据为空
            return false;
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            // Base64解码
            byte[] b = decoder.decodeBuffer(imgStr);
            for (int i = 0; i < b.length; ++i) {
                if (b[i] < 0) {// 调整异常数据
                    b[i] += 256;
                }
            }
            // 生成jpg图片
            OutputStream out = new FileOutputStream(fileName);
            out.write(b);
            out.flush();
            out.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 对字节数组字符串进行Base64解码并生成图片
     *
     * @param imgStr
     *            base64字符串
     *@param fileName
     *            文件名称
     *@return 是否生成成功
     *@author lhp 2016-11-29 上午08:34:27
     */
    public static byte[] generateImageByte(String imgStr) {
        if (imgStr == null) // 图像数据为空
            return null;
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            // Base64解码
            byte[] b = decoder.decodeBuffer(imgStr);
            for (int i = 0; i < b.length; ++i) {
                if (b[i] < 0) {// 调整异常数据
                    b[i] += 256;
                }
            }
            return b;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 将图片文件转化为字节数组字符串，并对其进行Base64编码处理
     *
     * @param fileName
     *            图片文件名称
     *@return
     *@author lhp 2016-11-29 上午08:35:02
     */
    public static String getBase64Str(byte[] by) {
        return Base64.encodeBase64String(by);
    }

    public static void main(String[] args) {
        System.out.println(new BASE64Encoder().encode("xxxxx"
                .getBytes()));
    }
}

