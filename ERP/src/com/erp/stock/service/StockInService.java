package com.erp.stock.service;

import java.util.List;

import com.erp.utils.PageBean;

public interface StockInService {
	public PageBean findAllDataStIn(int pageNo, int pageSize);
	public List findAllDataStInDetail(String incode);
	public int addDataStIn(Object[] obj);
	public int delDataStIn(String code);
}
