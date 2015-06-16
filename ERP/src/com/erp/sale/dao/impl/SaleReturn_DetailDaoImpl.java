package com.erp.sale.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.erp.sale.dao.SaleReturn_DetailDao;
import com.erp.sale.entity.SaleReturnDETAIL3biao;
import com.erp.sale.entity.SaleReturnStockOut;
import com.erp.sale.entity.SaleReturn_Detail;
import com.erp.utils.BaseDao;
import com.erp.utils.PageBean;

public class SaleReturn_DetailDaoImpl extends BaseDao implements
		SaleReturn_DetailDao {

	@Override
	public List searchSaleReturn_Detail(String code) {
		// TODO Auto-generated method stub
		String sql="select sd.ckCode,partsno,partsname,partsbrand,partsmodel,sd.nums,price,sd.remarks " +
				"from salereturn_detail sd left join baseparts " +
				"on sd.pcode= baseparts.partscode " +
				"left join stockout_detail " +
				"on sd.ckcode=stockout_detail.code " +
				"where xtcode=?";
		ResultSet rs=super.executeQuery(sql,code);
		List<SaleReturnDETAIL3biao> srdList=new ArrayList<SaleReturnDETAIL3biao>();
		SaleReturnDETAIL3biao srd=null;
		try {
			while(rs.next()){
				srd=new SaleReturnDETAIL3biao();
				srd.setCkCode(rs.getString("ckCode"));
				srd.setPartsNo(rs.getString("partsno"));
				srd.setPartsName(rs.getString("partsname"));
				srd.setPartsBrand(rs.getString("partsbrand"));
				srd.setPartsModel(rs.getString("partsmodel"));
				srd.setNums(rs.getInt("nums"));
				srd.setPrice(rs.getDouble("price"));	
				srd.setRemarks(rs.getString("remarks"));
				srdList.add(srd);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			super.close();
		}
		return srdList;
		
	}

	@Override
	public PageBean searchStockOutList(String partsNo, String partsName,
			String ckCode,int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		String sql="select sk.code,sk.outDate,partsNo,partsName,partsbrand,partsModel," +
				"skd.nums,skd.price from stockout_detail skd left join baseparts " +
				"on skd.pcode=baseparts.partscode " +
				"left join stockout sk " +
				"on sk.code=skd.outcode where 1=1 ";
		if(partsNo!=null&&!partsNo.equals("")){
			sql+="and partsNo='"+partsNo+"'";
		}
		if(partsName!=null&&!partsName.equals("")){
			sql+="and partsName='"+partsName+"'";
			
		}
		if(ckCode!=null&&!ckCode.equals("")){
			sql+="and sk.code='"+ckCode+"'";
		}
		ResultSet rs=super.executeQueryForPage(sql, pageNo, pageSize);
		PageBean pageBean=new PageBean();
		List<SaleReturnStockOut> srsList=new ArrayList<SaleReturnStockOut>();
		SaleReturnStockOut srs=null;
		try {
			while(rs.next()){
				srs=new SaleReturnStockOut();
				srs.setCkCode(rs.getString("code"));
				srs.setOutDate(rs.getDate("outDate"));
				srs.setPartsNo(rs.getString("partsNo"));
				srs.setPartsName(rs.getString("partsName"));
				srs.setPartsBrand(rs.getString("partsBrand"));
				srs.setPartsModel(rs.getString("partsModel"));
				srs.setNums(rs.getInt("nums"));
				srs.setPrice(rs.getDouble("price"));
				srsList.add(srs);		
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			super.close();
		}
		pageBean.setData(srsList);
		//sql="select count(*) from SaleReturnStockOut";
		pageBean.setRecordCount(super.executeTotalCount(sql));
		return pageBean;
	}

}
