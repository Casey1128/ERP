package com.erp.sale.entity;

import java.util.Date;



public class SaleReturnStockOut {
	private String ckCode;//���ⵥ��
	private Date outDate;//��������
	private String partsNo;//����
	private String partsName;//�������
	private String partsBrand;//���Ʒ��
	private String partsModel;//����ͺ�
	private int nums;//����
	private double price;//�۸�
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
