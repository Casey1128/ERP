package com.erp.sale.service.impl;

import com.erp.basic.entity.basecusTomerSipplier;
import com.erp.basic.service.UnitService;
import com.erp.basic.service.impl.UnitServiceImpl;
import com.erp.sale.dao.saleQuotationDao;
import com.erp.sale.dao.impl.saleQuotationDaoImpl;
import com.erp.sale.entity.saleQuotation;
import com.erp.sale.service.saleQuotationService;
import com.erp.utils.PageBean;

public class saleQuotationServiceimpl implements saleQuotationService {

	private saleQuotationDao salequotationdao=new saleQuotationDaoImpl();
	private UnitService uService=new UnitServiceImpl(); 
	@Override
	public PageBean searchSaleQuotation(int pageNo, int pageSize,
			saleQuotation sQuotation) {
		// TODO Auto-generated method stub
		return salequotationdao.searchSaleQuotation(pageNo, pageSize, sQuotation);
	}

	@Override
	public saleQuotation searchQuotation(String scode) {
		// TODO Auto-generated method stub
		return salequotationdao.searchQuotation(scode);
	}

	@Override
	public PageBean searchSaleList(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return salequotationdao.searchSaleList(pageNo, pageSize);
	}

	@Override
	public int insertQuotation(saleQuotation sQuotation) {
		// TODO Auto-generated method stub
		basecusTomerSipplier bSipplier=new basecusTomerSipplier();
		bSipplier=uService.findBaseCustomerSupplierbycsname(sQuotation.getbSipplier().getCsName());
		//System.out.println(bSipplier.getCode());
		sQuotation.setCustomercode(bSipplier.getCode());
		return salequotationdao.insertQuotation(sQuotation);
	}

	@Override
	public int deleteQuotation(String code) {
		// TODO Auto-generated method stub
		return salequotationdao.deleteQuotation(code);
	}

	@Override
	public int updateQuotation(saleQuotation sQuotation) {
		// TODO Auto-generated method stub
		return salequotationdao.updateQuotation(sQuotation);
	}

	

}
