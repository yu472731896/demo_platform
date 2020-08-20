package com.minghui.util.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author YMH
 * @date 2019年03月30日
 */
public class StringUtil {

    /**
     * String 字符串转成List<Long>数据格式
     * "1,2,3" -> List<Long> [1,2,3]
     *
     * @params strArr 逗号分隔字符串
     * @return List<Long>
     * @author YMH
     * @date 2019/3/30 10:44
     */
    public static List<Long> stringToLongList(String strArr){
        return Arrays.stream(strArr.split(","))
                .map(s -> Long.parseLong(s.trim()))
                .collect(Collectors.toList());
    }
}
