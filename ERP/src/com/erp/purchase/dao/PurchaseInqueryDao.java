package com.erp.purchase.dao;

import java.util.List;

import com.erp.purchase.entity.PurchaseInquery;
import com.erp.utils.PageBean;

public interface PurchaseInqueryDao {

	public List<PurchaseInquery> findAll();
	public PageBean SearchAll(int pageNo,int pageSize);
}
