package com.erp.basic.dao;

import java.util.List;

import com.erp.basic.entity.BasePartsCategory;
import com.erp.utils.PageBean;


public interface BasePartsCategoryDao {
//	public PageBean findAll(int pageNo,int pageSize);
//	public BasePartsCategory searchByCode(String code);
//	public PageBean searchByCategory(String pcode,int pageNo,int pageSize);
	
	public PageBean searchByCategory(String code,String pcode,int pageNo,int pageSize);
	
	public int insertParts(BasePartsCategory partsCategory);
	public int deleteParts(String code);
	public int updateParts(BasePartsCategory partsCategory);
	public List<BasePartsCategory> categoryList();
}
