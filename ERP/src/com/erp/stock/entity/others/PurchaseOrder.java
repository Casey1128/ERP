package com.erp.stock.entity.others;

public class PurchaseOrder {//������
	private String code;//....�������
	private int nums;//...���������
	private int numsPrice;//...����ܼ۸�
	private BaseCustomerSupplier baseCustomerSupplier;//��Ӧ�̱������Ϣ
	private PurchaseOrderDetail purchaseOrderDetail;//������ϸ�������Ϣ
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
