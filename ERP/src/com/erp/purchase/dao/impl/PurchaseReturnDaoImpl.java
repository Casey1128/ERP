package com.erp.purchase.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.erp.purchase.dao.PurchaseReturnDao;
import com.erp.purchase.entity.PurchaseInquery;
import com.erp.purchase.entity.PurchaseReturn;
import com.erp.utils.BaseDao;
import com.erp.utils.PageBean;

public class PurchaseReturnDaoImpl extends BaseDao implements PurchaseReturnDao {

	private ResultSet rs=null;
	@Override
	public List<PurchaseReturn> findAll() {
		// TODO Auto-generated method stub
		String sql="select * from purchasereturn order by rdate desc";
		rs=super.executeQuery(sql);
		List<PurchaseReturn> list=new ArrayList<PurchaseReturn>();
		PurchaseReturn purchaseReturn=null;
		try {
			while(rs.next()){
				purchaseReturn=new PurchaseReturn();
				purchaseReturn.setCode(rs.getString("code"));
				purchaseReturn.setrDate(rs.getDate("rdate"));
				purchaseReturn.setSupplierCode(rs.getString("suppliercode"));
				purchaseReturn.setContacter(rs.getString("contacter"));
				purchaseReturn.setTelPhone(rs.getString("telphone"));
				purchaseReturn.setFax(rs.getString("fax"));
				purchaseReturn.setRemarks(rs.getString("remarks"));
				purchaseReturn.setIsShow(rs.getInt("isshow"));
				purchaseReturn.setNums(rs.getInt("nums"));
				purchaseReturn.setNumsPrice(rs.getInt("numsprice"));
				purchaseReturn.setState(rs.getInt("state"));
				purchaseReturn.setAddUser(rs.getString("adduser"));
				purchaseReturn.setAddUserName(rs.getString("addusername"));
				purchaseReturn.setAddIp(rs.getString("addip"));
				purchaseReturn.setCompCode(rs.getString("compcode"));
				list.add(purchaseReturn);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			super.close();
		}
		return list;
	}

	@Override
	public PageBean SearchAll(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		String sql="select * from purchasereturn order by rdate desc";
		rs = super.executeQueryForPage(sql, pageNo, pageSize);
		PageBean pageBean = new PageBean();
		List<PurchaseReturn> pList = new ArrayList<PurchaseReturn>();
		PurchaseReturn purchaseReturn = null;
		try {
			while (rs.next()) {
				purchaseReturn=new PurchaseReturn();
				purchaseReturn.setCode(rs.getString("code"));
				purchaseReturn.setrDate(rs.getDate("rdate"));
				purchaseReturn.setSupplierCode(rs.getString("suppliercode"));
				purchaseReturn.setContacter(rs.getString("contacter"));
				purchaseReturn.setTelPhone(rs.getString("telphone"));
				purchaseReturn.setFax(rs.getString("fax"));
				purchaseReturn.setRemarks(rs.getString("remarks"));
				purchaseReturn.setIsShow(rs.getInt("isshow"));
				purchaseReturn.setNums(rs.getInt("nums"));
				purchaseReturn.setNumsPrice(rs.getInt("numsprice"));
				purchaseReturn.setState(rs.getInt("state"));
				purchaseReturn.setAddUser(rs.getString("adduser"));
				purchaseReturn.setAddUserName(rs.getString("addusername"));
				purchaseReturn.setAddIp(rs.getString("addip"));
				purchaseReturn.setCompCode(rs.getString("compcode"));
				pList.add(purchaseReturn);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			super.close();
		}
		pageBean.setData(pList);
		String sqlw="select count(*) from purchasereturn";
		pageBean.setRecordCount(super.executeTotalCount(sqlw));
		return pageBean;
	}

	@Override
	public int del(String code) {
		// TODO Auto-generated method stub
		String sql="delete from purchasereturn where code=?";
		int ret=0;
		ret=super.executeUpdate(sql, code);
		return ret;
	}

	@Override
	public int insert(PurchaseReturn pr) {
		// TODO Auto-generated method stub
		String sql="insert into purchasereturn(code,rdate,suppliercode,nums,numsprice,contacter,telphone,state,adduser) "
				+ " values(?,sysdate,?,?,?,?,?,?,?)";
		int ret=0;
		ret=super.executeUpdate(sql, new Object[]{pr.getCode(),pr.getSupplierCode(),pr.getNums(),pr.getNumsPrice(),pr.getContacter(),pr.getTelPhone(),pr.getState(),pr.getAddUser()});
		return ret;
	}

	@Override
	public PurchaseReturn findByCode(String code) {
		// TODO Auto-generated method stub
		String sql="select * from purchasereturn where code=?";
		ResultSet rs=null;
		PurchaseReturn purchaseReturn=null;
		rs=super.executeQuery(sql, new Object[]{code});
		try {
			while(rs.next()){
				purchaseReturn=new PurchaseReturn();
				purchaseReturn.setCode(code);
				purchaseReturn.setrDate((java.util.Date)rs.getDate("rdate"));
				purchaseReturn.setSupplierCode(rs.getString("suppliercode"));
				purchaseReturn.setNums(rs.getInt("nums"));
				purchaseReturn.setNumsPrice(rs.getInt("numsprice"));
				purchaseReturn.setContacter(rs.getString("contacter"));
				purchaseReturn.setTelPhone(rs.getString("telphone"));
				purchaseReturn.setState(rs.getInt("state"));
				purchaseReturn.setAddUser(rs.getString("adduser"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return purchaseReturn;
	}

	@Override
	public int update(PurchaseReturn pr) {
		// TODO Auto-generated method stub
		String sql="update purchasereturn set rdate=?,suppliercode=?,adduser=?,telphone=?,fax=?,remarks=? where code=?";
		int ret=0;
		ret=super.executeUpdate(sql,new Object[]{pr.getrDate(),pr.getSupplierCode(),pr.getAddUser(),pr.getTelPhone(),pr.getFax(),pr.getRemarks(),pr.getCode()} );
		return ret;
	}

}
