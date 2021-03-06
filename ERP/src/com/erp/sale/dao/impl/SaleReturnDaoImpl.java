package com.erp.sale.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import com.erp.sale.dao.SaleReturnDao;
import com.erp.sale.entity.SaleReturn;
import com.erp.utils.BaseDao;
import com.erp.utils.PageBean;


public class SaleReturnDaoImpl extends BaseDao implements SaleReturnDao{

	
	public PageBean searchSaleReturn(String code, Date startDate, Date endDate,
			String customercode, int pageNo, int pageSize) {
		SimpleDateFormat sdf2=new SimpleDateFormat("dd-M月-yyyy");
		String sql="select code,xtDate,customerCode,nums,numsPrice,contacter,telphone," +
				"state,addUserName from salereturn where 1=1 ";
		if(code!=null&&!code.equals("")){
			sql+=" and code='"+code+"'";
		}
		
		if(startDate!=null){
			sql+=" and xtDate>='"+sdf2.format(new java.sql.Date(startDate.getTime()))+"'";//把date类型的时间转换层数据库的时间‘dd-M月-yyyy’格式
		}
		if(endDate!=null){
			sql+=" and xtDate<='"+sdf2.format(new java.sql.Date(endDate.getTime()))+"'";//把date类型的时间转换层数据库的时间‘dd-M月-yyyy’格式
		}	
		if(customercode!=null&&!customercode.equals("")){
			sql+=" and customercode='"+customercode+"'";
		}
		sql+=" order by adddate desc ";
		ResultSet rs=super.executeQueryForPage(sql, pageNo, pageSize);
		PageBean pageBean=new PageBean();
		List<SaleReturn> saleReturnList=new ArrayList<SaleReturn>();
		SaleReturn sr=null;	
		try {
			while(rs.next()){
				sr=new SaleReturn();
				sr.setCode(rs.getString("code"));
				sr.setXtDate(new Date(rs.getDate("xtDate").getTime()));
				sr.setCustomerCode(rs.getString("customerCode"));
				sr.setNums(rs.getInt("nums"));
				sr.setNumsPrice(rs.getDouble("numsPrice"));
				sr.setContacter(rs.getString("contacter"));
				sr.setTelphone(rs.getString("telphone"));
				sr.setState(rs.getString("state"));
				sr.setAddUserName(rs.getString("addUserName"));
				saleReturnList.add(sr);
			}
		} catch (SQLException e) {			
			e.printStackTrace();
		}finally{
			super.close();
		}
		
		
		pageBean.setData(saleReturnList);
		sql="select count(*)  from SaleReturn";
		pageBean.setRecordCount(super.executeTotalCount(sql));
		return pageBean;
	}


	public int deleteSaleReturn(String code) {
		// TODO Auto-generated method stub
		String sql="delete saleReturn where code=?";
		int ret=super.executeUpdate(sql, new Object[]{code});
		return ret;
	}


	@Override
	public int insertSaleReturn(SaleReturn salereturn) {
		// TODO Auto-generated method stub
		String sql="insert into saleReturn (code,xtDate,customerCode," +
				"contacter,telphone,fax," +
				"remarks,isShow,nums," +
				"numsPrice,state,compCode," +
				"addDate,addUser,addUserName," +
				"addIp)" +
				"values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		int ret=super.executeUpdate(sql, new Object[]{salereturn.getCode(),salereturn.getXtDate(),
				salereturn.getCustomerCode(),salereturn.getContacter(),salereturn.getTelphone(),
				salereturn.getFax(),salereturn.getRemarks(),salereturn.getIsShow(),
				salereturn.getNums(),salereturn.getNumsPrice(),salereturn.getState(),
				salereturn.getCompCode(),salereturn.getAddDate(),salereturn.getAddUser(),
				salereturn.getAddUserName(),salereturn.getAddIp()});
		return ret;
	}


	@Override
	public int updateSaleReturn(SaleReturn salereturn) {
		// TODO Auto-generated method stub
		String sql="update SaleReturn set xtDate=?,customerCode=?,contacter=?," +
				"telphone=?,fax=?,remarks=?,isShow=?,nums=?,numsPrice=?,state=?,compCode=?," +
				"addDate=?,addUser=?,addUserName=?,addIp=? where code=?";
		return super.executeUpdate(sql, new Object[]{salereturn.getXtDate(),
				salereturn.getCustomerCode(),salereturn.getContacter(),salereturn.getTelphone(),
				salereturn.getFax(),salereturn.getRemarks(),salereturn.getIsShow(),
				salereturn.getNums(),salereturn.getNumsPrice(),salereturn.getState(),
				salereturn.getCompCode(),salereturn.getAddDate(),salereturn.getAddUser(),
				salereturn.getAddUserName(),salereturn.getAddIp(),salereturn.getCode()});
	}

}
