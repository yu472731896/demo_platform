package com.minghui.common.framework.page;

import lombok.Data;

@Data
public class Pager {
	/**
	 * 当前页
	 */
	private int pageId;
	/**
	 * 每页大小
	 */
	private int pageSize;

	/**
	 * 是否进行分页统计,默认不统计.
	 */
	private boolean count;

}