package com.erp.stock.service;

import java.util.List;

import com.erp.utils.PageBean;

public interface StockInService {
	public PageBean findAllDataStIn(int pageNo, int pageSize);
	public PageBean findSupplier(int pageNo,int pageSize);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public List findDataStInByCode(String code);
	public List findDataStInDetailByIncode(String incode);
	public int addDataStIn(Object[] obj);
	public int delDataStIn(String code);
	public PageBean SearchDataStIn(String sql,String sqlcount,int pageNo,int pageSize);
}
