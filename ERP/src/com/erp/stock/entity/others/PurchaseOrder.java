package com.erp.stock.entity.others;

public class PurchaseOrder {//订单表
	private String code;//....订单编号
	private int nums;//...配件总数量
	private int numsPrice;//...配件总价格
	private BaseCustomerSupplier baseCustomerSupplier;//供应商表相关信息
	private PurchaseOrderDetail purchaseOrderDetail;//订单明细表相关信息
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
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
	public BaseCustomerSupplier getBaseCustomerSupplier() {
		return baseCustomerSupplier;
	}
	public void setBaseCustomerSupplier(BaseCustomerSupplier baseCustomerSupplier) {
		this.baseCustomerSupplier = baseCustomerSupplier;
	}
	public PurchaseOrderDetail getPurchaseOrderDetail() {
		return purchaseOrderDetail;
	}
	public void setPurchaseOrderDetail(PurchaseOrderDetail purchaseOrderDetail) {
		this.purchaseOrderDetail = purchaseOrderDetail;
	}
	
}
