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
import com.erp.sale.entity.saleOrderDetails;
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
		String sql="select code,orderdate,customercode,nums,nums*numsprice total,businesser,"
				+"contacter,telphone,state,adduser from saleorder where 1=1";
		List params=new ArrayList();
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MÔÂ-yyyy");
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
		Object[] paramsArr1=queryParmas.toArray();
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
				sOrder.setBusinesser(rs.getString("businesser"));
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
		pageBean.setRecordCount(super.executeTotalCount(sqlw,paramsArr1));
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
	@Override
	public int deleteOrder(String code) {
		// TODO Auto-generated method stub
		String sql="delete from saleorder where code=?";
		return super.executeUpdate(sql, code);
	}
	@Override
	public int updateOrder(saleOrder saleorder) {
		// TODO Auto-generated method stub
		String sql="update saleorder set orderdate=?,state=?"
	+",contacter=?,fax=?,trans=?,telphone=?,deliverydate=?,nums=?,numsprice=?,remarks=?,adduser=?"
				+" where code=?";
		return super.executeUpdate(sql,
			new Object[]{new java.sql.Date(saleorder.getOrderDate().getTime())
		,saleorder.getState(),saleorder.getContacter(),saleorder.getFax(),saleorder.getTrans()
		,saleorder.getTelphone(),new java.sql.Date(saleorder.getDeliveryDate().getTime())
		,saleorder.getNums(),saleorder.getNumsPrice(),saleorder.getRemarks(),saleorder.getAddUser()
		,saleorder.getCode()
		});
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

	@Override
	public List<saleOrderDetails> orderDetailsShow(String scode) {
		// TODO Auto-generated method stub
		String sql="select salorder_detail.scode a,baseparts.partsno b,baseparts.partsname c,"
				+"baseparts.partsbrand d,baseparts.partsmodel e,salorder_detail.nums f,"
+"salorder_detail.price g,salorder_detail.nums*salorder_detail.price totals,salorder_detail.remarks h"
				+" from salorder_detail  join baseparts"
				+" on salorder_detail.pcode=baseparts.partscode"
				+" where scode=?";
		rs=super.executeQuery(sql,new Object[]{scode});
		List<saleOrderDetails> orderDetails=new ArrayList<saleOrderDetails>();
		saleOrderDetails details=null;
		try {
			while(rs.next()){
				details=new saleOrderDetails();
				details.setCode(rs.getString("a"));
				details.setPartsNo(rs.getString("b"));
				details.setPartsNname(rs.getString("c"));
				details.setPartsBrand(rs.getString("d"));
				details.setPartsModel(rs.getString("e"));
				details.setNums(rs.getInt("f"));
				details.setPrice(rs.getDouble("g"));
				details.setTotals(rs.getDouble("totals"));
				details.setRemark(rs.getString("h"));
				orderDetails.add(details);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			super.close();
		}
		return orderDetails;
	}
//	public static void main(String[] args){
//		saleOrderDaoImpl s=new saleOrderDaoImpl();
//		List<saleOrderDetails> list=s.orderDetailsShow("9999");
//		for(int i=0;i<list.size();i++){
//			System.out.println(list.get(i).getCode());
//			System.out.println(list.get(i).getPartsNname());
//		}
//	}
}
