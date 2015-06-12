package com.erp.stock.entity.others;

public class BaseCustomerSupplier {//供应商表
	private String code;//编号：客户/供应商编号
	private String cateGoryCode;//类别：1，客户2，供应商3，客户/供应商
	private String csName;//...供应商名称
	private String contacter;//...联系人
	private String telephone;//...电话
	private String fax;//...传真
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getCateGoryCode() {
		return cateGoryCode;
	}
	public void setCateGoryCode(String cateGoryCode) {
		this.cateGoryCode = cateGoryCode;
	}
	public String getCsName() {
		return csName;
	}
	public void setCsName(String csName) {
		this.csName = csName;
	}
	public String getContacter() {
		return contacter;
	}
	public void setContacter(String contacter) {
		this.contacter = contacter;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	
}
