package com.erp.sale.entity;

import java.util.Date;

import com.erp.basic.entity.basecusTomerSipplier;

public class saleQuotation {
	private String code;//bj2015
	private Date sqdate;
	private String customercode;//kh2015
	private String contacter;
	private String telphone;
	private String fax;
	private int nums;
	private int numsprice;
	private String isShow;
	private String state;
	private String remarks;
	private Date addDate;
	private String addUser;
	private String addUserName;
	private String addIp;
	private String compcode;
	private basecusTomerSipplier bSipplier;
	
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public Date getAddDate() {
		return addDate;
	}
	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}
	
	public basecusTomerSipplier getbSipplier() {
		return bSipplier;
	}
	public void setbSipplier(basecusTomerSipplier bSipplier) {
		this.bSipplier = bSipplier;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Date getSqdate() {
		return sqdate;
	}
	public void setSqdate(Date sqdate) {
		this.sqdate = sqdate;
	}
	public String getCustomercode() {
		return customercode;
	}
	public void setCustomercode(String customercode) {
		this.customercode = customercode;
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
	
	public int getNums() {
		return nums;
	}
	public void setNums(int nums) {
		this.nums = nums;
	}
	public int getNumsprice() {
		return numsprice;
	}
	public void setNumsprice(int numsprice) {
		this.numsprice = numsprice;
	}
	public String getIsShow() {
		return isShow;
	}
	public void setIsShow(String isShow) {
		this.isShow = isShow;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
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
	public String getCompcode() {
		return compcode;
	}
	public void setCompcode(String compcode) {
		this.compcode = compcode;
	}
	
	
}
