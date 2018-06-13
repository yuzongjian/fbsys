package com.buoy.util;

import java.io.Serializable;


public class Page implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final Integer DEF_LIMIT = 5;
	public static final Integer DEF_OFFSET = 0;
	public static final Integer DEF_PAGENO = 1;
	
	public final static Page PAGE = new Page();
	
	
	public Page() {
		super();
		this.offset = DEF_OFFSET;
		this.pageNo = DEF_PAGENO;
		this.limit = DEF_LIMIT;
	}
	public Page(Integer offset, Integer limit, Integer pageNo) {
		super();
		this.offset = offset;
		this.limit = limit;
		this.pageNo = pageNo;
	}
	public Page(Integer limit, Integer pageNo) {
		super();
		this.limit = limit;
		this.pageNo = pageNo;
		this.offset = (pageNo -1)*limit;
	}
	
	/**
	 * 偏移量
	 */
	private Integer offset;
	/**
	 * 条数
	 */
	private Integer limit;
	/**
	 * 页码
	 */
	private Integer pageNo;
	/**
	 * 总记录数
	 */
	private Integer total;
	/**
	 * 总页数
	 */
	private Integer pageCount;
	
	
	
	public Integer getPageCount() {
		return (this.total+this.limit-1)/limit;
	}
	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public Integer getOffset() {
		offset = (pageNo -1)*limit;
		return offset;
	}
	public void setOffset(Integer offset) {
		this.offset = offset;
	}
	public Integer getLimit() {
		return limit;
	}
	public void setLimit(Integer limit) {
		this.limit = limit;
	}
	public Integer getPageNo() {
		if (this.pageNo > getPageCount()) this.pageNo = getPageCount();
		return pageNo;
	}
	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}
	
	
	
	

}
