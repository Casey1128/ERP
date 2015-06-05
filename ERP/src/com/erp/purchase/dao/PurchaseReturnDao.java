package com.erp.purchase.dao;

import java.util.List;

import com.erp.purchase.entity.PurchaseReturn;
import com.erp.utils.PageBean;

public interface PurchaseReturnDao {
	public List<PurchaseReturn> findAll();
	public PageBean SearchAll(int pageNo,int pageSize);
	public int del(String code);
	public int insert(PurchaseReturn purchaseReturn);
	public PurchaseReturn findByCode(String code);
	public int update(PurchaseReturn purchaseReturn);
}
