package com.erp.basic.service;

import java.util.List;

import com.erp.basic.entity.BaseContent;
import com.erp.utils.PageBean;

public interface BaseContentService {
	public PageBean findAll(int pageNo,int pageSize);
	public int add(BaseContent baseContent);
	public int del(String code,String category);
	public int modify(BaseContent baseContent);
	public BaseContent findByCaCode(String category,String code);
	public List<BaseContent> search();
}
