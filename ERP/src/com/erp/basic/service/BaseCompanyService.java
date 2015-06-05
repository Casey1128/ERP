package com.erp.basic.service;

import java.util.List;

import com.erp.basic.entity.BaseCompany;
import com.erp.utils.PageBean;

public interface BaseCompanyService {
	 public PageBean findAll(int pageNo,int pageSize);
	 public PageBean findByCid(int pageNo,int pageSize,String Cid);
	 public int updateByCid(BaseCompany bs);
	 public List<BaseCompany> searchAll();
}
