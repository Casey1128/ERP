package com.erp.stock.service.Impl;

import java.util.List;

import com.erp.stock.dao.StockInDao;
import com.erp.stock.dao.Impl.StockInDaoImpl;
import com.erp.stock.service.StockInService;
import com.erp.utils.BaseDao;
import com.erp.utils.PageBean;

public class StockInServiceImpl extends BaseDao implements StockInService {

	StockInDao stock=new StockInDaoImpl();
	@Override
	public PageBean findAllDataStIn(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return stock.findAllDataStIn(pageNo, pageSize);
	}

	@Override
	public List findAllDataStInDetail(String incode) {
		// TODO Auto-generated method stub
		return stock.findAllDataStInDetail(incode);
	}

	@Override
	public int addDataStIn(Object[] obj) {
		// TODO Auto-generated method stub
		return stock.addDataStIn(obj);
	}

	@Override
	public int delDataStIn(String code) {
		// TODO Auto-generated method stub
		return stock.delDataStIn(code);
	}

	@Override
	public PageBean SearchDataStIn(String sql, String sqlcount, int pageNo,
			int pageSize) {
		// TODO Auto-generated method stub
		return stock.SearchDataStIn(sql, sqlcount, pageNo, pageSize);
	}

}
