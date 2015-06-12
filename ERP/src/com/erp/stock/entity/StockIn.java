package com.erp.stock.entity;

import java.util.Date;

import com.erp.stock.entity.others.BaseCustomerSupplier;

public class StockIn {
	private String code;//...��ⵥ������
	private Date indate;//...�������
	private String contacter;
	private String telephone;
	private String fax;
	private String intype;
	private String isroad;
	private String isinvoice;
	private String remarks;
	private String isShow;
	private int nums;//...����������
	private int numsPrice;//...�������ܼ�ֵ
	private String state;//...��ⵥ��״̬��1�����0δ���
	private String compCode;
	private Date addDate;
	private String addUser;//...����Ա
	private String addUserName;
	private String addIp;
	
	
	private String intypese;
	private String intypere;
	
	
	
	
	private String supplierCode;//��Ӧ�̱��
	
	
	private StockInDetail stockInDetail;//�����ϸ�����Ϣ
	private BaseCustomerSupplier baseCustomerSupplier;//��Ӧ�̱������Ϣ
	
	
	
	
	
	
	
	
	
	
	
	
	
	
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
