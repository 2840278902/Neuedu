package com.dr.his.service;

import com.dr.his.dao.CaseInfoDao;

public class CaseInfoService {

	public int addCaseInfo(String caseNo, String caseInfo) {
		CaseInfoDao caseInfoDao = new CaseInfoDao();
		return caseInfoDao.addCaseInfo(caseNo,caseInfo);
	}

}
