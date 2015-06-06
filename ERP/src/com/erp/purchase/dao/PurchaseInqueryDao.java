package com.erp.purchase.dao;

import java.util.Date;
import java.util.List;

import com.erp.purchase.entity.PurchaseInquery;
import com.erp.utils.PageBean;

public interface PurchaseInqueryDao {

	public List<PurchaseInquery> findAll();
	public PageBean SearchAll(int pageNo,int pageSize);
	public int add(PurchaseInquery purchaseInquery);
	public PurchaseInquery findByCode(String code);
	public int update(PurchaseInquery purchaseInquery);
	public int del(String code);
	public PageBean SearchByCondition(String code, Date d1, Date d2,
			String supplier, int pageNo, int pageSize);
}
