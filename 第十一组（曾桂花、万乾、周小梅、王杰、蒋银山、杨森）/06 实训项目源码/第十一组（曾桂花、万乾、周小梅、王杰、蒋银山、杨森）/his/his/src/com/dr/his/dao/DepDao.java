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
		//1、创建连接
		Connection conn = DBUtil.getConnection();
		//创建数据库操作
		String sql = "SELECT * FROM department";
		PreparedStatement ps = null;
		List<DepartmentEntity> list = new ArrayList<>();
		try {
			ps = conn.prepareStatement(sql);
			//执行sql
			ResultSet resultSet = ps.executeQuery();
			while(resultSet.next()) {
				DepartmentEntity departmentEntity = new DepartmentEntity();
				departmentEntity.setDep_id(resultSet.getInt("dep_id"));
				departmentEntity.setDep_name(resultSet.getString("dep_name"));
				//将取到的单条数据装入list中
				list.add(departmentEntity);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

}
