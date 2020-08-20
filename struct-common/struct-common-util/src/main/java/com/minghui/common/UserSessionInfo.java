package com.minghui.common;

import com.minghui.database.entity.LoginInfo;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class UserSessionInfo implements Serializable {

	/**
	 * @author cwp 2017年7月26日 下午7:42:59
	 */
	private static final long serialVersionUID = 1L;

	public static final String USERSESSIONNAME = "userSessionInfo";

	private LoginInfo loginInfo;

	private List<String> listTask;

	public UserSessionInfo() {
		listTask = new ArrayList<String>();
	}

}
