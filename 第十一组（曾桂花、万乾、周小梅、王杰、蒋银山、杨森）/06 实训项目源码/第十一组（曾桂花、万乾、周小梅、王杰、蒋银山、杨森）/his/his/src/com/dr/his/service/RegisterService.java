package com.dr.his.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.dr.his.dao.RegisterDao;
import com.dr.his.entity.RegisterEntity;
import com.dr.his.util.DBUtil;

public class RegisterService {

	public int addRegister(RegisterEntity registerEntity) {
		RegisterDao registerDao = new RegisterDao();
		return registerDao.addRegister(registerEntity);
	}

	public List<RegisterEntity> getAllRegisterInfo() {
		RegisterDao registerDao = new RegisterDao();
		return registerDao.getAllRegisterInfo();
	}

	public RegisterEntity getRegisterByPid(String pid) {
		RegisterDao registerDao = new RegisterDao();
		return registerDao.getRegisterByPid(pid);
	}

	public RegisterEntity tuiRegisterByPid(String pid) {
		RegisterDao registerDao = new RegisterDao();
		return registerDao.tuiRegisterByPid(pid);
	}

	public int getUnRegisterById(int id) {
		RegisterDao registerDao = new RegisterDao();
		return registerDao.getUnRegisterById(id);
	}

	public List<RegisterEntity> getWaitRegisterByDorIdCommon(String doctorId, int diagState) {
		RegisterDao registerDao = new RegisterDao();
		return registerDao.getWaitRegisterByDorIdCommon(doctorId,diagState);
	}

	public int updateCaseInfoByCaseNo(String caseNo) {
		RegisterDao registerDao = new RegisterDao();
		return registerDao.updateCaseInfoByCaseNo(caseNo);
	}

	public RegisterEntity getRegisterByCaseNo(String caseNo, int diaState) {
		RegisterDao registerDao = new RegisterDao();
		return registerDao.getRegisterByCaseNo(caseNo, diaState);
	}

	public RegisterEntity chargeGetRegByCaseNo(String caseNo) {
		RegisterDao registerDao = new RegisterDao();
		return registerDao.chargeGetRegByCaseNo(caseNo);
	}

}
