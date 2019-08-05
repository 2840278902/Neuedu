package com.dr.his.entity;

public class RegisterEntity {

	private int id;//编号
	private String caseNo;//病历号
	private String rname;//姓名
	private int sex;//性别
	private int age;//年龄
	private String birthday;//出生日期
	private int settleType;//结算类别
	private String mcardNo;//医疗证号
	private int medicalType;//医疗类型
	private String idCard;//身份证
	private String address;//家庭地址
	private String vistDate;//看诊日期
	private int regLevel;//挂号级别
	private int deptNo;//挂号科室编号
	private int drId;//看诊医生
	private int regPay;//应收金额
	private int regSrc;//挂号来源
	private int diagState;//诊断状态
	private int regState;//挂号状态，默认正常
	private String invNo;//发票号
	private String regDate;//挂号日期
	private String ageType;//年龄类型
	//扩展字段：诊断页面
	private String caseInfo;//诊断信息
	//扩展字段：收费页面
	private String depName;//科室名称
	private String userName;//医生姓名
	public String getDepName() {
		return depName;
	}
	public void setDepName(String depName) {
		this.depName = depName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getCaseInfo() {
		return caseInfo;
	}
	public void setCaseInfo(String caseInfo) {
		this.caseInfo = caseInfo;
	}
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
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public int getSettleType() {
		return settleType;
	}
	public void setSettleType(int settleType) {
		this.settleType = settleType;
	}
	public String getMcardNo() {
		return mcardNo;
	}
	public void setMcardNo(String mcardNo) {
		this.mcardNo = mcardNo;
	}
	public int getMedicalType() {
		return medicalType;
	}
	public void setMedicalType(int medicalType) {
		this.medicalType = medicalType;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getVistDate() {
		return vistDate;
	}
	public void setVistDate(String vistDate) {
		this.vistDate = vistDate;
	}
	public int getRegLevel() {
		return regLevel;
	}
	public void setRegLevel(int regLevel) {
		this.regLevel = regLevel;
	}
	public int getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}
	public int getDrId() {
		return drId;
	}
	public void setDrId(int drId) {
		this.drId = drId;
	}
	public int getRegPay() {
		return regPay;
	}
	public void setRegPay(int regPay) {
		this.regPay = regPay;
	}
	public int getRegSrc() {
		return regSrc;
	}
	public void setRegSrc(int regSrc) {
		this.regSrc = regSrc;
	}
	public int getDiagState() {
		return diagState;
	}
	public void setDiagState(int diagState) {
		this.diagState = diagState;
	}
	public int getRegState() {
		return regState;
	}
	public void setRegState(int regState) {
		this.regState = regState;
	}
	public String getInvNo() {
		return invNo;
	}
	public void setInvNo(String invNo) {
		this.invNo = invNo;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public String getAgeType() {
		return ageType;
	}
	public void setAgeType(String ageType) {
		this.ageType = ageType;
	}
	
	
	
}
