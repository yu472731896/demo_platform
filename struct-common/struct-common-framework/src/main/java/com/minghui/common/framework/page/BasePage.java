package com.minghui.common.framework.page;//package com.ropeok.common.framework.page;
//
//import org.apache.commons.lang3.StringUtils;
//
//public class BasePage {
//	private Integer page = Integer.valueOf(1);
//	private Integer rows = Integer.valueOf(10);
//	private String sort;
//	private String order;
//	private Pager pager = new Pager();
//
//	public Pager getPager() {
//		this.pager.setPageId(getPage().intValue());
//		this.pager.setPageSize(getRows().intValue());
//		String orderField = "";
//		if (StringUtils.isNotBlank(this.sort)) {
//			orderField = this.sort;
//		}
//		if ((StringUtils.isNotBlank(orderField)) && (StringUtils.isNotBlank(this.order))) {
//			orderField = orderField + " " + this.order;
//		}
//		this.pager.setOrderField(orderField);
//		return this.pager;
//	}
//
//	public void setPager(Pager pager) {
//		this.pager = pager;
//	}
//
//	public Integer getPage() {
//		return this.page == 0 ? 1 : this.page;
//	}
//
//	public void setPage(Integer page) {
//		this.page = page;
//	}
//
//	public Integer getRows() {
//		return this.rows;
//	}
//
//	public void setRows(Integer rows) {
//		this.rows = rows;
//	}
//
//	public String getSort() {
//		return this.sort;
//	}
//
//	public void setSort(String sort) {
//		this.sort = sort;
//	}
//
//	public String getOrder() {
//		return this.order;
//	}
//
//	public void setOrder(String order) {
//		this.order = order;
//	}
//}