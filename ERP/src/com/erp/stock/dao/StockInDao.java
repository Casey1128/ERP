package com.erp.stock.dao;

import java.util.List;

import com.erp.utils.PageBean;

public interface StockInDao {
	public PageBean findAllDataStIn(int pageNo, int pageSize);
	public List findAllDataStInDetail(String incode);
	public int addDataStIn(Object[] obj);
	public int delDataStIn(String code);
}
