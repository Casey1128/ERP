package com.erp.basic.dao;

import java.util.List;

import com.erp.basic.entity.Baseparts;
import com.erp.utils.PageBean;


public interface BasepartsDao {
	public PageBean findBasepartsAll(String partsGeneralpartsno,String partsName,
			String partsCategory,int pageNo, int pageSize);
	public int insert(Baseparts baseparts);
	public int del(String partscode);
	public int update(Baseparts baseparts);
	public List<Baseparts> findCategoryBaseparts();//select DISTINCT partscategory from baseparts
 	//public PageBean findBasepartsBycondition();
}
