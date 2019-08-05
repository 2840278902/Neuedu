package com.dr.his.service;

import java.util.List;

import com.dr.his.dao.PayInfoDao;
import com.dr.his.entity.PayInfoEntity;

public class PayInfoService {

	public int addPayInfo(List<PayInfoEntity> payInfoList) {
		PayInfoDao payInfoDao = new PayInfoDao();
		return payInfoDao.addPayInfo(payInfoList);
	}

	public List<PayInfoEntity> getPayDetailByCaseNo(String caseNo) {
		PayInfoDao payInfoDao = new PayInfoDao();
		List<PayInfoEntity> payInfoList = payInfoDao.getPayDetailByCaseNo(caseNo);
		return payInfoList;
	}

	public int updatePayStateByPayId(String[] payIds) {
		PayInfoDao payInfoDao = new PayInfoDao();
		return payInfoDao.updatePayStateByPayId(payIds);
	}

	public List<PayInfoEntity> getUnPayByCaseNo(String caseNo) {
		PayInfoDao payInfoDao = new PayInfoDao();
		List<PayInfoEntity> payInfoEntity = payInfoDao.getUnPayByCaseNo(caseNo);
		return payInfoEntity;
	}

	public int updatePayNumById(List<PayInfoEntity> payInfoList) {
		PayInfoDao payInfoDao = new PayInfoDao();
		return payInfoDao.updatePayNumById(payInfoList);
	}

}
