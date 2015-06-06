package com.erp.purchase.service.impl;

import java.util.Date;
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
	@Override
	public int add(PurchaseInquery purchaseInquery) {
		// TODO Auto-generated method stub
		return purchaseInqueryDao.add(purchaseInquery);
	}
	@Override
	public PurchaseInquery findByCode(String code) {
		// TODO Auto-generated method stub
		return purchaseInqueryDao.findByCode(code);
	}
	@Override
	public int update(PurchaseInquery purchaseInquery) {
		// TODO Auto-generated method stub
		return purchaseInqueryDao.update(purchaseInquery);
	}
	@Override
	public int del(String code) {
		// TODO Auto-generated method stub
		return purchaseInqueryDao.del(code);
	}
	@Override
	public PageBean SearchByCondition(String code, Date d1, Date d2,
			String supplier, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return purchaseInqueryDao.SearchByCondition(code,d1,d2,supplier,pageNo,pageSize);
	}

}
