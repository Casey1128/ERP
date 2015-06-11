package com.erp.sale.service.impl;

import java.util.List;

import com.erp.sale.dao.SaleReturn_DetailDao;
import com.erp.sale.dao.impl.SaleReturn_DetailDaoImpl;
import com.erp.sale.entity.SaleReturn_Detail;
import com.erp.sale.service.SaleReturn_DetailService;

public class SaleReturn_DetailServiceImpl implements SaleReturn_DetailService {
	private SaleReturn_DetailDao saleReturn_DetailDao=new SaleReturn_DetailDaoImpl();

	@Override
	public List getSaleReturn_Detail(SaleReturn_Detail saleReturn_Detail) {
		// TODO Auto-generated method stub
		return saleReturn_DetailDao.searchSaleReturn_Detail(saleReturn_Detail);
	}

}
