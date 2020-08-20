package com.minghui.redis.constant;

/**
 * 布控管理相关redis常量定义
 * @author zjk
 * @date 2019年4月1日上午11:54:06
 */
public class CtrRedisConstants {

	/**
	 * 布控报警相关redis键前缀定义
	 * @author zjk
	 * @date 2019年4月1日下午6:35:11
	 */
	public static class RedisKeyPre {
		/**
		 * 设备任务信息redis缓存键key前缀定义，数据类型为zset
		 */
		public static final String DEVICE_CODE_TO_TASK_ID = "ctr_d2t_";
		/**
		 * 人员图片ID对应任务ID信息redis缓存键key前缀定义，数据类型为set
		 */
		public static final String IMG_ID_TO_TASK_ID = "ctr_i2t_";
		/**
		 * 人员图片ID和任务ID关联布控库ID信息redis缓存键key前缀定义，数据类型为set
		 */
		public static final String IMG_ID_TASK_ID_TO_REPOSITORY_ID = "ctr_it2r_";
		/**
		 * 布控任务ID对应名称等级redis缓存键key前缀定义，数据类型为hash
		 */
		public static final String TASK_ID_TO_NAME_LEVEL = "ctr_t2nl_";
		/**
		 * 布控库ID对应库名称信息redis缓存键key前缀定义，数据类型为string
		 */
		public static final String REPOSITORY_ID_TO_NAME = "ctr_r2n_";

		/**
		 * 批量导入底库人员计数(成功)
		 */
		public static final String IMPORT_REPOSITORY_SUCCESS_PREFIX = "ipt_rep_s_";

		/**
		 * 批量导入底库人员计数(失败)
		 */
		public static final String IMPORT_REPOSITORY_FAIL_PREFIX = "ipt_rep_f_";

		/**
		 * 批量导入底库人员消息
		 */
		public static final String IMPORT_REPOSITORY_FAIL_MESSAGE_PREFIX = "ipt_rep_msg_";
	}
	
	/**
	 * 布控报警相关redis键失效时间定义
	 * @author zjk
	 * @date 2019年4月1日下午6:36:05
	 */
	public static class RedisKeyExpire {
		/**
		 * 一天失效时间（单位为秒）
		 */
		public static final long EXPIRE_DAY_ONE = 86400L;
		/**
		 * 十二小时失效时间（单位为秒）
		 */
		public static final long EXPIRE_HOUR_TWELVE = 43200L;
	}
	
	/**
	 * 布控报警相关redis的Hash类型属性键定义
	 * @author zjk
	 * @date 2019年4月13日下午3:49:52
	 */
	public static class RedisHashFieldKey {
		/**
		 * 布控任务ID对应名称等级redis属性键定义：任务名称
		 */
		public static final String FIELD_TASK_NAME = "task_name";
		/**
		 * 布控任务ID对应名称等级redis属性键定义：任务名称
		 */
		public static final String FIELD_TASK_LEVEL = "task_level";
		/**
		 * 布控任务ID对应名称等级redis属性键定义：报警语音ID
		 */
		public static final String FIELD_TASK_VOICE_ID = "task_voice_id";
	}
	
}
