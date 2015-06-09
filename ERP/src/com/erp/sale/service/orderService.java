package com.erp.sale.service;

import java.util.Date;
import java.util.List;

import com.erp.sale.entity.saleOrder;
import com.erp.utils.PageBean;

public interface orderService {
	public PageBean searchOrder(String code,Date startDate, Date endDate, 
			String customercode,int pageNo, int pageSize);
	public int insert(saleOrder saleorder);
	public List<saleOrder> getTrans();
}
