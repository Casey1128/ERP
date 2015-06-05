package com.erp.basic.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.erp.basic.dao.BasepartsDao;
import com.erp.basic.entity.Baseparts;
import com.erp.utils.BaseDao;
import com.erp.utils.PageBean;





public class BasepartsDaoImpl extends BaseDao implements BasepartsDao {

	public PageBean findBasepartsAll(String partsGeneralpartsno,String partsName,String partsCategory,int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		String sql="select PARTSCODE,PARTSGENERALPARTSNO,PARTSNAME,PARTSMODEL,PARTSMODELOLD," +
				"PARTSBRAND,PARTSCATEGORY,SALEPRICE,ADDUSERNAME,REMARKS,ISSHOW from baseparts where 1=1 ";
		if(partsGeneralpartsno!=null&&!partsGeneralpartsno.equals("")){
			sql+=" and PARTSCODE="+"'"+partsGeneralpartsno+"'";	
		}
		if(partsName!=null&&!partsName.equals("")){
			sql+=" and partsName="+"'"+partsName+"'";	
		}
		if(partsCategory!=null&&!partsCategory.equals("")){
			sql+=" and partsCategory="+"'"+partsCategory+"'";	
		}
		
		
		ResultSet rs=super.executeQueryForPage(sql, pageNo, pageSize);
		PageBean pageBean=new PageBean();
		List<Baseparts> basepartsList=new ArrayList<Baseparts>();
		Baseparts baseparts=null;
		try {
			while(rs.next()){
				baseparts=new Baseparts();
				baseparts.setPartsCode(rs.getString("PartsCode"));
				baseparts.setPartsGeneralpartsno(rs.getString("PARTSGENERALPARTSNO"));
				baseparts.setPartsName(rs.getString("partsname"));
				baseparts.setPartsModel(rs.getString("partsmodel"));
				baseparts.setPartsModelOld(rs.getString("partsmodelold"));
				baseparts.setPartsBrand(rs.getString("partsbrand"));
				baseparts.setPartsCategory(rs.getString("partscategory"));
				baseparts.setSalePrice(rs.getInt("saleprice"));
				baseparts.setAddUserName(rs.getString("addusername"));
				baseparts.setRemarks(rs.getString("remarks"));
				baseparts.setIsShow(rs.getString("isshow"));
				basepartsList.add(baseparts);
			}
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			super.close();
		}
		pageBean.setData(basepartsList);
		sql="select count(*) c from baseparts";
		pageBean.setRecordCount(super.executeTotalCount(sql));
		
		return pageBean;
	}

	public int insert(Baseparts baseparts) {
		// TODO Auto-generated method stub
		String sql="insert into baseparts(PARTSCODE,PARTSNAME,SPELL,PARTSCATEGORY,PARTSBRAND,PARTSNO," +
				"PARTSGENERALPARTSNO,PARTSMODEL,PARTSMODELOLD,PARTSSIZE,PARTSWEIGHT,PARTSIMG,PARTSUNIT," +
				"SALEPRICE,COSTPRICE,ISSHOW,REMARKS,ADDDATE,ADDUSER,ADDUSERNAME,ADDIP,COMPCODE)" +
				"values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		int ret=super.executeUpdate(sql, new Object[]{baseparts.getPartsCode(),baseparts.getPartsName(),
				baseparts.getSpell(),baseparts.getPartsCategory(),baseparts.getPartsBrand(),
				baseparts.getPartsNo(),baseparts.getPartsGeneralpartsno(),baseparts.getPartsModel(),
				baseparts.getPartsModelOld(),baseparts.getPartsSize(),baseparts.getPartsWeight(),
				baseparts.getPartsImg(),baseparts.getPartsUnit(),baseparts.getSalePrice(),
				baseparts.getCostPrice(),baseparts.getIsShow(),baseparts.getRemarks(),
				baseparts.getAddDate(),baseparts.getAddUser(),baseparts.getAddUserName(),
				baseparts.getAddIp(),baseparts.getCompCode()});
		return ret;
	}

	public int del(String partscode) {
		// TODO Auto-generated method stub
		String sql="delete baseparts where partscode=?";
		int ret=super.executeUpdate(sql, new Object[]{partscode});	
		return ret;
	}

	public int update(Baseparts baseparts) {
		// TODO Auto-generated method stub
		String sql="update baseparts set PARTSNAME=?,SPELL=?,PARTSCATEGORY=?,PARTSBRAND=?,PARTSNO=?," +
				"PARTSGENERALPARTSNO=?,PARTSMODEL=?,PARTSMODELOLD=?,PARTSSIZE=?,PARTSWEIGHT=?,PARTSIMG=?,PARTSUNIT=?," +
				"SALEPRICE=?,COSTPRICE=?,ISSHOW=?,REMARKS=?,ADDDATE=?,ADDUSER=?,ADDUSERNAME=?,ADDIP=?,COMPCODE=? where partsCode=?";
		return super.executeUpdate(sql, new Object[]{baseparts.getPartsName(),
				baseparts.getSpell(),baseparts.getPartsCategory(),baseparts.getPartsBrand(),
				baseparts.getPartsNo(),baseparts.getPartsGeneralpartsno(),baseparts.getPartsModel(),
				baseparts.getPartsModelOld(),baseparts.getPartsSize(),baseparts.getPartsWeight(),
				baseparts.getPartsImg(),baseparts.getPartsUnit(),baseparts.getSalePrice(),
				baseparts.getCostPrice(),baseparts.getIsShow(),baseparts.getRemarks(),
				baseparts.getAddDate(),baseparts.getAddUser(),baseparts.getAddUserName(),
				baseparts.getAddIp(),baseparts.getCompCode(),baseparts.getPartsCode()});
	}
	public static void main(String[] args) {
	BasepartsDaoImpl bDaoImpl=new BasepartsDaoImpl();
	//PageBean bean=bDaoImpl.findBasepartsAll(1, 2);
	//System.out.println(bean.getRecordCount());
	Baseparts baseparts=new Baseparts();
	baseparts.setPartsCode("00001");
	int ret=0;
	
	ret=bDaoImpl.update(baseparts);
	System.out.println(ret);
}

	public List<Baseparts> findCategoryBaseparts() {
		String sql="select DISTINCT partscategory from baseparts";
		ResultSet rs=super.executeQuery(sql);
		List<Baseparts> basepartsList=new ArrayList<Baseparts>();
		Baseparts baseparts=null;
		try {
			while(rs.next()){
				baseparts=new Baseparts();
				baseparts.setPartsCategory(rs.getString("PartsCategory"));
				basepartsList.add(baseparts);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return basepartsList;
	}	

}
