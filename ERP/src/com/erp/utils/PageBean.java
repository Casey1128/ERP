package com.erp.utils;

import java.util.List;

public class PageBean {
    private List data;
    private int pageNo;//��ǰҳ��
    private int recordCount;//��¼��
    private int pageSize;//��ҳ�ߴ�
    public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getRecordCount() {
		return recordCount;
	}
	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}
	private int pageCount;//ҳ��ߴ�
	public List getData() {
		return data;
	}
	public void setData(List data) {
		this.data = data;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
}
