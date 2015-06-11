package com.erp.sale.service.impl;

import com.erp.sale.dao.saleOrderDao;
import com.erp.sale.dao.saleQuotationDao;
import com.erp.sale.dao.impl.saleOrderDaoImpl;
import com.erp.sale.dao.impl.saleQuotationDaoImpl;
import com.erp.sale.entity.saleOrder;
import com.erp.sale.service.SaleService;
import com.erp.utils.BaseDao;
import com.erp.utils.PageBean;

public class SaleServiceImpl extends BaseDao implements SaleService {
	
	private saleQuotationDao saleService=new saleQuotationDaoImpl();
	@Override
	public PageBean searchSaleList(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		
		return saleService.searchSaleList(pageNo, pageSize);
	}

	@Override
	public PageBean searchSaleQuotation(int pageNo, int pageSize,
			saleOrder saleOrder) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public saleOrder searchQuotation(String scode) {
		// TODO Auto-generated method stub
		return null;
	}

}
