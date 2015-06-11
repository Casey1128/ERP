package com.erp.sale.entity;

import java.util.Date;

public class SaleReturn {
	private String code;//�����˻�������
	private Date xtDate;//��������
	private String customerCode;//�ͻ����
	private String contacter;//��ϵ��
	private String telphone;//��ϵ�˵绰
	private String fax;//����
	private String remarks;//��ע
	private String isShow;//�Ƿ���ʾ
	private int nums;//�˻�����
	private double numsPrice;//�˻��ܼ�ֵ
	private String state;//�������״̬
	private String compCode;//������˾
	private Date addDate;//��������
	private String addUser;//������
	private String addUserName;//����������
	private String addIp;//����ip
	//private saleReturn_Detail saleReturn_Detail;//�����˻���ϸ
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
