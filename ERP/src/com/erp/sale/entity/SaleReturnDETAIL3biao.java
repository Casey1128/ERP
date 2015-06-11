package com.erp.sale.entity;

public class SaleReturnDETAIL3biao {
	private String ckCode;
	private String partsNo;
	private String partsName;
	private String partsBrand;
	private String partsModel;
	private int nums;
	private double price;
	private double priceTotal;
	private String remarks;
	public String getCkCode() {
		return ckCode;
	}
	public void setCkCode(String ckCode) {
		this.ckCode = ckCode;
	}
	public String getPartsNo() {
		return partsNo;
	}
	public void setPartsNo(String partsNo) {
		this.partsNo = partsNo;
	}
	public String getPartsName() {
		return partsName;
	}
	public void setPartsName(String partsName) {
		this.partsName = partsName;
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
	public double getPriceTotal() {
		return priceTotal;
	}
	public void setPriceTotal(double priceTotal) {
		this.priceTotal = priceTotal;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public SaleReturnDETAIL3biao(String ckCode, String partsNo,
			String partsName, String partsBrand, String partsModel, int nums,
			double price, double priceTotal, String remarks) {
		super();
		this.ckCode = ckCode;
		this.partsNo = partsNo;
		this.partsName = partsName;
		this.partsBrand = partsBrand;
		this.partsModel = partsModel;
		this.nums = nums;
		this.price = price;
		this.priceTotal = priceTotal;
		this.remarks = remarks;
	}
	public SaleReturnDETAIL3biao() {
		super();
	}
	
}
