package com.erp.sale.service;

import java.util.Date;

import com.erp.sale.entity.SaleReturn;
import com.erp.utils.PageBean;

public interface SaleReturnService {
	public PageBean getSaleReturn(String code,Date startDate, Date endDate, 
			String customercode,int pageNo, int pageSize);
		
		public int addSaleReturn(SaleReturn salereturn);
		public int delSaleReturn(String code);
		public int updateSaleReturn(SaleReturn salereturn);

}
