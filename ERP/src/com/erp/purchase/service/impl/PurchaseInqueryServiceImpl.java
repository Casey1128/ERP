package com.erp.purchase.service.impl;

import java.util.List;

import com.erp.purchase.dao.PurchaseInqueryDao;
import com.erp.purchase.dao.impl.PurchaseInqueryDaoImpl;
import com.erp.purchase.entity.PurchaseInquery;
import com.erp.purchase.service.PurchaseInqueryService;
import com.erp.utils.PageBean;

public class PurchaseInqueryServiceImpl implements PurchaseInqueryService{

	private PurchaseInqueryDao purchaseInqueryDao=new PurchaseInqueryDaoImpl();
	@Override
	public List<PurchaseInquery> findAll() {
		// TODO Auto-generated method stub
		return purchaseInqueryDao.findAll();
	}
	@Override
	public PageBean SearchAll(int pageNo,int pageSize) {
		// TODO Auto-generated method stub
		return purchaseInqueryDao.SearchAll(pageNo, pageSize);
	}

}
