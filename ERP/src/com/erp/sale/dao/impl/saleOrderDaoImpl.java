package com.erp.sale.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.erp.sale.dao.saleOrderDao;
import com.erp.sale.entity.saleOrder;
import com.erp.sale.service.impl.orderServiceImpl;
import com.erp.utils.BaseDao;
import com.erp.utils.PageBean;
import com.erp.utils.saleOrderCode;

public class saleOrderDaoImpl extends BaseDao implements saleOrderDao{
	private ResultSet rs=null;
	private saleOrderCode orderCode=new saleOrderCode();
	@Override
	public PageBean searchOrder(String code,Date startDate, Date endDate, 
			String customercode,int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		String sql="select code,orderdate,customercode,nums,nums*numsprice total,"
				+"contacter,telphone,state,adduser from saleorder where 1=1";
		List params=new ArrayList();
		List queryParmas=new ArrayList();
		if(code!=null&&!code.equals("")){
			sql+=" and code=?";
			params.add(code);
		}
		
		if(startDate!=null){
			sql+=" and orderdate>=?";
			params.add(new java.sql.Date(startDate.getTime()));
		}
		if(endDate!=null){
			sql+=" and orderdate<=?";
			params.add(new java.sql.Date(endDate.getTime()));
		}
		if(customercode!=null&&!customercode.equals("")){
			sql+=" and customercode=?";
			params.add(customercode);
		}
		sql+=" order by adddate desc ";
		queryParmas.addAll(params);
		queryParmas.add(pageNo*pageSize);
		queryParmas.add((pageNo-1)*pageSize);
		Object[] paramsArr=queryParmas.toArray();
		rs=super.executeQueryForPage(sql,paramsArr);
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
		pageBean.setRecordCount(super.executeTotalCount(sqlw,params.toArray()));
		return pageBean;
	}

	@Override
	public int insertOrder(saleOrder saleorder) {
		// TODO Auto-generated method stub
		
		String sql="insert into saleorder(code,orderdate,customercode,"
				+"contacter,telphone,fax,trans,businesser,remarks,deliverydate,nums,numsprice,state,adduser) "
				+" values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		int ret=super.executeUpdate(sql
		,new Object[]{saleorder.getCode(),new java.sql.Date(saleorder.getOrderDate().getTime())
		,saleorder.getCustomercode()
		,saleorder.getContacter()
		,saleorder.getTelphone()
		,saleorder.getFax()
		,saleorder.getTrans()
		,saleorder.getBusinesser()
		,saleorder.getRemarks()
		,new java.sql.Date(saleorder.getDeliveryDate().getTime())
		,saleorder.getNums(),saleorder.getNumsPrice(),saleorder.getState(),saleorder.getAddUser()});
		return ret;
	}
//	public static void main(String[] args){
//		saleOrderDaoImpl s=new saleOrderDaoImpl();
//		saleOrder saleorder=new saleOrder();
//		saleorder.setCode("9999");
//		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
//		Date date1,date2;
//		try {
//			date1= sdf.parse("2015-06-09");
//			saleorder.setOrderDate(date1);
//			saleorder.setCustomercode("9");
//			saleorder.setContacter("9");
//			saleorder.setTelphone("99999");
//			saleorder.setFax("9");
//			saleorder.setTrans("9");
//			saleorder.setBusinesser("9");
//			saleorder.setRemarks("9");
//			date2=sdf.parse("2015-06-09");
//			saleorder.setDeliveryDate(date2);
//			saleorder.setNums(9);
//			saleorder.setNumsPrice(9);
//			saleorder.setState("1");
//			saleorder.setAddUser("9");
//			s.insertOrder(saleorder);
//			
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}
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

	@Override
	public List<saleOrder> orderTransList() {
		// TODO Auto-generated method stub
		String sql="select distinct trans from saleorder";
		rs=super.executeQuery(sql);
		List<saleOrder> transList=new ArrayList<saleOrder>();
		saleOrder saleorder=null;
		try {
			while(rs.next()){
				saleorder=new saleOrder();
				saleorder.setTrans(rs.getString("trans"));
				transList.add(saleorder);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			super.close();
		}
		return transList;
	}
	
}
