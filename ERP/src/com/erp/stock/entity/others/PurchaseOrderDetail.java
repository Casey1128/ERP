package com.erp.stock.entity.others;

public class PurchaseOrderDetail {//������ϸ��
	private String dCode;//������ϸ���
	private int nums;//...������Ʒ����
	private int price;//...������Ʒ�۸�
	
	private BaseParts baseParts;//�����Ϣ�������Ϣ
	
	private int pdMoney;//...������Ʒ�ܼ�
	
	
	
	
	
	
	
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
