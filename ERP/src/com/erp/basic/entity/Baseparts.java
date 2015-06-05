package com.erp.basic.entity;

import java.util.Date;

public class Baseparts {
	private String partsCode;
	private String partsName;
	private String spell;
	private String partsCategory;
	private String partsBrand;
	private String partsNo;
	private String partsGeneralpartsno;
	private String partsModel;
	private String partsModelOld;
	private String partsSize;
	private String partsWeight;
	private String partsImg;
	private String partsUnit;
	private int salePrice;
	private int costPrice;
	private String isShow;
	private String remarks;
	private Date addDate;
	private String addUser;
	private String addUserName;
	private String addIp;
	private String compCode;
	public String getPartsCode() {
		return partsCode;
	}
	public void setPartsCode(String partsCode) {
		this.partsCode = partsCode;
	}
	public String getPartsName() {
		return partsName;
	}
	public void setPartsName(String partsName) {
		this.partsName = partsName;
	}
	public String getSpell() {
		return spell;
	}
	public void setSpell(String spell) {
		this.spell = spell;
	}
	public String getPartsCategory() {
		return partsCategory;
	}
	public void setPartsCategory(String partsCategory) {
		this.partsCategory = partsCategory;
	}
	public String getPartsBrand() {
		return partsBrand;
	}
	public void setPartsBrand(String partsBrand) {
		this.partsBrand = partsBrand;
	}
	public String getPartsNo() {
		return partsNo;
	}
	public void setPartsNo(String partsNo) {
		this.partsNo = partsNo;
	}
	public String getPartsGeneralpartsno() {
		return partsGeneralpartsno;
	}
	public void setPartsGeneralpartsno(String partsGeneralpartsno) {
		this.partsGeneralpartsno = partsGeneralpartsno;
	}
	public String getPartsModel() {
		return partsModel;
	}
	public void setPartsModel(String partsModel) {
		this.partsModel = partsModel;
	}
	public String getPartsModelOld() {
		return partsModelOld;
	}
	public void setPartsModelOld(String partsModelOld) {
		this.partsModelOld = partsModelOld;
	}
	public String getPartsSize() {
		return partsSize;
	}
	public void setPartsSize(String partsSize) {
		this.partsSize = partsSize;
	}
	public String getPartsWeight() {
		return partsWeight;
	}
	public void setPartsWeight(String partsWeight) {
		this.partsWeight = partsWeight;
	}
	public String getPartsImg() {
		return partsImg;
	}
	public void setPartsImg(String partsImg) {
		this.partsImg = partsImg;
	}
	public String getPartsUnit() {
		return partsUnit;
	}
	public void setPartsUnit(String partsUnit) {
		this.partsUnit = partsUnit;
	}
	public int getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(int salePrice) {
		this.salePrice = salePrice;
	}
	public int getCostPrice() {
		return costPrice;
	}
	public void setCostPrice(int costPrice) {
		this.costPrice = costPrice;
	}
	public String getIsShow() {
		return isShow;
	}
	public void setIsShow(String isShow) {
		this.isShow = isShow;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public Date getAddDate() {
		return addDate;
	}
	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}
	public String getAddUser() {
		return addUser;
	}
	public void setAddUser(String addUser) {
		this.addUser = addUser;
	}
	public String getAddUserName() {
		return addUserName;
	}
	public void setAddUserName(String addUserName) {
		this.addUserName = addUserName;
	}
	public String getAddIp() {
		return addIp;
	}
	public void setAddIp(String addIp) {
		this.addIp = addIp;
	}
	public String getCompCode() {
		return compCode;
	}
	public void setCompCode(String compCode) {
		this.compCode = compCode;
	}
	public Baseparts(String partsCode, String partsName, String spell,
			String partsCategory, String partsBrand, String partsNo,
			String partsGeneralpartsno, String partsModel,
			String partsModelOld, String partsSize, String partsWeight,
			String partsImg, String partsUnit, int salePrice, int costPrice,
			String isShow, String remarks, Date addDate, String addUser,
			String addUserName, String addIp, String compCode) {
		super();
		this.partsCode = partsCode;
		this.partsName = partsName;
		this.spell = spell;
		this.partsCategory = partsCategory;
		this.partsBrand = partsBrand;
		this.partsNo = partsNo;
		this.partsGeneralpartsno = partsGeneralpartsno;
		this.partsModel = partsModel;
		this.partsModelOld = partsModelOld;
		this.partsSize = partsSize;
		this.partsWeight = partsWeight;
		this.partsImg = partsImg;
		this.partsUnit = partsUnit;
		this.salePrice = salePrice;
		this.costPrice = costPrice;
		this.isShow = isShow;
		this.remarks = remarks;
		this.addDate = addDate;
		this.addUser = addUser;
		this.addUserName = addUserName;
		this.addIp = addIp;
		this.compCode = compCode;
	}
	public Baseparts() {
		super();
	}
	
}
