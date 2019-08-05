package com.dr.his.service;

import java.util.List;

import com.dr.his.dao.DepDao;
import com.dr.his.entity.DepartmentEntity;

public class DepService {

	public List<DepartmentEntity> getAllDep() {
		DepDao depDao = new DepDao();
		return depDao.getAllDep();
	}

}
