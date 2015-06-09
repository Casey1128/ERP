package com.erp.sale.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.erp.basic.entity.basecusTomerSipplier;
import com.erp.sale.dao.saleOrderDao;
import com.erp.sale.entity.saleOrder;
import com.erp.sale.entity.saleQuotation;
import com.erp.utils.BaseDao;
import com.erp.utils.PageBean;

public class saleOrderDaoImpl extends BaseDao implements saleOrderDao{
	private ResultSet rs=null;
	@Override
	public PageBean searchOrder(String code,Date startDate, Date endDate, 
			String customercode,int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		String sql="select code,orderdate,customercode,nums,nums*numsprice total,"
				+"contacter,telphone,state,adduser from saleorder where 1=1";
		List params=new ArrayList();
		if(code!=null&&!code.equals("")){
			sql+=" and code='"+code+"'";
			params.add(code);
		}
		
		if(startDate!=null){
			sql+=" and orderdate>='"+new java.sql.Date(startDate.getTime())+"'";
			//params.add(new java.sql.Date(startDate.getTime()));
		}
		if(endDate!=null){
			sql+=" and orderdate<='"+new java.sql.Date(endDate.getTime())+"'";
			//params.add(new java.sql.Date(endDate.getTime()));
		}
		if(customercode!=null&&!customercode.equals("")){
			sql+=" and customercode='"+customercode+"'";
			//params.add(customercode);
		}
		sql+=" order by adddate desc ";
//		params.add(pageNo*pageSize);
//		params.add((pageNo-1)*pageSize);
//		Object[] paramsArr=params.toArray();
		ResultSet rs=super.executeQueryForPage(sql,pageNo,pageSize);
//		rs=super.executeQueryForPage(sql,paramsArr);
		PageBean pageBean=new PageBean();
		
		List<saleOrder> orderList=new ArrayList<saleOrder>();
		saleOrder sOrder=null;
		try {
			while(rs.next()){
				sOrder=new saleOrder();
				sOrder.setCode(rs.getString("code"));
				sOrder.setOrderDate(rs.getDate("orderdate"));
				sOrder.setCustomercode(rs.getString("customercode"));
				sOrder.setNums(rs.getInt("nums"));
				sOrder.setTotal(rs.getDouble("total"));
				sOrder.setContacter(rs.getString("contacter"));
				sOrder.setTelphone(rs.getString("telphone"));
				sOrder.setState(rs.getString("state"));
				sOrder.setAddUser(rs.getString("adduser"));
				orderList.add(sOrder);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			super.close();
		}	
		pageBean.setData(orderList);
		String sqlw = "select count(code)"+sql.substring(sql.indexOf("from"));
		pageBean.setRecordCount(super.executeTotalCount(sqlw));
		return pageBean;
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
