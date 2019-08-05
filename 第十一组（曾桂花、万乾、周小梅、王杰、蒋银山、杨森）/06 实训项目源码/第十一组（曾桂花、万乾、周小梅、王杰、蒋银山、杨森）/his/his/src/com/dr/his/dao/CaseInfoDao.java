package com.dr.his.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.dr.his.util.DBUtil;

public class CaseInfoDao {


	public int addCaseInfo(String caseNo, String caseInfo) {
		String sql = "INSERT INTO `his`.`case_info` (`c_no`, `c_info`) VALUES (?, ?);";
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, caseNo);
			ps.setString(2, caseInfo);
			int i = ps.executeUpdate();
			return i;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}
