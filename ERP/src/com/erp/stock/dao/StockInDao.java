package com.erp.stock.dao;

import java.util.List;

import com.erp.utils.PageBean;

public interface StockInDao {

	public PageBean findAllDataStIn(int pageNo, int pageSize);
	public PageBean findSupplier(int pageNo,int pageSize);
	public List findSupplierByCode(String code);
	
	
	
	
	
	
	public List findDataStInByCode(String code);
	public List findDataStInDetailByIncode(String incode);
	public int addDataStIn(Object[] obj);
	public int delDataStIn(String code);
	public PageBean SearchDataStIn(String sql,String sqlcount,int pageNo,int pageSize);
}
