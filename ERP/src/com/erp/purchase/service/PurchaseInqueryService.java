package com.erp.purchase.service;

import java.util.Date;
import java.util.List;

import com.erp.purchase.entity.PurchaseInquery;
import com.erp.utils.PageBean;

public interface PurchaseInqueryService {
	public List<PurchaseInquery> findAll();
	public PageBean SearchAll(int pageNo,int pageSize);
	public int add(PurchaseInquery purchaseInquery);
	public PurchaseInquery findByCode(String code);
	public int update(PurchaseInquery purchaseInquery);
	public int del(String code);
	public PageBean SearchByCondition(String code, Date d1, Date d2,
			String supplier, int parseInt, int parseInt2);

}
