package com.erp.basic.dao;

import java.util.List;

import com.erp.basic.entity.basecusTomerSipplier;
import com.erp.utils.PageBean;

public interface UnitDao {
	public PageBean getUnitList(int pageNo,int pageSize);
	public PageBean getUnitList();
	public int addUnit(basecusTomerSipplier bSipplier);
	public int deleteUnit(String  code);
	public int updateUnit(basecusTomerSipplier bSipplier);
	public List<basecusTomerSipplier> searchList();
	public PageBean findList(basecusTomerSipplier bts,int pageNo,int pageSize);
	public basecusTomerSipplier findBaseCustomerSupplier(String code);
	public basecusTomerSipplier findBaseCustomerSupplierbycsname(String csname);
	
}
