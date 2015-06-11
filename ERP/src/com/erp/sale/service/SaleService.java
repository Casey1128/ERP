package com.erp.sale.service;

import com.erp.sale.entity.saleOrder;
import com.erp.utils.PageBean;

public interface SaleService {
	public PageBean searchSaleList(int pageNo,int pageSize );
	public PageBean searchSaleQuotation(int pageNo,int pageSize,saleOrder saleOrder);
	public saleOrder searchQuotation(String scode);
	
}
