package com.ropeok.log.monitor;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author:chenql
 * @Description: 日志埋点工具类
 * @Date:Created in 11:39 2019/4/9
 * @Modified By:
 */
@Slf4j
public class LogPointUtil {

    private LogPointUtil(){
        throw new IllegalStateException("Utility class");
    }

    public static final String SPLIT = "|";

    /**
     * <p>Description:[格式为:{时间}|{来源}|{对象id}|{类型}|{对象属性(以&分割)}
     * 例子1:2019-04-09 11:42:00|sys-server|1|users|ip=xxx.xxx.xxx.xxx&userName=张三
     * ]</p>
     * Created on 2019/4/9 11:41
     *
     * @param id
     * @param type
     * @param message
     * @return void
     * @author chenql
     */
    public static void info(String id,String type,String message){
        log.info(id + SPLIT + type + SPLIT + message);
    }
}
