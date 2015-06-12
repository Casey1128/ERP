package com.erp.sale.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.erp.sale.dao.SaleReturn_DetailDao;
import com.erp.sale.entity.SaleReturnDETAIL3biao;
import com.erp.sale.entity.SaleReturn_Detail;
import com.erp.utils.BaseDao;

public class SaleReturn_DetailDaoImpl extends BaseDao implements
		SaleReturn_DetailDao {

	@Override
	public List searchSaleReturn_Detail(SaleReturn_Detail saleReturn_Detail) {
		// TODO Auto-generated method stub
		String sql="select sd.ckCode,partsno,partsname,partsbrand,partsmodel,sd.nums,price " +
				"from salereturn_detail sd left join baseparts " +
				"on sd.pcode= baseparts.partscodeleft " +
				"join stockout_detail on sd.ckcode=stockout_detail.code" +
				"where xtcode=?";
		ResultSet rs=super.executeQuery(sql, new Object[]{saleReturn_Detail.getXtCode()});
		List<SaleReturnDETAIL3biao> srdList=new ArrayList<SaleReturnDETAIL3biao>();
		SaleReturnDETAIL3biao srd=null;
		try {
			while(rs.next()){
				srd=new SaleReturnDETAIL3biao();
				srd.setCkCode(rs.getString("ckCode"));
				srd.setPartsNo(rs.getString("partsno"));
				srd.setPartsName(rs.getString("partsname"));
				srd.setPartsModel(rs.getString("partsmodel"));
				srd.setNums(rs.getInt("nums"));
				srd.setPrice(rs.getDouble("price"));
				srd.setPriceTotal(rs.getDouble("nums*price"));
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

}
