package com.erp.stock.entity;

public class StockInDetail {
	private String code;
	private String inCode;
	private String orderCode;//�������
	private String pCode;//������
	private String pName;//�������
	private String pBrand;//���Ʒ��
	private String pModel;//����ͺ�
	private int nums;//�������
	private int price;//�������
	private String wareHouse;
	private String remarks;

	
	private int totalNums;//�����������
	private int pdTotal;//��������ܼ�
	private int totalMoney;//���ȫ���ܼ�
	
	
	
	
	
	
	public int getTotalNums() {
		return totalNums;
	}
	public void setTotalNums(int totalNums) {
		this.totalNums = totalNums;
	}
	public String getpCode() {
		return pCode;
	}
	public void setpCode(String pCode) {
		this.pCode = pCode;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getpBrand() {
		return pBrand;
	}
	public void setpBrand(String pBrand) {
		this.pBrand = pBrand;
	}
	public String getpModel() {
		return pModel;
	}
	public void setpModel(String pModel) {
		this.pModel = pModel;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getInCode() {
		return inCode;
	}
	public void setInCode(String inCode) {
		this.inCode = inCode;
	}
	public String getOrderCode() {
		return orderCode;
	}
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
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
	public String getWareHouse() {
		return wareHouse;
	}
	public void setWareHouse(String wareHouse) {
		this.wareHouse = wareHouse;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public int getPdTotal() {
		return pdTotal;
	}
	public void setPdTotal(int pdTotal) {
		this.pdTotal = pdTotal;
	}
	public int getTotalMoney() {
		return totalMoney;
	}
	public void setTotalMoney(int totalMoney) {
		this.totalMoney = totalMoney;
	}
	

	
}