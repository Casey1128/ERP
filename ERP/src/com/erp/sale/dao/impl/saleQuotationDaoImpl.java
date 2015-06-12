package com.erp.sale.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.erp.basic.entity.basecusTomerSipplier;
import com.erp.sale.dao.saleQuotationDao;
import com.erp.sale.entity.saleOrder;
import com.erp.sale.entity.saleQuotation;
import com.erp.utils.BaseDao;
import com.erp.utils.PageBean;

public class saleQuotationDaoImpl extends BaseDao implements saleQuotationDao {

	private ResultSet rs=null;
	PageBean pagebean=new PageBean(); 
	@Override
	public PageBean searchSaleQuotation(int pageNo, int pageSize,
			saleQuotation saleQuotation) {
		// TODO Auto-generated method stub
		String sql="select  sq.* , b.csname csname from basecustomersupplier b  JOIN salequotation sq  ON b.code=sq.CUSTOMERCODE where 1=1 ";
		if(saleQuotation.getCode()!=null&&!saleQuotation.getCode().equals("")){
			sql+=" and code="+"'"+saleQuotation.getCode()+"'";
		}
		if(saleQuotation.getbSipplier()!=null&&!saleQuotation.getbSipplier().equals("")){
			if(saleQuotation.getbSipplier().getCsName()!=null&&!saleQuotation.getbSipplier().getCsName().equals("")){
				sql+=" and csName="+"'"+saleQuotation.getbSipplier().getCsName()+"'";
			}
		}
		if(saleQuotation.getStartdate()!=null&&!saleQuotation.getStartdate().equals("")){
			sql+=" and to_char(adddate,'yyyy-mm-dd')= "+"'"+new SimpleDateFormat("yyyy-MM-dd").format(saleQuotation.getStartdate())+"'";
		}
		if(saleQuotation.getEnddate()!=null&&!saleQuotation.getEnddate().equals("")){
			sql+=" and to_char(adddate,'yyyy-mm-dd')= "+"'"+new SimpleDateFormat("yyyy-MM-dd").format(saleQuotation.getEnddate())+"'";
		}
		System.out.println(sql);
		
		
		rs=super.executeQueryForPage(sql, pageNo, pageSize);
		List<saleQuotation> orderList=new ArrayList<saleQuotation>();
		saleQuotation sQuotation=null;
		basecusTomerSipplier bSipplier=new basecusTomerSipplier();
		try {
			while (rs.next()) {
				sQuotation=new saleQuotation();
				sQuotation.setCode(rs.getString("code"));
				sQuotation.setSqdate(rs.getDate("sqdate"));
				bSipplier.setCsName(rs.getString("csname"));
				sQuotation.setbSipplier(bSipplier);
				sQuotation.setNums(rs.getInt("nums"));
				sQuotation.setNumsprice(rs.getInt("numsprice"));
				sQuotation.setContacter(rs.getString("contacter"));
				sQuotation.setTelphone(rs.getString("telphone"));
				sQuotation.setState(rs.getString("state"));
				sQuotation.setAddUser(rs.getString("addUser"));
				
				orderList.add(sQuotation);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}finally{
			super.close();
			
		}
		pagebean.setData(orderList);
		pagebean.setRecordCount(super.executeTotalCount(sql));
		return pagebean;
	}

	@Override
	public saleQuotation searchQuotation(String scode) {
		// TODO Auto-generated method stub
		String sql="select  sq.* , b.csname csname from basecustomersupplier b  JOIN salequotation sq  ON b.code=sq.CUSTOMERCODE  where sq.code=?";
		rs=super.executeQuery(sql,scode);
		saleQuotation sQuotation=null;
		basecusTomerSipplier bSipplier=new basecusTomerSipplier();
		try {
			while (rs.next()) {
				sQuotation=new saleQuotation();	
				sQuotation.setCode(rs.getString("code"));
				//sQuotation.setCode(rs.getString("code"));
				sQuotation.setSqdate(rs.getDate("sqdate"));
				bSipplier.setCsName(rs.getString("csname"));
				sQuotation.setbSipplier(bSipplier);
				sQuotation.setNums(rs.getInt("nums"));
				sQuotation.setNumsprice(rs.getInt("numsprice"));
				sQuotation.setContacter(rs.getString("contacter"));
				sQuotation.setTelphone(rs.getString("telphone"));
				sQuotation.setState(rs.getString("state"));
				sQuotation.setAddUser(rs.getString("addUser"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sQuotation;
	}

	@Override
	public PageBean searchSaleList(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		String sql="select  sq.* , b.csname csname from basecustomersupplier b  JOIN salequotation sq  ON b.code=sq.CUSTOMERCODE  ";
		rs=super.executeQueryForPage(sql, pageNo, pageSize);
		List<saleQuotation> orderList=new ArrayList<saleQuotation>();
		saleQuotation sQuotation=null;
		basecusTomerSipplier bSipplier=new basecusTomerSipplier();
		try {
			while (rs.next()) {
				sQuotation=new saleQuotation();
				sQuotation.setCode(rs.getString("code"));
				sQuotation.setSqdate(rs.getDate("sqdate"));
				bSipplier.setCsName(rs.getString("csname"));
				sQuotation.setbSipplier(bSipplier);
				sQuotation.setNums(rs.getInt("nums"));
				sQuotation.setNumsprice(rs.getInt("numsprice"));
				sQuotation.setContacter(rs.getString("contacter"));
				sQuotation.setTelphone(rs.getString("telphone"));
				sQuotation.setState(rs.getString("state"));
				sQuotation.setAddUser(rs.getString("addUser"));
				
				orderList.add(sQuotation);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			super.close();
		}
		pagebean.setData(orderList);
		pagebean.setRecordCount(super.executeTotalCount(sql));
		return pagebean;
	}

	@Override
	public int insertQuotation(saleQuotation sQuotation) {
		// TODO Auto-generated method stub
		
		String sql="insert into salequotation values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		int ret=super.executeUpdate(sql, new Object[]{
				sQuotation.getCode(),new java.sql.Date(sQuotation.getSqdate().getTime()),
sQuotation.getCustomercode(),sQuotation.getContacter(),sQuotation.getTelphone(),
				sQuotation.getFax(),sQuotation.getNums(),sQuotation.getNumsprice(),sQuotation.getIsShow(),sQuotation.getState(),
				sQuotation.getRemarks(),sQuotation.getAddDate(),sQuotation.getAddUser(),sQuotation.getAddUserName(),sQuotation.getAddIp(),
				sQuotation.getCompcode()});
		return ret;
	}

	@Override
	public int deleteQuotation(String code) {
		// TODO Auto-generated method stub
		String sql="delete salequotation where code=?";
		int ret=super.executeUpdate(sql, code);
		return ret;
	}

	@Override
	public int updateQuotation(saleQuotation sQuotation) {
		// TODO Auto-generated method stub
		String sql="update salequotation set"
				+ " sqdate=?,customercode=?,contacter=?,telphone=?,fax=?,"
				+ "nums=?,numsprice=?,isshow=?,state=?,remarks=?,"
				+ "adddate=?,adduser=?,addusername=?,addip=?,compcode=? "
				+ "where code=?";
		String sql1="update basecustomersupplier set csname=? where code=?";
		
		int ret=super.executeUpdate(sql, new Object[]{
				sQuotation.getSqdate(),sQuotation.getCustomercode(),sQuotation.getContacter(),sQuotation.getTelphone(),
				sQuotation.getFax(),sQuotation.getNums(),sQuotation.getNumsprice(),sQuotation.getIsShow(),sQuotation.getState(),
				sQuotation.getRemarks(),sQuotation.getAddDate(),sQuotation.getAddUser(),sQuotation.getAddUserName(),sQuotation.getAddIp(),
				sQuotation.getCompcode(),sQuotation.getCode()
		});
		ret+=super.executeUpdate(sql1, new Object[]{sQuotation.getbSipplier().getCsName(),sQuotation.getCustomercode()});
		return ret;
	}

	

}
