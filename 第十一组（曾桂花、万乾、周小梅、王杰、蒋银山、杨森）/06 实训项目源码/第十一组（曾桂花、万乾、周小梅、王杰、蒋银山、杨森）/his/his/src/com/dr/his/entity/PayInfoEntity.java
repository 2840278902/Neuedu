package com.dr.his.entity;

public class PayInfoEntity {

	private int id;//���
	private int dgId;//ҩƷ���
	private String caseNo;//������
	private int payNum;//ҩƷ����
	private double payMoney;//�շ��ܽ��
	private String payDate;//�շ�ʱ��
	private int payState;//�շ�״̬��0��δ�շѣ�1�����շ�
	private String remark;//��ע
	
	//��չ�ֶΣ��ݴ��ܼ�
	private int totalMoney;
	private String dgName; // ҩƷ����
	private String dgSpec; // ҩƷ���
	private double dgPrice; // ҩƷ�۸�
	private String dgUit; // ҩƷ��λ
	
	// �Һ���Ϣ��
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
