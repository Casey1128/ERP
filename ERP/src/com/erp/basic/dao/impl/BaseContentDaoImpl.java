package com.erp.basic.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.erp.basic.dao.BaseContentDao;
import com.erp.basic.entity.BaseContent;
import com.erp.utils.BaseDao;
import com.erp.utils.PageBean;

public class BaseContentDaoImpl extends BaseDao implements BaseContentDao {

	@Override
	public PageBean findAll(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		String sql = "select * from basecontent";
		ResultSet rs = super.executeQueryForPage(sql, pageNo, pageSize);
		PageBean pageBean = new PageBean();
		List<BaseContent> bcList = new ArrayList<BaseContent>();
		BaseContent baseContent = null;
		try {
			while (rs.next()) {
				baseContent = new BaseContent();
				baseContent.setCompCode(rs.getString("compcode"));
				baseContent.setCodeName(rs.getString("codename"));
				baseContent.setCategoryCode(rs.getString("categorycode"));
				baseContent.setOrderNo(rs.getString("orderno"));
				baseContent.setIsShow(rs.getInt("isshow"));
				baseContent.setRemarks(rs.getString("remarks"));
				baseContent.setAddDate(rs.getDate("adddate"));
				baseContent.setAddUser(rs.getString("adduser"));
				baseContent.setAddUserName(rs.getString("addusername"));
				baseContent.setAddIp(rs.getString("addip"));
				baseContent.setCompCode(rs.getString("compcode"));
				bcList.add(baseContent);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			super.close();
		}
		pageBean.setData(bcList);
		pageBean.setRecordCount(super.executeTotalCount(sql));
		return pageBean;
	}

	@Override
	public int insert(BaseContent bc) {
		// TODO Auto-generated method stub
		String sql = "insert into basecontent(code,codename,categorycode,orderno,isshow,remarks,adddate,adduser,addusername,addip,compcode) "
				+ " values(?,?,?,?,?,?,sysdate,?,?,?,?) ";
		int ret = 0;
		ret = super.executeUpdate(
				sql,
				new Object[] { bc.getCode(), bc.getCodeName(),
						bc.getCategoryCode(), bc.getOrderNo(), bc.getIsShow(),
						bc.getRemarks(), "超级管理员",bc.getAddUserName(),
						bc.getAddIp(), bc.getCompCode() });
		return ret;
	}

	@Override
	public int delete(String code, String category) {
		// TODO Auto-generated method stub
		String sql = "delete from basecontent where code=? and categorycode=?";
		int ret = 0;
		ret = super.executeUpdate(sql, new Object[] { code, category });
		return ret;
	}

	@Override
	public int update(BaseContent bc) {
		// TODO Auto-generated method stub
		String sql = "update basecontent set codename=?,orderno=?,isshow=?,remarks=?,adddate=sysdate,compcode=? where code=? and categorycode=?";
		int ret = 0;
		ret = super.executeUpdate(
				sql,
				new Object[] { bc.getCodeName(),
						bc.getOrderNo(), bc.getIsShow(), bc.getRemarks(), bc.getCompCode(), bc.getCode(), bc.getCategoryCode() });
		return ret;
	}

	@Override
	public BaseContent findByCaCode(String category, String code) {
		// TODO Auto-generated method stub
		BaseContent baseContent = null;
		String sql = "select * from basecontent where categorycode=? and code=?";
		ResultSet rs = null;
		List<BaseContent> list = new ArrayList<BaseContent>();
		rs = super.executeQuery(sql, new Object[] { category, code });
		try {
			while (rs.next()) {
				baseContent = new BaseContent();
				baseContent.setCode(rs.getString("code"));
				baseContent.setCategoryCode(rs.getString("categorycode"));
				baseContent.setCodeName(rs.getString("codename"));
				baseContent.setOrderNo(rs.getString("orderno"));
				baseContent.setIsShow(rs.getInt("isshow"));
				baseContent.setRemarks(rs.getString("remarks"));
				baseContent.setCompCode(rs.getString("compcode"));
				list.add(baseContent);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list.get(0);
	}

	@Override
	public List<BaseContent> search() {
		// TODO Auto-generated method stub
		String sql = "select distinct categorycode from basecontent";
		ResultSet rs = super.executeQuery(sql);
		List<BaseContent> bcList = new ArrayList<BaseContent>();
		BaseContent baseContent = null;
		try {
			while (rs.next()) {
				baseContent = new BaseContent();

				baseContent.setCategoryCode(rs.getString("categorycode"));

				bcList.add(baseContent);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			super.close();
		}

		return bcList;
	}

}
