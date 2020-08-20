package com.minghui.redis.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.RedisConnectionUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ScanOptions;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:chenql
 * @Description:
 * @Date:Created in 10:26 2019/5/31
 * @Modified By:
 */
@Slf4j
public class RedisUtil {

    public static List<String> findKeysForPage(RedisTemplate redisTemplate,String patternKey, int pageNum, int pageSize) {
        ScanOptions options = ScanOptions.scanOptions().match(patternKey).build();
        RedisConnectionFactory factory = redisTemplate.getConnectionFactory();
        RedisConnection rc = factory.getConnection();
        Cursor<byte[]> cursor = rc.scan(options);
        List<String> result = new ArrayList<String>(pageSize);
        int tmpIndex = 0;
        int startIndex = (pageNum - 1) * pageSize;
        int end = pageNum * pageSize;
        while (cursor.hasNext()) {
            if (tmpIndex >= startIndex && tmpIndex < end) {
                result.add(new String(cursor.next()));
                tmpIndex++;
                continue;
            }
            // 获取到满足条件的数据后,就可以退出了
            if(tmpIndex >=end) {
                break;
            }
            tmpIndex++;
            cursor.next();
        }
        try {
            // cursor.close();
        } catch (Exception e) {
            log.error("",e);
        }
        try {
            RedisConnectionUtils.releaseConnection(rc, factory);
        } catch (Exception e) {
            log.error("",e);
        }
        return result;
    }
}
