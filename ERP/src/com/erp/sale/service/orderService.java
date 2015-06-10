package com.erp.sale.service;

import java.util.Date;

import com.erp.utils.PageBean;

public interface orderService {
	public PageBean searchOrder(String code,Date startDate, Date endDate, 
			String customercode,int pageNo, int pageSize);
}
