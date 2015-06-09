package com.erp.stock.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.erp.stock.dao.StockInDao;
import com.erp.stock.entity.StockIn;
import com.erp.stock.entity.StockInDetail;
import com.erp.utils.BaseDao;
import com.erp.utils.PageBean;

public class StockInDaoImpl extends BaseDao implements StockInDao {

	Connection conn=null;
	PreparedStatement pstm=null;
	ResultSet rs=null;
	
	
	@Override
	public PageBean findAllDataStIn(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		PageBean pb=new PageBean();
		List<StockIn> list=new ArrayList<StockIn>();
		String sql="select * from StockIn";
		rs=super.executeQueryForPage(sql, pageNo, pageSize);
		try {
			while(rs.next()){
				StockIn stock=new StockIn();
				stock.setCode(rs.getString("code"));
				stock.setIndate(rs.getDate("indate"));
				stock.setContacter(rs.getString("contacter"));
				stock.setNums(rs.getInt("nums"));
				stock.setNumsPrice(rs.getInt("numsPrice"));
				stock.setState(rs.getString("state"));
				stock.setAddUser(rs.getString("addUser"));
				list.add(stock);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			super.close();
		}
		pb.setData(list);
		sql="select count(*) from StockIn";
		int total=super.executeTotalCount(sql);
		pb.setRecordCount(total);
		pb.setPageCount(total%pageSize==0?total/pageSize:total/pageSize+1);
		pb.setPageNo(pageNo);
		pb.setPageSize(pageSize);
		return pb;
	}

	@Override
	public List findAllDataStInDetail(String incode) {
		// TODO Auto-generated method stub
		List<StockInDetail> list=new ArrayList<StockInDetail>();
		String sql="select * from StockIn_Detail where incode=?";
		rs=super.executeQuery(sql,new Object[]{incode});
		int nums=0;
		int price=0;
		int pdTotal=0;
		int totalMoney=0;
		try {
			while(rs.next()){
				StockInDetail stock=new StockInDetail();
				
				nums=rs.getInt("Nums");
				price=rs.getInt("Price");
				pdTotal=nums*price;
				totalMoney+=pdTotal;
				
				stock.setCode(rs.getString("code"));
				stock.setInCode(rs.getString("inCode"));
				stock.setOrderCode(rs.getString("orderCode"));
				stock.setpCode(rs.getString("pCode"));
				stock.setNums(nums);
				stock.setPrice(price);
				stock.setWareHouse(rs.getString("wareHouse"));
				stock.setRemarks(rs.getString("remarks"));
				stock.setPdTotal(pdTotal);
				stock.setTotalMoney(totalMoney);
				list.add(stock);
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
	public List sumMoneyNums() {
		// TODO Auto-generated method stub
		
		return null;
	}
}
