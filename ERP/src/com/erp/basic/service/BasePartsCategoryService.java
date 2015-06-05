package com.erp.basic.service;

import java.util.List;

import com.erp.basic.entity.BasePartsCategory;
import com.erp.utils.PageBean;

public interface BasePartsCategoryService {
//	public PageBean getPartsList(int pageNo,int pageSize);
	public int update(BasePartsCategory partsCategory);
	
	public int insert(BasePartsCategory partsCategory);

//	public PageBean searchByCategory(String pcode,int pageNo,int pageSize);
	public PageBean searchByCategory(String code,String pcode,int pageNo,int pageSize);
	
//	public BasePartsCategory searchByCode(String code);
	public int delete(String code);
	
	public List<BasePartsCategory> getCategoryList();
}
