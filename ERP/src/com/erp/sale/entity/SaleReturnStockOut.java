package com.erp.sale.entity;

import java.util.Date;



public class SaleReturnStockOut {
	private String code;//���ⵥ��
	private Date outDate;//��������
	private String partsNo;//����
	private String partsName;//�������
	private String partsbrand;//���Ʒ��
	private String partsModel;//����ͺ�
	private int nums;//����
	private double price;//�۸�
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
