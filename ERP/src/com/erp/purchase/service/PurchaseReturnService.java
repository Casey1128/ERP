package com.erp.purchase.service;

import java.util.Date;
import java.util.List;

import com.erp.purchase.entity.PurchaseReturn;
import com.erp.utils.PageBean;

public interface PurchaseReturnService {
	public List<PurchaseReturn> findAll();
	public PageBean SearchAll(int pageNo,int pageSize);
	public int del(String code);
	public int add(PurchaseReturn purchaseReturn);
	public PurchaseReturn findByCode(String code);
	public int update(PurchaseReturn purchaseReturn);
	public PageBean SearchByCondition(String code,Date startDate,Date endDate,String supplier,int pageNo,int pageSize);

}
