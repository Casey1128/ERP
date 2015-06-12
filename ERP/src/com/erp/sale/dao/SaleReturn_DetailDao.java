package com.erp.sale.dao;

import java.util.List;

import com.erp.sale.entity.SaleReturn_Detail;
import com.erp.utils.PageBean;

public interface SaleReturn_DetailDao {
	public List searchSaleReturn_Detail(String code);
	
	public PageBean searchStockOutList(String partsNo,String partsName,String ckCode,int pageNo, int pageSize);

}
