package com.erp.basic.dao;

import java.util.List;

import com.erp.basic.entity.BaseContent;
import com.erp.utils.PageBean;

public interface BaseContentDao {
	public PageBean findAll(int pageNo,int pageSize);
	public int insert(BaseContent baseContent);
	public int delete(String code,String category);
	public int update(BaseContent baseContent);
	public BaseContent findByCaCode(String category,String code);
	public List<BaseContent> search();
}
