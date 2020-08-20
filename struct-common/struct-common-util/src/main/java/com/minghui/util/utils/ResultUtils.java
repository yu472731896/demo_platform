package com.minghui.util.utils;

import org.apache.commons.collections.CollectionUtils;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @auther chenqinglin
 * @create 2018/4/8
 * @Description:提供公共的返回值调用
 */
public abstract class ResultUtils {

	static String success = "success";
	
    public static final Map<String, Object> getFaildResultData() {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put(success, false);
        return hashMap;
    }

    public static final Map<String, Object> getFaildResultData(String... errorMessages) {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put(success, false);
        hashMap.put("errorMessages", errorMessages);
        return hashMap;
    }

    public static final Map<String, Object> getFaildResultDataWithErrorCode(Object errorCode, String... errorMessages) {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put(success, false);
        hashMap.put("errorCode", errorCode);
        hashMap.put("errorMessages", errorMessages);
        return hashMap;
    }

    public static final Map<String, Object> getFaildResultData(Collection<String> errorMessages) {
        if (CollectionUtils.isNotEmpty(errorMessages)) {
            String[] array = (String[])errorMessages.toArray(new String[errorMessages.size()]);
            return getFaildResultData(array);
        } else {
            return getFaildResultData();
        }
    }

    public static final Map<String, Object> getSuccessResultData() {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put(success, true);
        return hashMap;
    }

    public static final Map<String, Object> getSuccessResultData(Object data) {
        HashMap<String, Object> hashMap = new HashMap();
        hashMap.put(success, true);
        hashMap.put("data", data);
        return hashMap;
    }

    public static final Map<String, Object> getSuccessResultData(String root, Object data) {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put(success, true);
        hashMap.put(root, data);
        return hashMap;
    }
}
