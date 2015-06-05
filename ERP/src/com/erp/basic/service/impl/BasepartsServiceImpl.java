package com.erp.basic.service.impl;
import java.util.List;

import com.erp.basic.dao.BasepartsDao;
import com.erp.basic.dao.impl.BasepartsDaoImpl;
import com.erp.basic.entity.Baseparts;
import com.erp.basic.service.BasepartsService;
import com.erp.utils.PageBean;


public class BasepartsServiceImpl implements BasepartsService {
	BasepartsDao basepartsDao=new BasepartsDaoImpl();

	public PageBean getBasepartsAll(String partsGeneralpartsno,String partsName,String partsCategory,int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return basepartsDao.findBasepartsAll(partsGeneralpartsno,partsName,partsCategory,pageNo, pageSize);
	}
	
	public int add(Baseparts baseparts) {
		// TODO Auto-generated method stub
		return basepartsDao.insert(baseparts);
	}
	public int delete(String partscode) {
		// TODO Auto-generated method stub
		return basepartsDao.del(partscode);
	}
	public int updateBaseparts(Baseparts baseparts) {
		// TODO Auto-generated method stub
		return basepartsDao.update(baseparts);
	}
/*	public static void main(String[] args) {
		BasepartsService bs=new BasepartsServiceImpl();
		//BasepartsDao basepartsDao=new BasepartsDaoImpl();
		
		PageBean pb=new PageBean();
		//pb=basepartsDao.findBasepartsAll(1,1);
		pb=bs.getBasepartsAll(1, 1);
		Baseparts baseparts=new Baseparts();
		for(int i=0;i<pb.getData().size();i++){
			baseparts=(Baseparts) pb.getData().get(i);
			System.out.println(baseparts.getPartsCode());
		}
	}*/

	public List<Baseparts> getCategoryBaseparts() {
		// TODO Auto-generated method stub
		return basepartsDao.findCategoryBaseparts();
	}
	
	
}
