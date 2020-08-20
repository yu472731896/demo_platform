package com.minghui.redis.constant;

/**
 * 设备抓拍相关redis常量定义
 * @author zjk
 * @date 2019年4月1日上午11:54:06
 */
public class CptRedisConstants {

	/**
	 * 设备抓拍每日统计相关redis键前缀定义，其中DD为Device Daily简拼
	 * @author zjk
	 * @date 2019年4月1日下午6:35:11
	 */
	public static class RedisKeyPre {
		/**
		 * 设备抓拍总量每日统计redis缓存键key前缀定义，数据类型为string
		 */
		public static final String DD_CAPTURE_COUNT_TOTAL = "cps_total_";
		/**
		 * 设备抓拍流量每日统计redis缓存键key前缀定义，数据类型为string
		 */
		public static final String DD_CAPTURE_COUNT_HOURLY = "cps_hourly_";
		/**
		 * 未知身份抓拍次数每日统计redis缓存键key前缀定义，数据类型为string
		 */
		public static final String DD_CAPTURE_COUNT_UNIDENTITY = "cps_unidentity_";
		/**
		 * 标签人员抓拍次数每日统计redis缓存键key前缀定义，数据类型为string
		 */
		public static final String DD_CAPTURE_COUNT_DLABEL = "cps_dlabel_";
		/**
		 * 标签人员抓拍次数每日统计redis缓存键key前缀定义，数据类型为string
		 */
		public static final String DD_CAPTURE_COUNT_SLABEL = "cps_slabel_";
		/**
		 * 动态比对已知身份抓拍次数每日统计redis缓存键key前缀定义，数据类型为string
		 */
		public static final String DD_CAPTURE_COUNT_DIDENTITY = "cps_didentity_";
		/**
		 * 静态比对已知身份抓拍次数每日统计redis缓存键key前缀定义，数据类型为string
		 */
		public static final String DD_CAPTURE_COUNT_SIDENTITY = "cps_sidentity_";
		/**
		 * 告警次数每日统计redis缓存键key前缀定义，数据类型为string
		 */
		public static final String DD_CAPTURE_COUNT_ALARM = "cps_alarm_";
	}
	
}
