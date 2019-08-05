package com.dr.his.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dr.his.entity.DepartmentEntity;
import com.dr.his.util.DBUtil;

public class DepDao {

	public List<DepartmentEntity> getAllDep() {
		//1����������
		Connection conn = DBUtil.getConnection();
		//�������ݿ����
		String sql = "SELECT * FROM department";
		PreparedStatement ps = null;
		List<DepartmentEntity> list = new ArrayList<>();
		try {
			ps = conn.prepareStatement(sql);
			//ִ��sql
			ResultSet resultSet = ps.executeQuery();
			while(resultSet.next()) {
				DepartmentEntity departmentEntity = new DepartmentEntity();
				departmentEntity.setDep_id(resultSet.getInt("dep_id"));
				departmentEntity.setDep_name(resultSet.getString("dep_name"));
				//��ȡ���ĵ�������װ��list��
				list.add(departmentEntity);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

}
