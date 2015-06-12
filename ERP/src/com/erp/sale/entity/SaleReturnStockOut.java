package com.erp.sale.entity;

import java.util.Date;



public class SaleReturnStockOut {
	private String code;//出库单号
	private Date outDate;//出库日期
	private String partsNo;//件号
	private String partsName;//配件名称
	private String partsbrand;//配件品牌
	private String partsModel;//配件型号
	private int nums;//数量
	private double price;//价格
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
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
	public String getPartsbrand() {
		return partsbrand;
	}
	public void setPartsbrand(String partsbrand) {
		this.partsbrand = partsbrand;
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
	public SaleReturnStockOut(String code, Date outDate, String partsNo,
			String partsName, String partsbrand, String partsModel, int nums,
			double price) {
		super();
		this.code = code;
		this.outDate = outDate;
		this.partsNo = partsNo;
		this.partsName = partsName;
		this.partsbrand = partsbrand;
		this.partsModel = partsModel;
		this.nums = nums;
		this.price = price;
	}
	public SaleReturnStockOut() {
		super();
	}
	
	

}
