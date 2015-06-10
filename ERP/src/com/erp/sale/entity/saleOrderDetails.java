
package com.erp.sale.entity;

import javassist.bytecode.CodeAttribute;

public class saleOrderDetails {
	private String code;
	private String partsNo;
	private String partsNname;
	private String partsBrand;
	private String partsModel;
	private int nums;
	private double price;
	private double totals=nums*price;
	private String remark;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getPartsNo() {
		return partsNo;
	}
	public void setPartsNo(String partsNo) {
		this.partsNo = partsNo;
	}
	public String getPartsNname() {
		return partsNname;
	}
	public void setPartsNname(String partsNname) {
		this.partsNname = partsNname;
	}
	public String getPartsBrand() {
		return partsBrand;
	}
	public void setPartsBrand(String partsBrand) {
		this.partsBrand = partsBrand;
	}
	public String getPartsModel() {
		return partsModel;
	}
	public void setPartsModel(String partsModel) {
		this.partsModel = partsModel;
	}
	public int getNums() {
		return nums;
	}
	public void setNums(int nums) {
		this.nums = nums;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getTotals() {
		return totals;
	}
	public void setTotals(double totals) {
		this.totals = totals;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
}
