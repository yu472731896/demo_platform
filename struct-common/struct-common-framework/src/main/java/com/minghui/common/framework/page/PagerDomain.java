package com.minghui.common.framework.page;

public class PagerDomain {
	/**
	 * 翻页控件
	 */
	public static final String PAGER = "pager";
	/**
	 * 当前页
	 */
	public static final String PAGE_ID = "pageId";
	/**
	 * 总记录数
	 */
	public static final String ROW_COUNT = "rowCount";
	/**
	 * 每页大小
	 */
	public static final String PAGE_SIZE = "pageSize";
	
	public static final String PAGE_CURRENT_PAGE = "currentPage";
	
	public static final String PAGE_RECORD_INDEX = "recordIndex";
	/**
	 * 总页数<br>
	 * 根据总记录数和每页大小换算：整除时，总记录数/每页大小；不能整除时，总记录数/每页大小+1
	 */
	public static final String PAGE_COUNT = "pageCount";
	/**
	 * 记录索引位置<br>
	 * MySQL数据库使用，作为OFFSET的参数值<br>
	 * 例如：LIMIT 10 OFFSET 0，即从第1条开始查询，查询10条数据，也就是查询第1条到第10条数据
	 */
	public static final String PAGE_OFFSET = "pageOffset";
	/**
	 * 记录开始位置<br>
	 * 新增属性，Oracle数据库使用，作为记录起始参数，例如：ROWNUM >= 1，即从第1条开始查询
	 */
	public static final String PAGE_FRONT = "pageFront";
	/**
	 * 记录结束位置<br>
	 * MySql或Oracle数据库使用，作为记录结束位置参数<br>
	 * 例如：LIMIT 1, 10，即查询第1条到第10条数据，10作为结束位置；<br>
	 * 		 ROWNUM >= 1 AND ROWNUM <= 10，即查询第1条到第10条数据，10作为结束位置
	 */
	public static final String PAGE_TAIL = "pageTail";
	public static final String ORDER_FIELD = "orderField";
	public static final String ORDER_DIRECTION = "orderDirection";
	public static final String ORACLE_QUERY_CONDITION = "oracleQueryCondition";
	public static final String LENGTH = "length";
	public static final String START_INDEX = "startIndex";
	public static final String END_INDEX = "endIndex";
	public static final String INDEXS = "indexs";
}