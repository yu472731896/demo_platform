package com.minghui.common.framework.model;

import com.minghui.common.framework.page.Pager;

public abstract class BaseExample {

	protected Pager pager;

	public Pager getPager() {
		return pager;
	}

	public void setPager(Pager pager) {
		this.pager = pager;
	}
	
}
