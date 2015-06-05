package com.erp.basic.service.impl;

import java.util.List;

import com.erp.basic.dao.BaseCompanyDao;
import com.erp.basic.dao.impl.BaseCompanyDaoImpl;
import com.erp.basic.entity.BaseCompany;
import com.erp.basic.service.BaseCompanyService;
import com.erp.utils.PageBean;

public class BaseCompanyServiceImpl implements BaseCompanyService {

	private BaseCompanyDao baseCompanyDao=new BaseCompanyDaoImpl();
	@Override
	public PageBean findAll(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return baseCompanyDao.findAll(pageNo, pageSize);
	}

	@Override
	public PageBean findByCid(int pageNo, int pageSize, String Cid) {
		// TODO Auto-generated method stub
		return baseCompanyDao.findByCid(pageNo, pageSize, Cid);
	}

	@Override
	public int updateByCid(BaseCompany bs) {
		// TODO Auto-generated method stub
		return baseCompanyDao.updateByCid(bs);
	}

	@Override
	public List<BaseCompany> searchAll() {
		// TODO Auto-generated method stub
		return baseCompanyDao.searchAll();
	}

}
