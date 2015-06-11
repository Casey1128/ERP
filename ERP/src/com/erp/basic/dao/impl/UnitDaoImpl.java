package com.erp.basic.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.erp.basic.dao.UnitDao;
import com.erp.basic.entity.basecusTomerSipplier;
import com.erp.utils.BaseDao;
import com.erp.utils.PageBean;
import com.erp.utils.UnitCode;



public class UnitDaoImpl extends BaseDao implements UnitDao {
	UnitCode unitCode=new UnitCode();
	
	public PageBean getUnitList(int pageNo,int pageSize) {
		// TODO Auto-generated method stub
		String sql="select * from BASECUSTOMERSUPPLIER ";
		PageBean pageBean=new PageBean();
		ResultSet rs=super.executeQueryForPage(sql, pageNo, pageSize);
		List<basecusTomerSipplier> unitList=new ArrayList<basecusTomerSipplier>();
		basecusTomerSipplier bSipplier=null;
		try {
			while(rs.next()){
				bSipplier=new basecusTomerSipplier();
				bSipplier.setCode(rs.getString("code"));//代码
				bSipplier.setCategorycode(rs.getString("categorycode"));//类别
				
				bSipplier.setCsName(rs.getString("csname"));//单位名称
				
				bSipplier.setContacter(rs.getString("contacter"));//联系人
				bSipplier.setAddress(rs.getString("address"));//公司地址
				bSipplier.setTelephone(rs.getString("telephone"));//电话
				bSipplier.setIsShow(rs.getString("isshow"));
				unitList.add(bSipplier);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			super.close();
		}
		pageBean.setData(unitList);
		int pageCount=super.executeTotalCount(sql);
		
		pageBean.setRecordCount(pageCount);
		return pageBean;
	}

	public int addUnit(basecusTomerSipplier bSipplier) {
		// TODO Auto-generated method stub
		//String code =unitCode.getUnitCode();
		//String sql="insert into BASECUSTOMERSUPPLIER(code,csname,categorycode,contacter,address,telephone) "
		String sql="insert into BASECUSTOMERSUPPLIER  "
				+ "values(?,?,sysdate,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		int ret=super.executeUpdate(sql, new Object[]{
				bSipplier.getCode(),bSipplier.getCategorycode(),
				bSipplier.getCsName(),bSipplier.getSpell(),bSipplier.getContacter(),
				bSipplier.getTelephone(),bSipplier.getMobilephone(),bSipplier.getFax(),
				bSipplier.getEmall(),bSipplier.getUrl(),bSipplier.getAddress(),
				bSipplier.getProvince(),bSipplier.getCity(),bSipplier.getQq(),
				bSipplier.getPostcide(),bSipplier.getMsn(),bSipplier.getAccount(),
				bSipplier.getAliwang(),	bSipplier.getBank(),bSipplier.getLegaler(),
				bSipplier.getTax(),bSipplier.getAgent(),bSipplier.getIsShow(),
				bSipplier.getReMarks(),bSipplier.getAddUser(),bSipplier.getAddUsername(),
				bSipplier.getAddIp(),bSipplier.getCompcode()});
		
		
		return ret;
	}

	public int deleteUnit(String  code) {
		// TODO Auto-generated method stub
		String sql="delete BASECUSTOMERSUPPLIER where code=?";
		int ret=super.executeUpdate(sql, new Object[]{code});
		return ret;
	}

	public int updateUnit(basecusTomerSipplier bSipplier) {
		// TODO Auto-generated method stub
		String sql="update BASECUSTOMERSUPPLIER  "
				+ "set Categorycode=?,AddDate=sysdate,CsName=?,Spell=?,Contacter=?,"
				+ "Telephone=?,Mobilephone=?,Fax=?,Email=?,Url=?,"
				+ "Address=?,Province=?,City=?,Qq=?,Postcode=?,"
				+ "msn=?,Account=?,Aliwang=?,bank=?,legaler=?,"
				+ "tax=?,agent=?,isshow=?,remarks=?where code=?";
		
		
		int ret=super.executeUpdate(sql, new Object[]{
				bSipplier.getCategorycode(),bSipplier.getCsName(),bSipplier.getSpell(),bSipplier.getContacter(),
				bSipplier.getTelephone(),bSipplier.getMobilephone(),bSipplier.getFax(),bSipplier.getEmall(),bSipplier.getUrl(),
				bSipplier.getAddress(),	bSipplier.getProvince(),bSipplier.getCity(),bSipplier.getQq(),bSipplier.getPostcide(),
				bSipplier.getMsn(),bSipplier.getAccount(),bSipplier.getAliwang(),bSipplier.getBank(),bSipplier.getLegaler(),
				bSipplier.getTax(),bSipplier.getAgent(),bSipplier.getIsShow(),bSipplier.getReMarks(),bSipplier.getCode()});
		return ret;
	}

	

	public PageBean findList(basecusTomerSipplier bts, int pageNO, int pageSize) {
		// TODO Auto-generated method stub
		String sql="select * from basecustomersupplier where 1=1";
		if(bts.getCode()!=null&&!bts.getCode().equals("")){
			sql+=" and code="+"'"+bts.getCode()+"'";
		}
		if(bts.getCsName()!=null&&!bts.getCsName().equals("")){
			sql+=" and csName="+"'"+bts.getCsName()+"'";
		}
		if(bts.getAddDate()!=null&&!bts.getAddDate().equals("")){
			sql+=" and to_char(adddate,'yyyy-mm-dd')= "+"'"+new SimpleDateFormat("yyyy-MM-dd").format(bts.getAddDate())+"'";
		}
		System.out.println(sql);
		
		ResultSet rs=super.executeQueryForPage(sql, pageNO, pageSize);
		PageBean pageBean=new PageBean();
		List<basecusTomerSipplier> list=new ArrayList<basecusTomerSipplier>();
		basecusTomerSipplier  bSipplier=null;
		try {
			while(rs.next()){
				bSipplier=new basecusTomerSipplier();
				bSipplier.setCode(rs.getString("code"));
				bSipplier.setCsName(rs.getString("csname"));
				bSipplier.setCategorycode(rs.getString("categorycode"));
				bSipplier.setContacter(rs.getString("contacter"));
				bSipplier.setTelephone(rs.getString("telephone"));
				bSipplier.setAddress(rs.getString("address"));
				bSipplier.setIsShow(rs.getString("isshow"));
				list.add(bSipplier);
			}
		} catch (SQLException e) {		
			e.printStackTrace();
		}finally{
			super.close();
		}
		pageBean.setData(list);
		int total=super.executeTotalCount(sql);
		pageBean.setRecordCount(total);
		System.out.println(total+"bbbbbba");
		return pageBean;
	}

	public basecusTomerSipplier findBaseCustomerSupplier(String code) {
		// TODO Auto-generated method stub
		String sql="select * from basecustomersupplier where code=?";
		ResultSet rs= super.executeQuery(sql, code);
		basecusTomerSipplier bSipplier=null;
		try {
			while (rs.next()) {
			bSipplier=new basecusTomerSipplier();
			bSipplier.setCode(rs.getString("code"));
			bSipplier.setCsName(rs.getString("csname"));
			bSipplier.setCategorycode(rs.getString("categorycode"));
			bSipplier.setContacter(rs.getString("contacter"));
			bSipplier.setTelephone(rs.getString("telephone"));
			bSipplier.setAddress(rs.getString("address"));
			bSipplier.setIsShow(rs.getString("isshow"));
			bSipplier.setAddDate(rs.getDate("adddate"));
			bSipplier.setFax(rs.getString("fax"));
			bSipplier.setPostcide(rs.getString("postcode"));
			bSipplier.setEmall(rs.getString("email"));
			bSipplier.setProvince(rs.getString("province"));
			bSipplier.setCity(rs.getString("city"));
			bSipplier.setLegaler(rs.getString("legaler"));
			bSipplier.setUrl(rs.getString("url"));
			bSipplier.setQq(rs.getString("qq"));
			bSipplier.setMsn(rs.getString("msn"));
			bSipplier.setAliwang(rs.getString("aliwang"));
			bSipplier.setAgent(rs.getString("agent"));
			bSipplier.setBank(rs.getString("bank"));
			bSipplier.setAccount(rs.getString("account"));
			bSipplier.setTax(rs.getString("tax"));
			bSipplier.setReMarks(rs.getString("remarks"));	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			super.close();
		}
		return bSipplier;
	}

	public PageBean getUnitList() {
		// TODO Auto-generated method stub
		String sql="select * from BASECUSTOMERSUPPLIER ";
		PageBean pageBean=new PageBean();
		ResultSet rs=super.executeQuery(sql);
		List<basecusTomerSipplier> unitList=new ArrayList<basecusTomerSipplier>();
		basecusTomerSipplier bSipplier=null;
		try {
			while(rs.next()){
				bSipplier=new basecusTomerSipplier();
				bSipplier.setCode(rs.getString("code"));//代码
				bSipplier.setCategorycode(rs.getString("categorycode"));//类别
				
				bSipplier.setCsName(rs.getString("csname"));//单位名称
				
				bSipplier.setContacter(rs.getString("contacter"));//联系人
				bSipplier.setAddress(rs.getString("address"));//公司地址
				bSipplier.setTelephone(rs.getString("telephone"));//电话
				bSipplier.setIsShow(rs.getString("isshow"));
				unitList.add(bSipplier);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			super.close();
		}
		pageBean.setData(unitList);
		int pageCount=super.executeTotalCount(sql);		
		pageBean.setRecordCount(pageCount);
		System.out.println(pageCount+"bbbbbb");
		return pageBean;
	}

	@Override
	public List<basecusTomerSipplier> searchList() {
		// TODO Auto-generated method stub
		return null;
	}

}
