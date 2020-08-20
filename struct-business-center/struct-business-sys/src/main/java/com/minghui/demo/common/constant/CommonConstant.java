package com.minghui.demo.common.constant;

import java.util.ArrayList;
import java.util.List;

/**
 * 公用常量定义，非业务相关
 * @author zjk
 * @date 2019年4月8日下午3:53:01
 */
public class CommonConstant {

	/**
	 * 系统内置用户system的id
	 */
	public static final Long SYSTEM_USER_ID = 99999l;

	/**
	 * 系统内置用户system的名称
	 */
	public static final String SYSTEM_USER_NAME = "system";

	/**
	 * 默认的系统用户,不进行禁用和超期限制
	 */
	public static final List<String> MANAGER_USER = new ArrayList<String>(){
		{
			add("admin");
			add("system");
		}
	};

	/**
	 * 单个底库数量.超过这个数量,需要进行分组处理
	 */
	public static final int SINGLE_REPOSIROTY_MAX_SIZE = 10000;

	/**
	 * 单个线程下载照片数
	 */
	public static final int DEFAULT_BATCH_DOWNLOAD_IMAGE_SIZE = 100;

	/**
	 * 默认导出最大限制
	 */
	public static final int DEFAULT_EXPORT_MAX_SIZE = 5000;

	/**
	 * 虚拟的组织id,用来表示需要查询改节点下的所有子节点信息
	 */
	public static final long VIRTUAL_DEPARTMENT_ID = 9999999l;

	/**
	 * 账号登录管理信息提醒
	 */
	public final static class UserAuthorizedRemind {

		public static final String USER_NOT_EXIST = "该账号不存在!";

		/**
		 * 用户禁用提醒
		 */
		public static final String USER_STAT_DISABLE_REMIND_MESSAGE = "该账号已停用，请联系管理员!";

		/**
		 * 用户未生效提醒
		 */
		public static final String USER_UN_EFFECT_REMIND_MESSAGE = "该账号将于[%s]生效,如需提前使用,请联系系统管理员!";

		/**
		 * 用户过期提醒
		 */
		public static final String USER_EXPIRED_REMIND_MESSAGE = "该账号已失效,如需继续使用,请联系系统管理员";

		/**
		 * 用户IP绑定提醒
		 */
		public static final String USER_BIND_ADDR_REMIND_MESSAGE = "当前IP为[%s]与该账号绑定的IP不一致，如需修改,请联系管理员!";

		/**
		 * 用户下线提醒
		 */
		public static final String USER_DOWNLINE_REMIND_MESSAGE = "当前账号已经在[%s]登录,请重新登录!";
	}

	/**
	 * 授权文件提醒
	 */
	public final static class LicenseAuthorizedRemind{

		/**
		 * 未检测到/未解析成功 授权文件情况
		 */
		public static final String UNKNOW_LICENSE_FILE_REMIND_MESSAGE = "系统未授权,请导入授权文件!";

		/**
		 * 授权未生效
		 */
		public static final String LICENSE_FILE_UN_EFFECT_REMIND_MESSAGE = "系统授权将于[%s]生效,目前暂时无法使用!";

		/**
		 * 授权到期
		 */
		public static final String LICENSE_FILE_EXPIRED_REMIND_MESSAGE = "您的授权已过期,如需继续使用,请联系我司售后人员!";

		/**
		 * 授权文件与本机不一致
		 */
		public static final String LICENSE_FILE_INCONSISTENT_FOR_COMPUTER_REMIND_MESSAGE = "您的授权文件与本机信息不匹配,请导入新的授权文件!";
	}

	/**
	 * 模块定义
	 */
	public static class MoudelName {

		/**
		 * 实时关注
		 */
		public static final String REAL_TIME_ATTENTION_CODE = "1";

		/**
		 * 历史告警
		 */
		public static final String HISTORY_ALARM_CODE = "2";

		/**
		 * 布控管理
		 */
		public static final String EXECUTE_CONTROL_MANAGER_CODE = "3";

		/**
		 * 人员抓拍记录
		 */
		public static final String PERSON_CAPUTRE_NOTE_CODE = "4";

		/**
		 * 底库管理
		 */
		public static final String BOTTOM_BANK_MANGER_CODE = "5";

		/**
		 * 火眼
		 */
		public static final String FIRE_EYE_CODE ="6";

		/**
		 * 设备管理
		 */
		public static final String DEVICE_MANAGER_CODE = "7";

		/**
		 * 用户管理
		 */
		public static final String USER_MANAGER_CODE = "8";

		/**
		 * 角色管理
		 */
		public static final String ROLE_MANAGER_CODE = "9";

		/**
		 * 人员标签管理
		 */
		public static final String PERSON_LABEL_MANAGER_CODE = "10";

