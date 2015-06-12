package com.erp.sale.dao;

import java.util.Date;


import com.erp.sale.entity.SaleReturn;
import com.erp.utils.PageBean;

public interface SaleReturnDao {
	public PageBean searchSaleReturn(String code,Date startDate, Date endDate, 
			String customercode,int pageNo, int pageSize);
		
		public int insertSaleReturn(SaleReturn salereturn);
		public int deleteSaleReturn(String code);
		public int updateSaleReturn(SaleReturn salereturn);

}
