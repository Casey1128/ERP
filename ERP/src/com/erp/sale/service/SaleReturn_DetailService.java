package com.erp.sale.service;

import java.util.List;

import com.erp.sale.entity.SaleReturn_Detail;
import com.erp.utils.PageBean;

public interface SaleReturn_DetailService {
	public List getSaleReturn_Detail(String code);
	
	public PageBean getStockOutList(String partsNo,String partsName,String ckCode ,int pageNo, int pageSize);

}
