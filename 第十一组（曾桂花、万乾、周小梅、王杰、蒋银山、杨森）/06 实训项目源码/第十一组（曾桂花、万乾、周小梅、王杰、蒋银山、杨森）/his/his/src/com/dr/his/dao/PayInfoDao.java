package com.dr.his.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dr.his.entity.PayInfoEntity;
import com.dr.his.util.DBUtil;

public class PayInfoDao {

	public int addPayInfo(List<PayInfoEntity> payInfoList) {
		//1、创建连接
		Connection conn = DBUtil.getConnection();
		//2、创建数据库操作
		String sql = "INSERT INTO `his`.`pay_info` (`dg_id`, `case_no`, `pay_num`, `pay_money`) VALUES (?, ?, ?, ?);";
		int i = 0;
		try {
			for(PayInfoEntity payInfoEntity : payInfoList) {
				PreparedStatement ps = conn.prepareStatement(sql);
				//3、传递参数
				ps.setInt(1, payInfoEntity.getDgId());
				ps.setString(2, payInfoEntity.getCaseNo());
				ps.setInt(3, payInfoEntity.getPayNum());
				ps.setInt(4, payInfoEntity.getTotalMoney());
				//4、执行SQL
				i = ps.executeUpdate();
			}
			return i;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	public List<PayInfoEntity> getPayDetailByCaseNo(String caseNo) {
		//1、创建连接
		Connection conn = DBUtil.getConnection();
		//创建数据库操作
		String sql = "SELECT pay_info.id, pay_info.case_no, pay_info.pay_money, pay_info.pay_state FROM pay_info WHERE case_no=?;";
		List<PayInfoEntity> list = new ArrayList<>();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, caseNo);
			//执行sql
			ResultSet resultSet = ps.executeQuery();
			while(resultSet.next()) {
				PayInfoEntity payInfoEntity = new PayInfoEntity();
				payInfoEntity.setId(resultSet.getInt("id"));
				payInfoEntity.setCaseNo(resultSet.getString("case_no"));
				payInfoEntity.setPayState(resultSet.getInt("pay_state"));
				payInfoEntity.setPayMoney(resultSet.getInt("pay_money"));
				//将取到的单条数据装入list中
				list.add(payInfoEntity);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public int updatePayStateByPayId(String[] payIds) {
		//1、创建连接
		Connection conn = DBUtil.getConnection();
		//2、创建数据库操作
		String sql = "UPDATE `his`.`pay_info` SET  `pay_date`=now(), `pay_state`=1, `remark`=NULL WHERE id=?;";
		int i = 0;
		try {
			for (int j = 0; j < payIds.length; j++) {
				PreparedStatement ps = conn.prepareStatement(sql);
				//3、传递参数
				ps.setInt(1, Integer.parseInt(payIds[j]));
				//4、执行SQL
				i = ps.executeUpdate();
			}
			return i;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	public List<PayInfoEntity> getUnPayByCaseNo(String caseNo) {
		// 获取连接
		Connection connection = DBUtil.getConnection();
		// 创建数据库操作
		
		String sql = "SELECT pd.id, pd.case_no, pd.pay_money, pd.pay_num, pd.pay_state, di.dg_name, di.dg_spec, di.dg_price, di.dg_uit, r.rname, r.settle_type"
				+" FROM pay_info pd, drug_info di, register r "
				+" WHERE  pd.dg_id=di.id  AND r.case_no=pd.case_no AND pd.pay_state=1 AND pd.pay_num!=0 AND pd.case_no=?";
		PreparedStatement ps = null;
		List<PayInfoEntity> list = new  ArrayList<>();
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, caseNo);
			// 执行sql
			ResultSet resultSet  = ps.executeQuery();
			while(resultSet.next()) {
				PayInfoEntity  payInfoEntity = new PayInfoEntity();
				payInfoEntity.setId(resultSet.getInt("id"));
				payInfoEntity.setCaseNo(resultSet.getString("case_no"));
				payInfoEntity.setPayNum(resultSet.getInt("pay_num"));
				payInfoEntity.setPayState(resultSet.getInt("pay_state"));
				payInfoEntity.setPayMoney(resultSet.getInt("pay_money"));
				payInfoEntity.setDgName(resultSet.getString("dg_name"));
				payInfoEntity.setDgSpec(resultSet.getString("dg_spec"));
				payInfoEntity.setDgPrice(resultSet.getInt("dg_price"));
				payInfoEntity.setDgUit(resultSet.getString("dg_uit"));
				payInfoEntity.setrName(resultSet.getString("rname"));
				payInfoEntity.setSettleType(resultSet.getInt("settle_type"));
				list.add(payInfoEntity);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public int updatePayNumById(List<PayInfoEntity> payInfoList) {
		//1、创建连接
		Connection conn = DBUtil.getConnection();
		//2、创建数据库操作
		String sql = "UPDATE `his`.`pay_info` SET  `pay_num`=?, `pay_money`=?, `remark`=NULL WHERE `id`=?;";
		int i = 0;
		PreparedStatement ps = null;
		try {
			for(PayInfoEntity payInfoEntity : payInfoList) {
					ps = conn.prepareStatement(sql);
					//3、传递参数
					ps.setInt(1, payInfoEntity.getPayNum());
					ps.setDouble(2, payInfoEntity.getPayMoney());
					ps.setInt(3, payInfoEntity.getId());
					//4、执行SQL
					i = ps.executeUpdate();
			}
			return i;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
}
