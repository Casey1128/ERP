package com.erp.sale.service.impl;

import java.util.Date;

import javax.enterprise.inject.New;

import com.erp.sale.dao.SaleReturnDao;
import com.erp.sale.dao.impl.SaleReturnDaoImpl;
import com.erp.sale.entity.SaleReturn;
import com.erp.sale.service.SaleReturnService;
import com.erp.utils.PageBean;

public class SaleReturnServiceImpl implements SaleReturnService {
	
	private SaleReturnDao saleReturnDao=new SaleReturnDaoImpl();
	@Override
	public PageBean getSaleReturn(String code, Date startDate, Date endDate,
			String customercode, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return saleReturnDao.searchSaleReturn(code, startDate, endDate, customercode, pageNo, pageSize);
	}

	@Override
	public int addSaleReturn(SaleReturn salereturn) {
		// TODO Auto-generated method stub
		
		return saleReturnDao.insertSaleReturn(salereturn);
	}

	@Override
	public int delSaleReturn(String code) {
		// TODO Auto-generated method stub
		return saleReturnDao.deleteSaleReturn(code);
	}

	@Override
	public int updateSaleReturn(SaleReturn salereturn) {
		// TODO Auto-generated method stub
		return saleReturnDao.updateSaleReturn(salereturn);
	}

}
