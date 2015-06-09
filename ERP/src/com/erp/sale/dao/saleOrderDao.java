package com.erp.sale.dao;

import java.util.Date;
import java.util.List;

import com.erp.utils.PageBean;
import com.erp.sale.entity.saleOrder;
public interface saleOrderDao {
	
public PageBean searchOrder(String code,Date startDate, Date endDate, 
		String customercode,int pageNo, int pageSize);
	
	public int insertOrder(saleOrder saleorder);
	public int deleteOrder(String code);
	public int updateOrder(saleOrder saleorder);

	 
}
