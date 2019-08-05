package com.dr.his.entity;
/*
 * 药品信息
 * 
 * */
public class DrugInfoEntity {

	private int id;//药品编号
	private String dgName;//药品名称
	private String dgSpec;//药品规格
	private double dgPrice;//药品价格
	private int dgInv;//药品编号
	private String dgUit;//药品单位
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDgName() {
		return dgName;
	}
	public void setDgName(String dgName) {
		this.dgName = dgName;
	}
	public String getDgSpec() {
		return dgSpec;
	}
	public void setDgSpec(String dgSpec) {
		this.dgSpec = dgSpec;
	}
	public double getDgPrice() {
		return dgPrice;
	}
	public void setDgPrice(double dgPrice) {
		this.dgPrice = dgPrice;
	}
	public int getDgInv() {
		return dgInv;
	}
	public void setDgInv(int dgInv) {
		this.dgInv = dgInv;
	}
	public String getDgUit() {
		return dgUit;
	}
	public void setDgUit(String dgUit) {
		this.dgUit = dgUit;
	}
	
	
}
