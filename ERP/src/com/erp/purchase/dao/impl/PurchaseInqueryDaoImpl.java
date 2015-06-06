package com.erp.purchase.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.erp.basic.entity.BaseContent;
import com.erp.purchase.dao.PurchaseInqueryDao;
import com.erp.purchase.entity.PurchaseInquery;
import com.erp.purchase.entity.PurchaseReturn;
import com.erp.utils.BaseDao;
import com.erp.utils.PageBean;

public class PurchaseInqueryDaoImpl extends BaseDao implements
		PurchaseInqueryDao {

	private ResultSet rs=null;
	@Override
	public List<PurchaseInquery> findAll() {
		// TODO Auto-generated method stub
		String sql="select * from purchaseinquery order by adddate desc";
		rs=super.executeQuery(sql);
		List<PurchaseInquery> list=new ArrayList<PurchaseInquery>();
		PurchaseInquery purchaseInquery=null;
		try {
			while(rs.next()){
				purchaseInquery=new PurchaseInquery();
				purchaseInquery.setCode(rs.getString("code"));
				purchaseInquery.setAddDate(rs.getDate("adddate"));
				purchaseInquery.setSupplierCode(rs.getString("suppliercode"));
				purchaseInquery.setContacter(rs.getString("contacter"));
				purchaseInquery.setTelPhone(rs.getString("telphone"));
				purchaseInquery.setFax(rs.getString("fax"));
				purchaseInquery.setRemarks(rs.getString("remarks"));
				purchaseInquery.setIsShow(rs.getInt("isshow"));
				purchaseInquery.setNums(rs.getInt("nums"));
				purchaseInquery.setNumsPrice(rs.getInt("numsprice"));
				purchaseInquery.setState(rs.getInt("state"));
				purchaseInquery.setAddUser(rs.getString("adduser"));
				purchaseInquery.setAddUserName(rs.getString("addusername"));
				purchaseInquery.setAddIp(rs.getString("addip"));
				purchaseInquery.setCompCode(rs.getString("compcode"));
				list.add(purchaseInquery);
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
	public PageBean SearchAll(int pageNo,int pageSize) {
		// TODO Auto-generated method stub
		String sql="select * from purchaseinquery order by adddate desc";
		rs = super.executeQueryForPage(sql, pageNo, pageSize);
		PageBean pageBean = new PageBean();
		List<PurchaseInquery> pList = new ArrayList<PurchaseInquery>();
		PurchaseInquery purchaseInquery = null;
		try {
			while (rs.next()) {
				purchaseInquery=new PurchaseInquery();
				purchaseInquery.setCode(rs.getString("code"));
				purchaseInquery.setAddDate(rs.getDate("adddate"));
				purchaseInquery.setSupplierCode(rs.getString("suppliercode"));
				purchaseInquery.setContacter(rs.getString("contacter"));
				purchaseInquery.setTelPhone(rs.getString("telphone"));
				purchaseInquery.setFax(rs.getString("fax"));
				purchaseInquery.setRemarks(rs.getString("remarks"));
				purchaseInquery.setIsShow(rs.getInt("isshow"));
				purchaseInquery.setNums(rs.getInt("nums"));
				purchaseInquery.setNumsPrice(rs.getInt("numsprice"));
				purchaseInquery.setState(rs.getInt("state"));
				purchaseInquery.setAddUser(rs.getString("adduser"));
				purchaseInquery.setAddUserName(rs.getString("addusername"));
				purchaseInquery.setAddIp(rs.getString("addip"));
				purchaseInquery.setCompCode(rs.getString("compcode"));
				pList.add(purchaseInquery);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			super.close();
		}
		pageBean.setData(pList);
		String sqlw="select count(*) from purchaseinquery";
		pageBean.setRecordCount(super.executeTotalCount(sqlw));
		return pageBean;
	}

	@Override
	public int add(PurchaseInquery pi) {
		// TODO Auto-generated method stub
		String sql = "insert into purchaseinquery(code,adddate,suppliercode,nums,numsprice,contacter,telphone,state,adduser) "
				+ " values(?,sysdate,?,?,?,?,?,?,?)";
		int ret = 0;
		ret = super.executeUpdate(
				sql,
				new Object[] {pi.getCode(),pi.getSupplierCode(),pi.getNums(),pi.getNumsPrice(),pi.getContacter(),pi.getTelPhone(),pi.getState(),pi.getAddUser()});
		return ret;
	}

	@Override
	public PurchaseInquery findByCode(String code) {
		// TODO Auto-generated method stub
		String sql = "select * from purchaseinquery where code=?";
		ResultSet rs = null;
		PurchaseInquery purchaseInquery = null;
		rs = super.executeQuery(sql, new Object[] { code });
		try {
			while (rs.next()) {
				purchaseInquery = new PurchaseInquery();
				purchaseInquery.setCode(code);
				purchaseInquery.setAddDate((java.util.Date) rs.getDate("adddate"));
				purchaseInquery.setSupplierCode(rs.getString("suppliercode"));
				purchaseInquery.setNums(rs.getInt("nums"));
				purchaseInquery.setNumsPrice(rs.getInt("numsprice"));
				purchaseInquery.setContacter(rs.getString("contacter"));
				purchaseInquery.setTelPhone(rs.getString("telphone"));
				purchaseInquery.setState(rs.getInt("state"));
				purchaseInquery.setAddUser(rs.getString("adduser"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return purchaseInquery;
	}

	@Override
	public int update(PurchaseInquery pi) {
		// TODO Auto-generated method stub
		String sql = "update purchaseinquery set suppliercode=?"
				+ ",adduser=?,telphone=?,fax=?,remarks=? where code=?";
		int ret = 0;
		ret = super.executeUpdate(
				sql,
				new Object[] {pi.getSupplierCode(),pi.getAddUser(),pi.getTelPhone(),pi.getFax(),pi.getRemarks(),pi.getCode()});
		return ret;
	}

	@Override
	public int del(String code) {
		// TODO Auto-generated method stub
		String sql = "delete from purchaseinquery where code=?";
		int ret = 0;
		ret = super.executeUpdate(sql, code);
		return ret;
	}

	@Override
	public PageBean SearchByCondition(String code, Date startDate, Date endDate,
			String supplier, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		String sql = "select * from purchaseinquery  where 1=1";
		List params=new ArrayList();
		if(code!=null&&!code.equals("")){
			sql+=" and code=?";
			params.add(code);
		}
		if(startDate!=null){
			sql+=" and adddate>=?";
			params.add(new java.sql.Date(startDate.getTime()));
		}
		if(endDate!=null){
			sql+=" and adddate<=?";
			params.add(new java.sql.Date(endDate.getTime()));
		}
		if(supplier!=null&&!supplier.equals("")){
			sql+=" and suppliercode=?";
			params.add(supplier);
		}
		sql+=" order by adddate desc";
		Object[] paramArr1=params.toArray();
		params.add(pageNo*pageSize);
		params.add((pageNo-1)*pageSize);
		Object[] paramsArr2=params.toArray();
		rs = super.executeQueryForPage(sql, paramsArr2);
		PageBean pageBean = new PageBean();
	
		List<PurchaseInquery> pList = new ArrayList<PurchaseInquery>();
		PurchaseInquery purchaseInquery = null;
		try {
			while (rs.next()) {
				purchaseInquery = new PurchaseInquery();
				purchaseInquery.setCode(rs.getString("code"));
				purchaseInquery.setAddDate(rs.getDate("adddate"));
				purchaseInquery.setSupplierCode(rs.getString("suppliercode"));
				purchaseInquery.setContacter(rs.getString("contacter"));
				purchaseInquery.setTelPhone(rs.getString("telphone"));
				purchaseInquery.setFax(rs.getString("fax"));
				purchaseInquery.setRemarks(rs.getString("remarks"));
				purchaseInquery.setIsShow(rs.getInt("isshow"));
				purchaseInquery.setNums(rs.getInt("nums"));
				purchaseInquery.setNumsPrice(rs.getInt("numsprice"));
				purchaseInquery.setState(rs.getInt("state"));
				purchaseInquery.setAddUser(rs.getString("adduser"));
				purchaseInquery.setAddUserName(rs.getString("addusername"));
				purchaseInquery.setAddIp(rs.getString("addip"));
				purchaseInquery.setCompCode(rs.getString("compcode"));
				pList.add(purchaseInquery);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			super.close();
		}
		pageBean.setData(pList);
		String sqlw = "select count(*)"+sql.substring(sql.indexOf("from"));
		pageBean.setRecordCount(super.executeTotalCount(sqlw));
		return pageBean;
	}

}
