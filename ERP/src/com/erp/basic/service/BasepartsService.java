package com.erp.basic.service;

import java.util.List;

import com.erp.basic.entity.Baseparts;
import com.erp.utils.PageBean;

public interface BasepartsService {
	public PageBean getBasepartsAll(String partsGeneralpartsno,String partsName,String partsCategory,int pageNo,int pageSize);
	public int add(Baseparts baseparts);
	public int delete(String partscode);
	public int updateBaseparts(Baseparts baseparts);
	public List<Baseparts> getCategoryBaseparts();

}
