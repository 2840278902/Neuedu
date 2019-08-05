package com.dr.his.service;

import java.util.List;

import com.dr.his.dao.DrugInfoDao;
import com.dr.his.entity.DrugInfoEntity;

public class DrugInfoService {

	public List<DrugInfoEntity> getAllDrugInfo() {
		DrugInfoDao drugInfoDao = new DrugInfoDao();
		return drugInfoDao.getAllDrugInfo();
	}

}
