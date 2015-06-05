package com.erp.basic.service.impl;

import java.util.List;

import com.erp.basic.dao.BaseContentDao;
import com.erp.basic.dao.impl.BaseContentDaoImpl;
import com.erp.basic.entity.BaseContent;
import com.erp.basic.service.BaseContentService;
import com.erp.utils.PageBean;

public class BaseContentServiceImpl implements BaseContentService {

	private BaseContentDao baseContentDao=new BaseContentDaoImpl();
	@Override
	public PageBean findAll(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return baseContentDao.findAll(pageNo, pageSize);
	}

	@Override
	public int add(BaseContent baseContent) {
		// TODO Auto-generated method stub
		return baseContentDao.insert(baseContent);
	}

	@Override
	public int del(String code,String category) {
		// TODO Auto-generated method stub
		return baseContentDao.delete(code,category);
	}

	@Override
	public int modify(BaseContent baseContent) {
		// TODO Auto-generated method stub
		return baseContentDao.update(baseContent);
	}

	@Override
	public BaseContent findByCaCode(String category, String code) {
		// TODO Auto-generated method stub
		return baseContentDao.findByCaCode(category, code);
	}

	@Override
	public List<BaseContent> search() {
		// TODO Auto-generated method stub
		return baseContentDao.search();
	}
	public static void main(String[] args) {
		BaseContentService baseContentService=new BaseContentServiceImpl();
		BaseContent bContent=new BaseContent();
	//	bContent=baseContentService.findByCaCode("收款方式", "002");
		System.out.println(bContent.getCodeName());
		int ret=0;
		ret=baseContentService.del("007", "费用科目");
		if(ret==0){
			System.out.println("删除失败");
		}else{
			System.out.println("删除成功");
		}
		System.out.println(ret);
	}

}
