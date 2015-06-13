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
import com.erp.stock.entity.others.BaseCustomerSupplier;
import com.erp.stock.entity.others.BaseParts;
import com.erp.stock.entity.others.PurchaseOrder;
import com.erp.stock.entity.others.PurchaseOrderDetail;
import com.erp.utils.BaseDao;
import com.erp.utils.PageBean;

public class StockInDaoImpl extends BaseDao implements StockInDao {

	Connection conn=null;
	PreparedStatement pstm=null;
	ResultSet rs=null;

	//----------------------------------查找StockIn数据并返回显示
	@Override
	public PageBean findAllDataStIn(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		PageBean pb=new PageBean();
		List<StockIn> list=new ArrayList<StockIn>();
		String sql="select * from StockIn left join baseCustomerSupplier on StockIn.supplierCode=baseCustomerSupplier.code;";
		rs=super.executeQueryForPage(sql, pageNo, pageSize);
		try {
			while(rs.next()){
				StockIn stock=new StockIn();
				stock.setCode(rs.getString("code"));
				stock.setIndate(rs.getTimestamp("indate"));
				stock.setNums(rs.getInt("nums"));
				stock.setNumsPrice(rs.getInt("numsPrice"));
				stock.setState(rs.getString("state"));
				stock.setAddUser(rs.getString("addUser"));	
				BaseCustomerSupplier supplier=new BaseCustomerSupplier();
				supplier.setCsName(rs.getString("csName"));
				
				stock.setBaseCustomerSupplier(supplier);
				list.add(stock);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			super.close();
		}
		pb.setData(list);
		int total=super.executeTotalCount(sql);
		pb.setRecordCount(total);
		pb.setPageCount(total%pageSize==0?total/pageSize:total/pageSize+1);
		pb.setPageNo(pageNo);
		pb.setPageSize(pageSize);
		return pb;
	}

	
	
	//-------------------------------------------查找供应商信息
	@Override
	public PageBean findSupplier(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		PageBean pb=new PageBean();
		List<BaseCustomerSupplier> list=new ArrayList<BaseCustomerSupplier>();
		String sql="select * from baseCustomerSupplier where categorycode='2' or categorycode='3'";
		rs=super.executeQueryForPage(sql, pageNo, pageSize);
		try {
			while(rs.next()){	
				BaseCustomerSupplier supplier=new BaseCustomerSupplier();
				supplier.setCode(rs.getString("code"));
				supplier.setCsName(rs.getString("csName"));
				supplier.setContacter(rs.getString("contacter"));
				supplier.setTelephone(rs.getString("telephone"));
				supplier.setFax(rs.getString("fax"));

				list.add(supplier);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			super.close();
		}
		pb.setData(list);
		int total=super.executeTotalCount(sql);
		pb.setRecordCount(total);
		pb.setPageCount(total%pageSize==0?total/pageSize:total/pageSize+1);
		pb.setPageNo(pageNo);
		pb.setPageSize(pageSize);
		return pb;
	}
	
	
	//-------------------------------------------选择供应商信息
	@Override
	public List findSupplierByCode(String code) {
		// TODO Auto-generated method stub
		List<BaseCustomerSupplier> list=new ArrayList<BaseCustomerSupplier>();
		String sql="select * from baseCustomerSupplier where (categorycode='2' or categorycode='3') and code=?";
		rs=super.executeQuery(sql, code);
		try {
			while(rs.next()){	
				BaseCustomerSupplier supplier=new BaseCustomerSupplier();
				supplier.setCode(rs.getString("code"));
				supplier.setCsName(rs.getString("csName"));
				supplier.setContacter(rs.getString("contacter"));
				supplier.setTelephone(rs.getString("telephone"));
				supplier.setFax(rs.getString("fax"));

				list.add(supplier);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			super.close();
		}
		return list;
	}
	
	
	//---------------------------------新增-〉数据库
	@Override
	public int addDataStIn(Object[] obj) {
		// TODO Auto-generated method stub
		String sql="insert into Stockin(code,indate,supplierCode,contacter,teltphone,fax,intype,isinvoice,remarks) "
				+ "values(?,?,?,?,?,?,?,?,?)";
		int ret=super.executeUpdate(sql, obj);
		return ret;
	}
	
	
	//------------------新增并初始化
	@Override
	public List findDataStInByCode(String code) {
		// TODO Auto-generated method stub
		List<StockIn> list=new ArrayList<StockIn>();
		String sql="select * from StockIn where code=?";
		rs=super.executeQuery(sql, new Object[]{code});
		try {
			while(rs.next()){
				StockIn stock=new StockIn();
				stock.setCode(rs.getString("code"));
				stock.setIndate(rs.getTimestamp("indate"));
				stock.setSupplierCode(rs.getString("supplierCode"));
				stock.setContacter(rs.getString("contacter"));
				stock.setTelephone(rs.getString("teltphone"));
				stock.setFax(rs.getString("fax"));
				stock.setIntype(rs.getString("intype"));
				String intype=rs.getString("intype");
				String[] intypess=intype.split("-");
				String intypese=intypess[0];
				String intypere=intypess[1];
				if(intypere.equals("正常入库")){intypere="0";}
				if(intypere.equals("冲抵入库")){intypere="1";}
				stock.setIntypere(intypere);
				stock.setIntypese(intypese);
				stock.setIsinvoice(rs.getString("isinvoice"));
				stock.setRemarks(rs.getString("remarks"));
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
	
	
	
	//----------------------------显示采购订单
	@Override
	public PageBean findPurchaseOrder(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		PageBean pb=new PageBean();
		List<PurchaseOrder> list=new ArrayList<PurchaseOrder>();
		String sql="select purchaseorder.code code,nums,numsPrice,csName,baseCustomerSupplier.code supcode "
				+ "from purchaseorder left join baseCustomerSupplier "
				+ "on purchaseorder.supplierCode=baseCustomerSupplier.code";
		rs=super.executeQueryForPage(sql, pageNo, pageSize);
		try {
			while(rs.next()){
				PurchaseOrder purchaseOrder=new PurchaseOrder();
				
				purchaseOrder.setCode(rs.getString("code"));
				purchaseOrder.setNums(rs.getInt("nums"));
				purchaseOrder.setNumsPrice(rs.getInt("numsPrice"));
				
				BaseCustomerSupplier supplier=new BaseCustomerSupplier();
				supplier.setCode(rs.getString("supcode"));
				supplier.setCsName(rs.getString("csName"));
				purchaseOrder.setBaseCustomerSupplier(supplier);
				
				list.add(purchaseOrder);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			super.close();
		}
		pb.setData(list);
		int total=super.executeTotalCount(sql);
		pb.setRecordCount(total);
		pb.setPageCount(total%pageSize==0?total/pageSize:total/pageSize+1);
		pb.setPageNo(pageNo);
		pb.setPageSize(pageSize);
		return pb;
	}
	
	
	//----------------------查看订单明细信息
	@Override
	public PageBean findPurchaseOrderDetail(String sql, int pageNo,
			int pageSize) {
		// TODO Auto-generated method stub
		PageBean pb=new PageBean();
		List<PurchaseOrderDetail> list=new ArrayList<PurchaseOrderDetail>();
		rs=super.executeQueryForPage(sql, pageNo, pageSize);
		try {
			while(rs.next()){
				PurchaseOrderDetail purchaseOrderDetail=new PurchaseOrderDetail();
				
				purchaseOrderDetail.setdCode(rs.getString("dcode"));
				purchaseOrderDetail.setNums(rs.getInt("nums"));
				purchaseOrderDetail.setPrice(rs.getInt("Price"));
				purchaseOrderDetail.setPdMoney(rs.getInt("nums")*rs.getInt("Price"));
				
				BaseParts baseParts=new BaseParts();
				baseParts.setPartsCode(rs.getString("PartsCode"));
				baseParts.setPartsName(rs.getString("PartsName"));
				baseParts.setPartsBrand(rs.getString("PartsBrand"));
				baseParts.setPartsNo(rs.getString("PartsNo"));
				baseParts.setPartsModel(rs.getString("PartsModel"));
				purchaseOrderDetail.setBaseParts(baseParts);
				
				list.add(purchaseOrderDetail);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			super.close();
		}
		pb.setData(list);
		int total=super.executeTotalCount(sql);
		pb.setRecordCount(total);
		pb.setPageCount(total%pageSize==0?total/pageSize:total/pageSize+1);
		pb.setPageNo(pageNo);
		pb.setPageSize(pageSize);
		return pb;
	}

	
	//------------------------添加订单信息
	@Override
	public int addDataStInDetail(String code) {
		// TODO Auto-generated method stub
		
		return 0;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public PageBean findPurchaseOrderDetail(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		PageBean pb=new PageBean();
		List<StockIn> list=new ArrayList<StockIn>();
		String sql="select code,purchaseorder.nums nums,numsprice,dcode,aa.nums detailnums,"
				+ "price,partsname,partsBrand,partsNo,partsModel "
				+ "from purchaseorder left join "
				+ "(select * from purchaseorder_detail left join baseparts on purchaseorder_detail.pcode=baseparts.partscode) aa "
				+ "on purchaseorder.code=aa.ocode;";
		rs=super.executeQueryForPage(sql, pageNo, pageSize);
		try {
			while(rs.next()){
				
				
				
				StockIn stock=new StockIn();
				stock.setCode(rs.getString("code"));
				stock.setIndate(rs.getTimestamp("indate"));
				stock.setNums(rs.getInt("nums"));
				stock.setNumsPrice(rs.getInt("numsPrice"));
				stock.setState(rs.getString("state"));
				stock.setAddUser(rs.getString("addUser"));	
				BaseCustomerSupplier supplier=new BaseCustomerSupplier();
				supplier.setCsName(rs.getString("csName"));
				
				stock.setBaseCustomerSupplier(supplier);
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
	public List findDataStInDetailByIncode(String incode) {
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
	public int delDataStIn(String code) {
		// TODO Auto-generated method stub
		String sql="delete from Stockin where code=? ";
		String sql2="delete from Stockin_detail where incode=?";
		int ret=super.executeUpdate(sql2, new Object[]{code});
		ret=super.executeUpdate(sql, new Object[]{code});
		super.close();
		return ret;
	}

	@Override
	public PageBean SearchDataStIn(String sql, String sqlcount, int pageNo,
			int pageSize) {
		// TODO Auto-generated method stub
		PageBean pb=new PageBean();
		List<StockIn> list=new ArrayList<StockIn>();
		rs=super.executeQueryForPage(sql, pageNo, pageSize);
		try {
			while(rs.next()){
				StockIn stock=new StockIn();
				stock.setCode(rs.getString("code"));
				stock.setIndate(rs.getTimestamp("indate"));
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
		int total=super.executeTotalCount(sqlcount);
		pb.setRecordCount(total);
		pb.setPageCount(total%pageSize==0?total/pageSize:total/pageSize+1);
		pb.setPageNo(pageNo);
		pb.setPageSize(pageSize);
		return pb;
	}





















































}
