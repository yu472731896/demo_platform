package com.minghui.redis.constant;

/**
 * @Author:chenql
 * @Description:
 * @Date:Created in 19:36 2019/4/24
 * @Modified By:
 */
public interface RedisCommonConstants {

    /**
     * 根据personImgId查询人员信息前缀
     */
    String PERSON_PREFIX = "PERSON_PREFIX_";

    /**
     * 考虑到多个服务不在本机,增加配置
     */
    String MULTI_SERVER_CONFIG = "MULTI_SERVER_CONFIG";

    /**
     * 配置过期时间4小时
     */
    long MULTI_SERVER_CONFIG_EXPIRE_TIME = 60 * 60 * 4;

    /**
     * 默认人员缓存2小时
     */
    long PERSON_EXPIRE_TIME = 60 * 60 * 2;

    /**
     * 静态入库缓存前缀
     */
    String STATIC_STORE_PERSON_PREFIX = "STATIC_STORE_PERSON_PREFIX_";
    
    /**
     * 动态入库缓存前缀
     */
    String DYNAMIC_STORE_PERSON_PREFIX = "DYNAMIC_STORE_PERSON_PREFIX_";

    /**
     * 系统设置比对阈值
     */
    String SYSTEM_COMPARE_SCOPE = "SYSTEM_COMPARE_SCOPE";

    /**
     * 图片转发开关
     */
    String PICTURE_REPOST = "PICTURE_REPOST";

    /**
     * 设备保活记录
     */
    String DEVICE_KEEP_ALIVE_PREFIX = "DEVICE_KEEP_ALIVE_PREFIX_";

    /**
     * 设备保活存redis的过期时间 (60s)
     */
    long DEVICE_KEEP_ALIVE_EXPIRE_TIME = 60;

    /**
     * 路人库在redis的最后时间戳
     */
    String STRANGER_STORE_PREFIX = "STRANGER_STORE_PREFIX_";

    /**
     * 路人库标识在redis的过期时间
     */
    long STRANGER_STORE_EXPIRE_TIME = 60 * 60 * 25;

    /**
     * 抓拍图最后删除的截止日志
     */
    String CAPTURE_PIC_LAST_DATE = "CAPTURE_PIC_LAST_DATE";

    /**
     * 引擎授权文件过期时间
     */
    long ENGINE_AUTHORATION_LICENSE_EXPIRE_TIME = 60 * 60 * 24 * 30;

    /**
     * license缓存前缀
     */
    String LICENSE_CACHE_PREFIX = "LICENSE_CACHE_PREFIX";

    /**
     * license缓存过期时间
     */
    long LICENSE_CACHE_EXPIRE_TIME = 60 * 60 * 24;

    /**
     * 更新底库人员redis前缀
     */
    String REPOSITORY_PERSON_MOD_PREFIX = "REPOSIROTY_PERSON_MOD_PREFIX_";

    /**
     * 底库人员redis过期时间
     */
    long REPOSITORY_PERSON_MOD_EXPIRE_TIME = 60 * 60;
}
