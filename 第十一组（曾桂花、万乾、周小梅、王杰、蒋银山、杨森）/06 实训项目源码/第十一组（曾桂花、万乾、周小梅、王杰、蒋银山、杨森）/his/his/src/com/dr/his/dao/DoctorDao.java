package com.dr.his.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dr.his.entity.DepartmentEntity;
import com.dr.his.entity.DoctorInfoEntity;
import com.dr.his.util.DBUtil;
//持久层
public class DoctorDao {

	public DoctorInfoEntity login(String zhanghao, String inputpwd) {
		//1、创建连接
		Connection conn = DBUtil.getConnection();
		//2、创建数据库操作
		String sql = "SELECT * from doctor_info WHERE zhanghao=? AND inputpwd=?";
		DoctorInfoEntity doctorInfoEntity = null;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			//3、传递参数
			ps.setString(1, zhanghao);
			ps.setString(2, inputpwd);
			//4、执行SQL
			ResultSet resultSet = ps.executeQuery();
			//5、取出返回值
			if(resultSet.next()) {
				doctorInfoEntity = new DoctorInfoEntity();
				doctorInfoEntity.setId(resultSet.getInt("id"));
				doctorInfoEntity.setZhanghao(resultSet.getString("zhanghao"));
				doctorInfoEntity.setUsername(resultSet.getString("username"));
				doctorInfoEntity.setInputpwd(resultSet.getString("inputpwd"));
				doctorInfoEntity.setDep(resultSet.getString("dep"));
				/*
				 * String username = resultSet.getString("username");
				 * System.out.println(">>："+username);
				 */
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return doctorInfoEntity;
	}

	public List<DoctorInfoEntity> getDoctorByDep(int depNo) {
		//1、创建连接
		Connection conn = DBUtil.getConnection();
		//创建数据库操作
		String sql = "SELECT id, username FROM doctor_info WHERE dep=?";
		DoctorInfoEntity doctorInfoEntity = null;
		List<DoctorInfoEntity> list = new ArrayList<>();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, depNo);
			//执行sql
			ResultSet resultSet = ps.executeQuery();
			while(resultSet.next()) {
				doctorInfoEntity = new DoctorInfoEntity();
				doctorInfoEntity.setId(resultSet.getInt("id"));
				doctorInfoEntity.setUsername(resultSet.getString("username"));
				//将取到的单条数据装入list中
				list.add(doctorInfoEntity);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
