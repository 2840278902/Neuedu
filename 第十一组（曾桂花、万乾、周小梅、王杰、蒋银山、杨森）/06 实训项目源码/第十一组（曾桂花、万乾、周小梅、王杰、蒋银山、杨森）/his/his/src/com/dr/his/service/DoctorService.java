package com.dr.his.service;

import java.util.List;

import com.dr.his.dao.DoctorDao;
import com.dr.his.entity.DoctorInfoEntity;

public class DoctorService {

	public DoctorInfoEntity login(String zhanghao, String inputpwd) {
		//ҵ���߼�����
		DoctorDao doctorDao = new DoctorDao();
		return doctorDao.login(zhanghao,inputpwd);
	}

	/**
	 * 
	 * ���ݿ���id��ҽ��
	 * @param depNo 
	 * 
	 * */

	public static List<DoctorInfoEntity> getDoctorByDep(int depNo) {
		DoctorDao doctorDao = new DoctorDao();
		return doctorDao.getDoctorByDep(depNo);
	}
	
	

}
