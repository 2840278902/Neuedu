package com.dr.his.entity;

public class PayInfoEntity {

	private int id;//编号
	private int dgId;//药品编号
	private String caseNo;//病历号
	private int payNum;//药品数量
	private double payMoney;//收费总金额
	private String payDate;//收费时间
	private int payState;//收费状态：0：未收费，1：已收费
	private String remark;//备注
	
	//扩展字段：暂存总价
	private int totalMoney;
	private String dgName; // 药品名称
	private String dgSpec; // 药品规格
	private double dgPrice; // 药品价格
	private String dgUit; // 药品单位
	
	// 挂号信息表
	private int settleType;
	private String rName;
	
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
	public String getDgUit() {
		return dgUit;
	}
	public void setDgUit(String dgUit) {
		this.dgUit = dgUit;
	}
	public int getSettleType() {
		return settleType;
	}
	public void setSettleType(int settleType) {
		this.settleType = settleType;
	}
	public String getrName() {
		return rName;
	}
	public void setrName(String rName) {
		this.rName = rName;
	}
	public int getTotalMoney() {
		return totalMoney;
	}
	public void setTotalMoney(int totalMoney) {
		this.totalMoney = totalMoney;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDgId() {
		return dgId;
	}
	public void setDgId(int dgId) {
		this.dgId = dgId;
	}
	public String getCaseNo() {
		return caseNo;
	}
	public void setCaseNo(String caseNo) {
		this.caseNo = caseNo;
	}
	public int getPayNum() {
		return payNum;
	}
	public void setPayNum(int payNum) {
		this.payNum = payNum;
	}
	public double getPayMoney() {
		return payMoney;
	}
	public void setPayMoney(double payMoney) {
		this.payMoney = payMoney;
	}
	public String getPayDate() {
		return payDate;
	}
	public void setPayDate(String payDate) {
		this.payDate = payDate;
	}
	public int getPayState() {
		return payState;
	}
	public void setPayState(int payState) {
		this.payState = payState;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
