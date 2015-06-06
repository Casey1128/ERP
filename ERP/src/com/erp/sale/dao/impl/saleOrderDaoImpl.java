package com.erp.sale.dao.impl;

import com.erp.sale.dao.saleOrderDao;
import com.erp.sale.entity.saleOrder;
import com.erp.utils.BaseDao;
import com.erp.utils.PageBean;

public class saleOrderDaoImpl extends BaseDao implements saleOrderDao{

	@Override
	public PageBean searchOrder(String code, String customercode,
			String startDate, String endDate, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		String sql="select code,orderdate,customercode,nums,nums*numsprice total,"
				+"contacter,telphone,state,adduser from saleorder where 1=1";
		if(code!=null&&!code.equals("")){
			sql+=" and code='"+code+"'";
		}
		if(customercode!=null&&!customercode.equals("")){
			sql+=" and customercode='"+customercode+"'";
		}
		if(startDate!=null&&!startDate.equals("")){
			sql+=" and orderdate";
		}
 		return null;
	}

	@Override
	public int insertOrder(saleOrder saleorder) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteOrder(String code) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateOrder(saleOrder saleorder) {
		// TODO Auto-generated method stub
		return 0;
	}

}
