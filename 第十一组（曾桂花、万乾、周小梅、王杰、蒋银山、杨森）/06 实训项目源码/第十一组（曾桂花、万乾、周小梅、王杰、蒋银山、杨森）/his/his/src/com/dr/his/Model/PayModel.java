package com.dr.his.Model;

public class PayModel {

	private int id;//����id
	private String caseNo;//������
	private int totalMoney;//�ܽ��
	private int payState;//֧��״̬��0δ֧����1��֧��
	private int payNum;//ҩƷ����
	private int dgPrice;//ҩƷ�۸�
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCaseNo() {
		return caseNo;
	}
	public void setCaseNo(String caseNo) {
		this.caseNo = caseNo;
	}
	public int getTotalMoney() {
		return totalMoney;
	}
	public void setTotalMoney(int totalMoney) {
		this.totalMoney = totalMoney;
	}
	public int getPayState() {
		return payState;
	}
	public void setPayState(int payState) {
		this.payState = payState;
	}
	public int getPayNum() {
		return payNum;
	}
	public void setPayNum(int payNum) {
		this.payNum = payNum;
	}
	public int getDgPrice() {
		return dgPrice;
	}
	public void setDgPrice(int dgPrice) {
		this.dgPrice = dgPrice;
	}
	
}
