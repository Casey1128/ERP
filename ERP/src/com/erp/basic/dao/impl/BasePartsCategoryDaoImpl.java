package com.erp.basic.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.erp.basic.dao.BasePartsCategoryDao;
import com.erp.basic.entity.BasePartsCategory;
import com.erp.utils.BaseDao;
import com.erp.utils.PageBean;

public class BasePartsCategoryDaoImpl extends BaseDao implements BasePartsCategoryDao{

	public int deleteParts(String code) {
		// TODO Auto-generated method stub
		String sql="delete from BASEPARTSCATEGORY where code=?";
		return  super.executeUpdate(sql,new Object[]{code});
	}

	public int insertParts(BasePartsCategory partsCategory) {
		// TODO Auto-generated method stub
		String sql="insert into BASEPARTSCATEGORY(code,pcode,categoryname,"
			+" isshow,remarks,compcode,adddate,adduser,addusername,addip) "
			+" values(seq_basepartcategory.nextval,?,?,?,?,?,sysdate,?,?,?)";
		int ret=super.executeUpdate(sql,new Object[]{partsCategory.getPcode()
				,partsCategory.getCategoryName(),partsCategory.getIsShow()
				,partsCategory.getRemarks(),partsCategory.getCompCode()
				,partsCategory.getAddUser(),partsCategory.getAddUserName(),partsCategory.getAddIp()});
				return ret;
	}

	public int updateParts(BasePartsCategory partsCategory) {
		// TODO Auto-generated method stub
		String sql="update BASEPARTSCATEGORY set categoryname=?,pcode=?,remarks=?,isshow=?,adduser=? "
			+" where code=?";
		return super.executeUpdate(sql,new Object[]{partsCategory.getCategoryName()
				,partsCategory.getPcode(),partsCategory.getRemarks(),partsCategory.getIsShow()
				,partsCategory.getAddUser()
				,partsCategory.getCode()});
	}
	public List<BasePartsCategory> categoryList() {
		// TODO Auto-generated method stub
		String sql="select distinct pcode from basepartscategory  ";
		ResultSet rs=super.executeQuery(sql);
		List<BasePartsCategory> partsList=new ArrayList<BasePartsCategory>();
		BasePartsCategory bpc=null;
		try {
			while(rs.next()){
				bpc=new BasePartsCategory();
				bpc.setPcode(rs.getString("pcode"));
				partsList.add(bpc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			super.close();
		}
		return partsList;
	}
	public PageBean searchByCategory(String code,String pcode,int pageNo,int pageSize) {
		// TODO Auto-generated method stub
		String sql="select code,categoryname,isshow,remarks,adddate,adduser,pcode "
			+" from BASEPARTSCATEGORY where 1=1 ";
		if(code!=null&&!code.equals("")){
			sql+=" and code='"+code+"'";
		}
		if(pcode!=null&&!pcode.equals("")){
			sql+=" and pcode='"+pcode+"'";
		}
		ResultSet rs=super.executeQueryForPage(sql,pageNo,pageSize);
		PageBean pageBean=new PageBean();
		List<BasePartsCategory> partsCategory=new ArrayList<BasePartsCategory>();
		BasePartsCategory category=null;
		try {
			while(rs.next()){
				category=new BasePartsCategory();
				category.setCode(rs.getString("code"));
				category.setPcode(rs.getString("pcode"));
				category.setCategoryName(rs.getString("categoryname"));
				category.setIsShow(rs.getString("isshow"));
				category.setRemarks(rs.getString("remarks"));
				category.setAddDate(rs.getTimestamp("adddate"));
				category.setAddUser(rs.getString("adduser"));	
				partsCategory.add(category);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			super.close();
		}
		pageBean.setData(partsCategory);
		sql="select count(code) from BASEPARTSCATEGORY order by adddate desc";
		pageBean.setRecordCount(super.executeTotalCount(sql));
		return pageBean;
	}
}
