package com.erp.sale.dao;


import com.erp.sale.entity.saleQuotation;
import com.erp.utils.PageBean;

public interface saleQuotationDao {
	public PageBean searchSaleQuotation(int pageNo,int pageSize,saleQuotation sQuotation);
	public saleQuotation searchQuotation(String scode);
	public PageBean searchSaleList(int pageNo,int pageSize );
	public int insertQuotation(saleQuotation sQuotation);
	public int deleteQuotation(String code);
	public int updateQuotation(saleQuotation sQuotation);
}
