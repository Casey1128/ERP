package com.erp.purchase.service;

import java.util.List;

import com.erp.purchase.entity.PurchaseInquery;
import com.erp.utils.PageBean;

public interface PurchaseInqueryService {
	public List<PurchaseInquery> findAll();
	public PageBean SearchAll(int pageNo,int pageSize);
}
