package com.erp.sale.entity;

import java.util.Date;



public class SaleReturnStockOut {
	private String ckCode;//出库单号
	private Date outDate;//出库日期
	private String partsNo;//件号
	private String partsName;//配件名称
	private String partsBrand;//配件品牌
	private String partsModel;//配件型号
	private int nums;//数量
	private double price;//价格
	public String getCkCode() {
		return ckCode;
	}
	public void setCkCode(String ckCode) {
		this.ckCode = ckCode;
	}
	public Date getOutDate() {
		return outDate;
	}
	public void setOutDate(Date outDate) {
		this.outDate = outDate;
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
	public SaleReturnStockOut(String ckCode, Date outDate, String partsNo,
			String partsName, String partsBrand, String partsModel, int nums,
			double price) {
		super();
		this.ckCode = ckCode;
		this.outDate = outDate;
		this.partsNo = partsNo;
		this.partsName = partsName;
		this.partsBrand = partsBrand;
		this.partsModel = partsModel;
		this.nums = nums;
		this.price = price;
	}
	public SaleReturnStockOut() {
		super();
	}
	
}
