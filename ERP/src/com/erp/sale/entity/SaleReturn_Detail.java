package com.erp.sale.entity;

import com.erp.basic.entity.Baseparts;

public class SaleReturn_Detail {
	private String code;//��ϸ����
	private String xtCode;//���˵���
	private String ckCode;//���ⵥ��
	private String pCode;//�������
	private int nums;//�������
	private String remarks;//��ע
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getXtCode() {
		return xtCode;
	}
	public void setXtCode(String xtCode) {
		this.xtCode = xtCode;
	}
	public String getCkCode() {
		return ckCode;
	}
	public void setCkCode(String ckCode) {
		this.ckCode = ckCode;
	}
	public String getpCode() {
		return pCode;
	}
	public void setpCode(String pCode) {
		this.pCode = pCode;
	}
	public int getNums() {
		return nums;
	}
	public void setNums(int nums) {
		this.nums = nums;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public SaleReturn_Detail(String code, String xtCode, String ckCode,
			String pCode, int nums, String remarks) {
		super();
		this.code = code;
		this.xtCode = xtCode;
		this.ckCode = ckCode;
		this.pCode = pCode;
		this.nums = nums;
		this.remarks = remarks;
	}
	public SaleReturn_Detail() {
		super();
	}
	
	
}