		/**
		 * 字典管理
		 */
		public static final String DICTIONARY_MANAGER_CODE = "11";

		/**
		 * 系统配置
		 */
		public static final String SYSTEM_CONFIG_MANAGER_CODE = "12";

		/**
		 * 日志管理
		 */
		public static final String LOG_MANAGER_CODE = "13";

		/**
		 * 资源总览
		 */
		public static final String RESOURCE_VIEW_CODE = "14";

		/**
		 * 设备标签
		 */
		public static final String DEVICE_LABEL_MANAGER_CODE = "15";

		/**
		 * 系统资源运维
		 */
		public static final String SYSTEM_RESOURCE_VIEW_CODE = "16";

		/**
		 * 设备信息
		 */
		public static final String DEVICE_INFO = "17";

		/**
		 * 兴趣点
		 */
		public static final String POI_INFO = "18";

		/**
		 * 兴趣点设备
		 */
		public static final String POI_DEVICE = "19";

		/**
		 * poi类型
		 */
		public static final String POI_TYPE = "20";

		/**
		 * 安保活动
		 */
		public static final String SECURITY_ACTIVITY = "21";

		/**
		 * 安保活动设备
		 */
		public static final String SECURITY_ACTIVITY_DEVICE = "22";

		/**
		 * 搜索记录
		 */
		public static final String SEARCH_LOG = "23";

		/**
		 * 设备所属节点
		 */
		public static final String DEVICE_ATTRIBUTION = "24";

		/**
		 * 告警信息
		 */
		public static final String ALARM_INFO = "25";

		/**
		 * poi类型访问记录
		 */
		public static final String POI_TYPE_HISTORY = "26";

	}

	/**
	 * 分隔符常量定义
	 * @author zjk
	 * @date 2019年4月8日下午3:55:01
	 */
	public static class Separator {
		/**
		 * 英文逗号
		 */
		public static final String SPLIT_EN_COMMA = ",";
		/**
		 * 英文空格
		 */
		public static final String SPLIT_EN_BLANK = " ";
		/**
		 * 英文分号
		 */
		public static final String SPLIT_EN_SEMICOLON = ":";
		/**
		 * 英文下划线
		 */
		public static final String SPLIT_EN_UNDERLINE = "_";
	}

	/**
	 * 批次大小常量定义
	 * @author zjk
	 * @date 2019年4月8日下午3:54:54
	 */
	public static class BatchSize {
		/**
		 * 10
		 */
		public static final int TEN = 10;
		/**
		 * 20
		 */
		public static final int TWENTY = 20;
		/**
		 * 100
		 */
		public static final int ONE_HUNDRED = 100;
		/**
		 * 1000
		 */
		public static final int ONE_THOUSAND = 1000;
	}

	public static class RepositoryInfoConstant{

		/**
		 * 默认的remindid,表示不需要刷新底库人员
		 */
		public static final String DEFAULT_REMIND_ID = "0000000000";

		public static final String UPDATE_PERSON_COUNT = "personCount";

		public static final String UPDATE_IMG_COUNT = "imgCount";

		/**
		 * 普通布控
		 */
		public static final String ORDINARY_TASK_TYPE = "1";

		/**
		 * 高级布控
		 */
		public static final String HIGH_TASK_TYPE = "2";

		/**
		 * 手动或者导入
		 */
		public static final String PERSON_HANDLE_REMIN_TYPE = "0";

		/**
		 * 底库关联
		 */
		public static final String PERSON_REPOSIROTY_REMIN_TYPE = "1";

		/**
		 * 人员标签关联
		 */
		public static final String PERSON_LABELS_REMIN_TYPE = "2";
	}

	public class Relative{
		public static final String IS_RELATIVED_TRUE = "1";

		public static final String IS_RELATIVED_FALSE = "0";
	}

	/**
	 * 默认页参数定义
	 * @author zjk
	 * @date 2019年4月17日下午3:40:38
	 */
	public static class DefaultPager {
		/**
		 * 默认页码为1
		 */
		public static final int PAGE_ID = 1;
		/**
		 * 列表查询默认每页大小为20
		 */
		public static final int PAGE_SIZE_LIST = 20;
		/**
		 * 联想下拉框查询默认每页大小为8
		 */
		public static final int PAGE_SIZE_ASSOCIATE = 8;
	}

	/**
	 * 排序类别定义
	 * @author zjk
	 * @date 2019年5月29日下午4:40:30
	 */
	public static class OrderType {
		/**
		 * 升序
		 */
		public static final String ASC = "asc";
		/**
		 * 降序
		 */
		public static final String DESC = "desc";
	}

	public static final String DEFAULT_PAGE = "DEFAULT_PAGE";

}
