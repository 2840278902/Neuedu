package com.dr.his.service;

import java.util.List;

import com.dr.his.dao.DoctorDao;
import com.dr.his.entity.DoctorInfoEntity;

public class DoctorService {

	public DoctorInfoEntity login(String zhanghao, String inputpwd) {
		//业务逻辑处理
		DoctorDao doctorDao = new DoctorDao();
		return doctorDao.login(zhanghao,inputpwd);
	}

	/**
	 * 
	 * 根据科室id查医生
	 * @param depNo 
	 * 
	 * */

	public static List<DoctorInfoEntity> getDoctorByDep(int depNo) {
		DoctorDao doctorDao = new DoctorDao();
		return doctorDao.getDoctorByDep(depNo);
	}
	
	

}
