package com.erp.basic.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.erp.basic.dao.BaseCompanyDao;
import com.erp.basic.entity.BaseCompany;
import com.erp.basic.entity.BaseContent;
import com.erp.utils.BaseDao;
import com.erp.utils.PageBean;

public class BaseCompanyDaoImpl extends BaseDao implements BaseCompanyDao {

	@Override
	public PageBean findAll(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		ResultSet rs=null;
		String sql="select categorycode,basecontent.code bcode,codename,"
				+ "compname,orderno,basecontent.remarks bremarks,basecontent.adduser badduser,basecontent.isshow bisshow  "
				+ " from basecompany join basecontent on basecompany.code=basecontent.compcode";
		rs=super.executeQueryForPage(sql, pageNo, pageSize);
		PageBean pageBean=new PageBean();
		List<BaseCompany> bcList=new ArrayList<BaseCompany>();
		BaseCompany baseCompany=null;
		BaseContent baseContent=null;
		try {
			while(rs.next()){
				baseCompany=new BaseCompany();
				baseContent=new BaseContent();
				baseContent.setCategoryCode(rs.getString("categorycode"));
				baseContent.setCode(rs.getString("bcode"));
				baseContent.setCodeName(rs.getString("codename"));
				baseCompany.setCompName(rs.getString("compname"));
				baseContent.setOrderNo(rs.getString("orderno"));
				baseContent.setRemarks(rs.getString("bremarks"));
				baseContent.setAddUser(rs.getString("badduser"));
				baseContent.setIsShow(rs.getInt("bisshow"));
				baseCompany.setBaseContent(baseContent);
				bcList.add(baseCompany);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			super.close();
		}
		pageBean.setData(bcList);
		String ssqqll="select count(*) from basecompany join basecontent on basecompany.code=basecontent.compcode";
		pageBean.setRecordCount(super.executeTotalCount(ssqqll));
		return pageBean;
	}
	
	public List<BaseCompany> searchAll(){
		String sql="select * from basecompany";
		List<BaseCompany> list=new ArrayList<BaseCompany>();
		ResultSet rs=super.executeQuery(sql);
		BaseCompany baseCompany=null;
		try{
			while(rs.next()){
				baseCompany=new BaseCompany();
				baseCompany.setCode(rs.getString("code"));
				baseCompany.setCompName(rs.getString("compname"));
				baseCompany.setCompAddress(rs.getString("compaddress"));
				baseCompany.setCompPostCode(rs.getString("comppostcode"));
				baseCompany.setCompPhone(rs.getString("compphone"));
				baseCompany.setCompFax(rs.getString("compfax"));
				baseCompany.setCompUrl(rs.getString("compurl"));
				baseCompany.setCompEmail(rs.getString("compemail"));
				baseCompany.setCompLegaler(rs.getString("complegaler"));
				baseCompany.setCompAgent(rs.getString("compagent"));
				baseCompany.setCompAccount(rs.getString("compaccount"));
				baseCompany.setCompBank(rs.getString("compbank"));
				baseCompany.setCompTax(rs.getString("comptax"));
				baseCompany.setIsShow(rs.getInt("isshow"));
				baseCompany.setRemarks(rs.getString("remarks"));
				baseCompany.setAddDate(rs.getDate("adddate"));
				baseCompany.setAddUser(rs.getString("adduser"));
				baseCompany.setAddUserName(rs.getString("addusername"));
				baseCompany.setAddIp(rs.getString("addip"));
				list.add(baseCompany);
			}
		}catch(java.sql.SQLException e){
			e.printStackTrace();
		}finally{
			super.close();
		}
		return list;
	}
	public PageBean getAll(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		ResultSet rs=null;
		String sql="select * from basecompany";
		rs=super.executeQueryForPage(sql, pageNo, pageSize);
		PageBean pageBean=new PageBean();
		List<BaseCompany> bcList=new ArrayList<BaseCompany>();
		BaseCompany baseCompany=null;
		try {
			while(rs.next()){
				baseCompany=new BaseCompany();
				baseCompany.setCode(rs.getString("code"));
				baseCompany.setCompName(rs.getString("compname"));
				baseCompany.setCompAddress(rs.getString("compaddress"));
				baseCompany.setCompPostCode(rs.getString("comppostcode"));
				baseCompany.setCompPhone(rs.getString("compphone"));
				baseCompany.setCompFax(rs.getString("compfax"));
				baseCompany.setCompUrl(rs.getString("compurl"));
				baseCompany.setCompEmail(rs.getString("compemail"));
				baseCompany.setCompLegaler(rs.getString("complegaler"));
				baseCompany.setCompAgent(rs.getString("compagent"));
				baseCompany.setCompAccount(rs.getString("compaccount"));
				baseCompany.setCompBank(rs.getString("compbank"));
				baseCompany.setCompTax(rs.getString("comptax"));
				baseCompany.setIsShow(rs.getInt("isshow"));
				baseCompany.setRemarks(rs.getString("remarks"));
				baseCompany.setAddDate(rs.getDate("adddate"));
				baseCompany.setAddUser(rs.getString("adduser"));
				baseCompany.setAddUserName(rs.getString("addusername"));
				baseCompany.setAddIp(rs.getString("addip"));
				bcList.add(baseCompany);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			super.close();
		}
		pageBean.setData(bcList);
		String ssqqll="select count(*) from basecompany join basecontent on basecompany.code=basecontent.compcode";
		pageBean.setRecordCount(super.executeTotalCount(ssqqll));
		return pageBean;
	}
	

	@Override
	public PageBean findByCid(int pageNo, int pageSize, String Cid) {
		// TODO Auto-generated method stub
		String sql="select * from basecompany where code="+Cid;
		ResultSet rs=super.executeQueryForPage(sql, pageNo, pageSize);
		PageBean pageBean=new PageBean();
		List<BaseCompany> bcList=new ArrayList<BaseCompany>();
		BaseCompany baseCompany=null;
		try {
			while(rs.next()){
				baseCompany=new BaseCompany();
				baseCompany.setCode(rs.getString("code"));
				baseCompany.setCompName(rs.getString("compname"));
				baseCompany.setCompAddress(rs.getString("compaddress"));
				baseCompany.setCompPostCode(rs.getString("comppostcode"));
				baseCompany.setCompPhone(rs.getString("compphone"));
				baseCompany.setCompFax(rs.getString("compfax"));
				baseCompany.setCompUrl(rs.getString("compurl"));
				baseCompany.setCompEmail(rs.getString("compemail"));
				baseCompany.setCompLegaler(rs.getString("complegaler"));
				baseCompany.setCompAgent(rs.getString("compagent"));
				baseCompany.setCompAccount(rs.getString("compaccount"));
				baseCompany.setCompBank(rs.getString("compbank"));
				baseCompany.setCompTax(rs.getString("comptax"));
				baseCompany.setIsShow(rs.getInt("isshow"));
				baseCompany.setRemarks(rs.getString("remarks"));
				baseCompany.setAddDate(rs.getDate("adddate"));
				baseCompany.setAddUser(rs.getString("adduser"));
				baseCompany.setAddUserName(rs.getString("addusername"));
				baseCompany.setAddIp(rs.getString("addip"));
				bcList.add(baseCompany);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			super.close();
		}
		pageBean.setData(bcList);
		pageBean.setRecordCount(super.executeTotalCount(sql));
		return pageBean;
	}

	@Override
	public int updateByCid(BaseCompany bs) {
		// TODO Auto-generated method stub
		String sql="update basecompany set compname=?,"
				+ "compaddress=?,comppostcode=?,compphone=?,compfax=?,compurl=?"
				+ ",compemail=?,complegaler=?,compagent=?,compaccount=?,compbank=?,comptax=?,remarks=? "
				+ "where code=?";
		int ret=0;
		ret=super.executeUpdate(sql,new Object[]{bs.getCompName(),
				bs.getCompAddress(),bs.getCompPostCode(),bs.getCompPhone(),
				bs.getCompFax(),bs.getCompUrl(),bs.getCompEmail(),bs.getCompLegaler(),
				bs.getCompAgent(),bs.getCompAccount(),bs.getCompBank(),
				bs.getCompTax(),bs.getRemarks(),bs.getCode()});
		return ret;
	}

}
