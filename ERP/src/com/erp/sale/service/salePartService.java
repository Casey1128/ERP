package com.erp.sale.service;

import com.erp.sale.entity.baseparts;
import com.erp.utils.PageBean;

public interface salePartService {
	public PageBean getPartService(int pageNo,int pageSize);
	public PageBean getPartService(int pageNo,int pageSize,baseparts baseparts);
	public baseparts getBasePart(String code);

}
