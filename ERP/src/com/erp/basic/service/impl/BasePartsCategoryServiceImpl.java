package com.erp.basic.service.impl;

import java.util.List;

import com.erp.basic.dao.BasePartsCategoryDao;
import com.erp.basic.dao.impl.BasePartsCategoryDaoImpl;
import com.erp.basic.entity.BasePartsCategory;
import com.erp.basic.service.BasePartsCategoryService;
import com.erp.utils.PageBean;

public class BasePartsCategoryServiceImpl  implements BasePartsCategoryService{
	private BasePartsCategoryDao pCategory=new BasePartsCategoryDaoImpl();
	public int delete(String code) {
		// TODO Auto-generated method stub
		return pCategory.deleteParts(code);
	}

	public int insert(BasePartsCategory partsCategory) {
		// TODO Auto-generated method stub
		return pCategory.insertParts(partsCategory);
	}

	public int update(BasePartsCategory partsCategory) {
		// TODO Auto-generated method stub
		return pCategory.updateParts(partsCategory);
	}

	public List<BasePartsCategory> getCategoryList() {
		// TODO Auto-generated method stub
		return pCategory.categoryList();
	}

	public PageBean searchByCategory(String code, String pcode, int pageNo,
			int pageSize) {
		// TODO Auto-generated method stub
		return pCategory.searchByCategory(code,pcode,pageNo,pageSize);
	}
	public static void main(String[] args){
		BasePartsCategoryDaoImpl b=new BasePartsCategoryDaoImpl();
		PageBean p=b.searchByCategory("","001",1,10);
		for(int i=0;i<p.getData().size();i++){
			System.out.println(((BasePartsCategory) p.getData().get(i)).getCategoryName());
			
		}
	}
}
