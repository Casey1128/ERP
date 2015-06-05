package com.erp.purchase.service.impl;

import java.util.Date;
import java.util.List;

import com.erp.purchase.dao.PurchaseReturnDao;
import com.erp.purchase.dao.impl.PurchaseReturnDaoImpl;
import com.erp.purchase.entity.PurchaseReturn;
import com.erp.purchase.service.PurchaseReturnService;
import com.erp.utils.PageBean;

public class PurchaseReturnServiceImpl implements PurchaseReturnService {

	private PurchaseReturnDao purchaseReturnDao=new PurchaseReturnDaoImpl();
	@Override
	public List<PurchaseReturn> findAll() {
		// TODO Auto-generated method stub
		return purchaseReturnDao.findAll();
	}

	@Override
	public PageBean SearchAll(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return purchaseReturnDao.SearchAll(pageNo, pageSize);
	}

	@Override
	public int del(String code) {
		// TODO Auto-generated method stub
		return purchaseReturnDao.del(code);
	}

	@Override
	public int add(PurchaseReturn purchaseReturn) {
		// TODO Auto-generated method stub
		return purchaseReturnDao.insert(purchaseReturn);
	}

	@Override
	public PurchaseReturn findByCode(String code) {
		// TODO Auto-generated method stub
		return purchaseReturnDao.findByCode(code);
	}

	@Override
	public int update(PurchaseReturn purchaseReturn) {
		// TODO Auto-generated method stub
		return purchaseReturnDao.update(purchaseReturn);
	}

	@Override
	public PageBean SearchByCondition(String code, Date startDate,
			Date endDate, String supplier, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return purchaseReturnDao.SearchByCondition(code, startDate, endDate, supplier, pageNo, pageSize);
	}

}
