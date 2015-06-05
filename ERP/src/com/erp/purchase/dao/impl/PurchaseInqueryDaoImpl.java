package com.erp.purchase.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.erp.basic.entity.BaseContent;
import com.erp.purchase.dao.PurchaseInqueryDao;
import com.erp.purchase.entity.PurchaseInquery;
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

}
