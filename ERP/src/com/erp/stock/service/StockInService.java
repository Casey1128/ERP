package com.erp.stock.service;

import java.util.List;

import com.erp.utils.PageBean;

public interface StockInService {
	public PageBean findAllDataStIn(int pageNo, int pageSize);
	public PageBean findSupplier(int pageNo,int pageSize);
	public List findSupplierByCode(String code);
	public int addDataStIn(Object[] obj);
	public List findDataStInByCode(String code);
	public PageBean findPurchaseOrder(int pageNo,int pageSize);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public List findDataStInDetailByIncode(String incode);

	public int delDataStIn(String code);
	public PageBean SearchDataStIn(String sql,String sqlcount,int pageNo,int pageSize);
}
