package com.erp.basic.service.impl;


import java.util.List;

import com.erp.basic.dao.UnitDao;
import com.erp.basic.dao.impl.UnitDaoImpl;
import com.erp.basic.entity.basecusTomerSipplier;
import com.erp.basic.service.UnitService;
import com.erp.utils.PageBean;

public class UnitServiceImpl implements UnitService {

	private UnitDao unitDao=new UnitDaoImpl();
	public PageBean getUnitList(int pageNo,int pageSize) {
		// TODO Auto-generated method stub
		return unitDao.getUnitList(pageNo,pageSize);
	}

	public int addUnit(basecusTomerSipplier bSipplier) {
		// TODO Auto-generated method stub
		return unitDao.addUnit(bSipplier);
	}

	public int deleteUnit(String  code) {
		// TODO Auto-generated method stub
		return unitDao.deleteUnit(code);
	}

	public int updateUnit(basecusTomerSipplier bSipplier) {
		// TODO Auto-generated method stub
		return unitDao.updateUnit(bSipplier);
	}

	public List<basecusTomerSipplier> searchList() {
		// TODO Auto-generated method stub
		return unitDao.searchList();
	}

	public static void main(String[] args) {
		UnitServiceImpl u=new UnitServiceImpl();
		PageBean p=u.getUnitList(1,5);
		List<basecusTomerSipplier> ulist=p.getData();
		for(int i=0;i<ulist.size();i++){
		String code=ulist.get(i).getCode();
		String add=ulist.get(i).getCsName();
		
		
		System.out.println(code);
		}
	}

	public PageBean findList(basecusTomerSipplier bSipplier, int pageNo,
			int pageSize) {
		// TODO Auto-generated method stub
		return unitDao.findList(bSipplier, pageNo, pageSize);
	}

	public basecusTomerSipplier findBaseCustomerSupplier(String code) {
		// TODO Auto-generated method stub
		return unitDao.findBaseCustomerSupplier(code);
	}

	public PageBean getUnitList() {
		// TODO Auto-generated method stub
		return  unitDao.getUnitList();
	}
}


