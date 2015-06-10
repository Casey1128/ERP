package com.erp.stock.entity;

public class StockInDetail {
	private String code;
	private String inCode;
	private String orderCode;//订单编号
	private String pCode;//配件编号
	private String pName;//配件名称
	private String pBrand;//配件品牌
	private String pModel;//配件型号
	private int nums;//配件数量
	private int price;//配件单价
	private String wareHouse;
	private String remarks;
	private int oldPrice;
	
	private int pdTotal;//配件单个总价
	private int totalMoney;//配件全部总价
	
	
	
	
	
	
	public int getOldPrice() {
		return oldPrice;
	}
	public void setOldPrice(int oldPrice) {
		this.oldPrice = oldPrice;
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
	

	public StockInDetail(String code, String inCode, String orderCode,
			String pCode, String pName, String pBrand, String pModel, int nums,
			int price, String wareHouse, String remarks, int oldPrice,
			int pdTotal, int totalMoney) {
		super();
		this.code = code;
		this.inCode = inCode;
		this.orderCode = orderCode;
		this.pCode = pCode;
		this.pName = pName;
		this.pBrand = pBrand;
		this.pModel = pModel;
		this.nums = nums;
		this.price = price;
		this.wareHouse = wareHouse;
		this.remarks = remarks;
		this.oldPrice = oldPrice;
		this.pdTotal = pdTotal;
		this.totalMoney = totalMoney;
	}
	public StockInDetail() {
		super();
	}
}