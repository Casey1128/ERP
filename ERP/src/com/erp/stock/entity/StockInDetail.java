package com.erp.stock.entity;

import com.erp.stock.entity.others.BaseParts;
import com.erp.stock.entity.others.PurchaseOrderDetail;

public class StockInDetail {
	private String code;//入库明细主键
	private String inCode;
	private int nums;//配件数量
	private int price;//配件单价
	private String wareHouse;
	private String remarks;
	

	private String orderCode;//订单编号
	private String pCode;//配件编号
	
	private StockIn stockIn;
	private PurchaseOrderDetail purchaseOrderDetail;//订单明细表相关信息
	private BaseParts baseParts;
	
	
	
	

	public String getpCode() {
		return pCode;
	}
	public void setpCode(String pCode) {
		this.pCode = pCode;
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
	public PurchaseOrderDetail getPurchaseOrderDetail() {
		return purchaseOrderDetail;
	}
	public void setPurchaseOrderDetail(PurchaseOrderDetail purchaseOrderDetail) {
		this.purchaseOrderDetail = purchaseOrderDetail;
	}
	public StockIn getStockIn() {
		return stockIn;
	}
	public void setStockIn(StockIn stockIn) {
		this.stockIn = stockIn;
	}
	public BaseParts getBaseParts() {
		return baseParts;
	}
	public void setBaseParts(BaseParts baseParts) {
		this.baseParts = baseParts;
	}
	
	

	
}