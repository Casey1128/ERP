package com.erp.stock.entity.others;

public class PurchaseOrderDetail {//订单明细表
	private String dCode;//订单明细编号
	private int nums;//...单个物品数量
	private int price;//...单个物品价格
	
	private BaseParts baseParts;//配件信息表相关信息
	
	private int pdMoney;//...单个物品总价
	
	
	
	
	
	
	
	public String getdCode() {
		return dCode;
	}
	public void setdCode(String dCode) {
		this.dCode = dCode;
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
	public BaseParts getBaseParts() {
		return baseParts;
	}
	public void setBaseParts(BaseParts baseParts) {
		this.baseParts = baseParts;
	}
	public int getPdMoney() {
		return pdMoney;
	}
	public void setPdMoney(int pdMoney) {
		this.pdMoney = pdMoney;
	}

	
}
