package com.dr.his.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dr.his.entity.DrugInfoEntity;
import com.dr.his.util.DBUtil;

public class DrugInfoDao {

	public List<DrugInfoEntity> getAllDrugInfo() {
		//1、创建连接
		Connection conn = DBUtil.getConnection();
		//创建数据库操作
		String sql = "SELECT * FROM drug_info";
		DrugInfoEntity drugInfoEntity = null;
		PreparedStatement ps = null;
		List<DrugInfoEntity> list = new ArrayList<>();
		try {
			ps = conn.prepareStatement(sql);
			//执行sql
			ResultSet resultSet = ps.executeQuery();
			while(resultSet.next()) {
				drugInfoEntity = new DrugInfoEntity();
				drugInfoEntity.setId(resultSet.getInt("id"));
				drugInfoEntity.setDgName(resultSet.getString("dg_name"));
				drugInfoEntity.setDgSpec(resultSet.getString("dg_spec"));
				drugInfoEntity.setDgPrice(resultSet.getDouble("dg_price"));
				drugInfoEntity.setDgInv(resultSet.getInt("dg_inv"));
				drugInfoEntity.setDgUit(resultSet.getString("dg_uit"));
				//将取到的单条数据装入list中
				list.add(drugInfoEntity);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
