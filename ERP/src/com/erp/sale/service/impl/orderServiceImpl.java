package com.erp.sale.service.impl;

import java.util.Date;
import java.util.List;

import com.erp.sale.dao.saleOrderDao;
import com.erp.sale.dao.impl.saleOrderDaoImpl;
import com.erp.sale.entity.saleOrder;
import com.erp.sale.service.orderService;
import com.erp.utils.BaseDao;
import com.erp.utils.PageBean;

public class orderServiceImpl extends BaseDao implements orderService{
	private saleOrderDao orderDao=new saleOrderDaoImpl();
	@Override
	public PageBean searchOrder(String code, Date startDate, Date endDate,
			String customercode, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return orderDao.searchOrder(code, startDate, endDate, customercode, pageNo, pageSize);
	}
	@Override
	public int insert(saleOrder saleorder) {
		// TODO Auto-generated method stub
		return orderDao.insertOrder(saleorder);
	}
	
	public List<saleOrder> getTrans(){
		// TODO Auto-generated method stub
		return orderDao.orderTransList();
	}

}
