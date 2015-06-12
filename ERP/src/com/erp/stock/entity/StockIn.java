package com.erp.stock.entity;

import java.util.Date;

import com.erp.stock.entity.others.BaseCustomerSupplier;

public class StockIn {
	private String code;//...入库单据主键
	private Date indate;//...入库日期
	private String contacter;
	private String telephone;
	private String fax;
	private String intype;
	private String isroad;
	private String isinvoice;
	private String remarks;
	private String isShow;
	private int nums;//...入库配件数量
	private int numsPrice;//...入库配件总价值
	private String state;//...入库单据状态，1已审核0未审核
	private String compCode;
	private Date addDate;
	private String addUser;//...操作员
	private String addUserName;
	private String addIp;
	
	
	private String intypese;
	private String intypere;
	
	
	
	
	private String supplierCode;//供应商编号
	
	
	private StockInDetail stockInDetail;//入库明细相关信息
	private BaseCustomerSupplier baseCustomerSupplier;//供应商表相关信息
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Date getIndate() {
		return indate;
	}
	public void setIndate(Date indate) {
		this.indate = indate;
	}
	public String getSupplierCode() {
		return supplierCode;
	}
	public void setSupplierCode(String supplierCode) {
		this.supplierCode = supplierCode;
	}
	public String getContacter() {
		return contacter;
	}
	public void setContacter(String contacter) {
		this.contacter = contacter;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getIntype() {
		return intype;
	}
	public void setIntype(String intype) {
		this.intype = intype;
	}
	public String getIsroad() {
		return isroad;
	}
	public void setIsroad(String isroad) {
		this.isroad = isroad;
	}
	public String getIsinvoice() {
		return isinvoice;
	}
	public void setIsinvoice(String isinvoice) {
		this.isinvoice = isinvoice;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getIsShow() {
		return isShow;
	}
	public void setIsShow(String isShow) {
		this.isShow = isShow;
	}
	public int getNums() {
		return nums;
	}
	public void setNums(int nums) {
		this.nums = nums;
	}
	public int getNumsPrice() {
		return numsPrice;
	}
	public void setNumsPrice(int numsPrice) {
		this.numsPrice = numsPrice;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCompCode() {
		return compCode;
	}
	public void setCompCode(String compCode) {
		this.compCode = compCode;
	}
	public Date getAddDate() {
		return addDate;
	}
	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}
	public String getAddUser() {
		return addUser;
	}
	public void setAddUser(String addUser) {
		this.addUser = addUser;
	}
	public String getAddUserName() {
		return addUserName;
	}
	public void setAddUserName(String addUserName) {
		this.addUserName = addUserName;
	}
	public String getAddIp() {
		return addIp;
	}
	public void setAddIp(String addIp) {
		this.addIp = addIp;
	}
	public String getIntypese() {
		return intypese;
	}
	public void setIntypese(String intypese) {
		this.intypese = intypese;
	}
	public String getIntypere() {
		return intypere;
	}
	public void setIntypere(String intypere) {
		this.intypere = intypere;
	}

	public StockInDetail getStockInDetail() {
		return stockInDetail;
	}
	public void setStockInDetail(StockInDetail stockInDetail) {
		this.stockInDetail = stockInDetail;
	}
	public BaseCustomerSupplier getBaseCustomerSupplier() {
		return baseCustomerSupplier;
	}
	public void setBaseCustomerSupplier(BaseCustomerSupplier baseCustomerSupplier) {
		this.baseCustomerSupplier = baseCustomerSupplier;
	}
	
	
	
	
	
	
	
}
