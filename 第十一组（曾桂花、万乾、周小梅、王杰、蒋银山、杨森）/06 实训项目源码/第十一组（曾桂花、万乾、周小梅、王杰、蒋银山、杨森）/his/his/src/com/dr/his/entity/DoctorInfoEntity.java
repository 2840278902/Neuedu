package com.dr.his.entity;
/**
 * 医生信息
 * 
 * **/
public class DoctorInfoEntity {
	private int id;//医生编号
	private String zhanghao;//登陆账号
	private String username;//真实姓名
	private String inputpwd;//登陆密码
	private String dep;//所属科室编号
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getZhanghao() {
		return zhanghao;
	}
	public void setZhanghao(String zhanghao) {
		this.zhanghao = zhanghao;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getInputpwd() {
		return inputpwd;
	}
	public void setInputpwd(String inputpwd) {
		this.inputpwd = inputpwd;
	}
	public String getDep() {
		return dep;
	}
	public void setDep(String dep) {
		this.dep = dep;
	}
}
