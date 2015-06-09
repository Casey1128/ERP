package com.erp.sale.entity;

import java.util.Date;

public class SaleReturn {
	private String code;//销售退货单主键
	private Date xtDate;//销退日期
	private String customerCode;//客户编号
	private String contacter;//联系人
	private String telphone;//联系人电话
	private String fax;//传真
	private String remarks;//备注
	private String isShow;//是否显示
	private int nums;//退货数量
	private double numsPrice;//退货总价值
	private String state;//单据审核状态
	private String compCode;//所属公司
	private Date addDate;//操作日期
	private String addUser;//操作人
	private String addUserName;//操作人姓名
	private String addIp;//操作ip
	//private saleReturn_Detail saleReturn_Detail;//销售退货明细
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Date getXtDate() {
		return xtDate;
	}
	public void setXtDate(Date xtDate) {
		this.xtDate = xtDate;
	}
	public String getCustomerCode() {
		return customerCode;
	}
	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}
	public String getContacter() {
		return contacter;
	}
	public void setContacter(String contacter) {
		this.contacter = contacter;
	}
	public String getTelphone() {
		return telphone;
	}
	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
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
	public double getNumsPrice() {
		return numsPrice;
	}
	public void setNumsPrice(double numsPrice) {
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

	public SaleReturn(String code, Date xtDate, String customerCode,
			String contacter, String telphone, String fax, String remarks,
			String isShow, int nums, double numsPrice, String state,
			String compCode, Date addDate, String addUser, String addUserName,
			String addIp,
			com.erp.sale.entity.SaleReturn_Detail saleReturn_Detail) {
		super();
		this.code = code;
		this.xtDate = xtDate;
		this.customerCode = customerCode;
		this.contacter = contacter;
		this.telphone = telphone;
		this.fax = fax;
		this.remarks = remarks;
		this.isShow = isShow;
		this.nums = nums;
		this.numsPrice = numsPrice;
		this.state = state;
		this.compCode = compCode;
		this.addDate = addDate;
		this.addUser = addUser;
		this.addUserName = addUserName;
		this.addIp = addIp;
		//this.saleReturn_Detail = saleReturn_Detail;
	}
	public SaleReturn() {
		super();
	}
	

}
