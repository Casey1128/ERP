package com.erp.purchase.entity;

public class PurchaseInquery_Detail {
	private String dCode;       //明细编号
	private String xCode;       //询价单号
	private String pCode;      //配件编号
	private int nums;             //配件数量
	private int price;              //单价
	private String deliveryMode; //交货期
	private String remarks;         //备注
	public String getdCode() {
		return dCode;
	}
	public void setdCode(String dCode) {
		this.dCode = dCode;
	}
	public String getxCode() {
		return xCode;
	}
	public void setxCode(String xCode) {
		this.xCode = xCode;
	}
	public String getpCode() {
		return pCode;
	}
	public void setpCode(String pCode) {
		this.pCode = pCode;
	}
	public int getNums() {
		return nums;
	}
	public void setNums(int nums) {
		this.nums = nums;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDeliveryMode() {
		return deliveryMode;
	}
	public void setDeliveryMode(String deliveryMode) {
		this.deliveryMode = deliveryMode;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
}
