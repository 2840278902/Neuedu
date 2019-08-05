package com.dr.his.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dr.his.entity.DoctorInfoEntity;
import com.dr.his.entity.RegisterEntity;
import com.dr.his.util.DBUtil;

public class RegisterDao {

	public int addRegister(RegisterEntity registerEntity) {
		//1、创建连接
		Connection conn = DBUtil.getConnection();
		//2、创建数据库操作
		String sql = "INSERT INTO `his`.`register` (`case_no`, `rname`, `sex`, `age`, `birthday`, `settle_type`, `mcard_no`, `medical_type`, `id_card`, `address`, `vist_date`, `reg_level`, `dept_no`, `dr_id`, `reg_pay`, `reg_src`, `diag_state`, `reg_state`, `inv_no`, `reg_date`, age_type) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			//3、传递参数
			ps.setString(1, registerEntity.getCaseNo());
			ps.setString(2, registerEntity.getRname());
			ps.setInt(3, registerEntity.getSex());
			ps.setInt(4, registerEntity.getAge());
			ps.setString(5, registerEntity.getBirthday());
			ps.setInt(6, registerEntity.getSettleType());
			ps.setString(7, registerEntity.getMcardNo());
			ps.setInt(8, registerEntity.getMedicalType());
			ps.setString(9, registerEntity.getIdCard());
			ps.setString(10, registerEntity.getAddress());
			ps.setString(11, registerEntity.getVistDate());
			ps.setInt(12, registerEntity.getRegLevel());
			ps.setInt(13, registerEntity.getDeptNo());
			ps.setInt(14, registerEntity.getDrId());
			ps.setInt(15, registerEntity.getRegPay());
			ps.setInt(16, registerEntity.getRegSrc());
			ps.setInt(17, registerEntity.getDiagState());
			ps.setInt(18, registerEntity.getRegState());
			ps.setString(19, registerEntity.getInvNo());
			ps.setString(20, registerEntity.getRegDate());
			ps.setString(21, registerEntity.getAgeType());
			//4、执行SQL
			int i = ps.executeUpdate();
			return i;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public List<RegisterEntity> getAllRegisterInfo() {
		//1、创建连接
		Connection conn = DBUtil.getConnection();
		//创建数据库操作
		String sql = "SELECT * FROM register";
		RegisterEntity registerEntity = null;
		List<RegisterEntity> list = new ArrayList<>();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			//执行sql
			ResultSet resultSet = ps.executeQuery();
			while(resultSet.next()) {
				registerEntity = new RegisterEntity();
				registerEntity.setCaseNo(resultSet.getString("case_no"));
				registerEntity.setRname(resultSet.getString("rname"));
				registerEntity.setSex(resultSet.getInt("sex"));
				registerEntity.setAge(resultSet.getInt("age"));
				registerEntity.setBirthday(resultSet.getString("birthday"));
				registerEntity.setSettleType(resultSet.getInt("settle_type"));
				registerEntity.setMcardNo(resultSet.getString("mcard_no"));
				registerEntity.setMedicalType(resultSet.getInt("medical_type"));
				registerEntity.setIdCard(resultSet.getString("id_card"));
				registerEntity.setAddress(resultSet.getString("address"));
				registerEntity.setVistDate(resultSet.getString("vist_date"));
				registerEntity.setRegLevel(resultSet.getInt("reg_level"));
				registerEntity.setDeptNo(resultSet.getInt("dept_no"));
				registerEntity.setDrId(resultSet.getInt("dr_id"));
				registerEntity.setRegPay(resultSet.getInt("reg_pay"));
				registerEntity.setRegSrc(resultSet.getInt("reg_src"));
				registerEntity.setDiagState(resultSet.getInt("diag_state"));
				registerEntity.setRegState(resultSet.getInt("reg_state"));
				registerEntity.setInvNo(resultSet.getString("inv_no"));
				registerEntity.setRegDate(resultSet.getString("reg_date"));
				registerEntity.setAgeType(resultSet.getString("age_type"));
				
				//将取到的单条数据装入list中
				list.add(registerEntity);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public RegisterEntity getRegisterByPid(String pid) {
		//1、创建连接
		Connection conn = DBUtil.getConnection();
		//创建数据库操作
		String sql = "SELECT * FROM register WHERE id_card=?";
		RegisterEntity registerEntity = null;
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			//传参
			ps.setString(1, pid);
			//执行sql
			ResultSet resultSet = ps.executeQuery();
			while(resultSet.next()) {
				registerEntity = new RegisterEntity();
				registerEntity.setCaseNo(resultSet.getString("case_no"));
				registerEntity.setRname(resultSet.getString("rname"));
				registerEntity.setSex(resultSet.getInt("sex"));
				registerEntity.setAge(resultSet.getInt("age"));
				registerEntity.setBirthday(resultSet.getString("birthday"));
				registerEntity.setSettleType(resultSet.getInt("settle_type"));
				registerEntity.setMcardNo(resultSet.getString("mcard_no"));
				registerEntity.setMedicalType(resultSet.getInt("medical_type"));
				registerEntity.setIdCard(resultSet.getString("id_card"));
				registerEntity.setAddress(resultSet.getString("address"));
				registerEntity.setVistDate(resultSet.getString("vist_date"));
				registerEntity.setRegLevel(resultSet.getInt("reg_level"));
				registerEntity.setDeptNo(resultSet.getInt("dept_no"));
				registerEntity.setDrId(resultSet.getInt("dr_id"));
				registerEntity.setRegPay(resultSet.getInt("reg_pay"));
				registerEntity.setRegSrc(resultSet.getInt("reg_src"));
				registerEntity.setDiagState(resultSet.getInt("diag_state"));
				registerEntity.setRegState(resultSet.getInt("reg_state"));
				registerEntity.setInvNo(resultSet.getString("inv_no"));
				registerEntity.setRegDate(resultSet.getString("reg_date"));
				registerEntity.setAgeType(resultSet.getString("age_type"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return registerEntity;
	}

	public RegisterEntity tuiRegisterByPid(String pid) {
		//1、创建连接
		Connection conn = DBUtil.getConnection();
		//创建数据库操作
		String sql = "SELECT * FROM register WHERE id_card=?";
		RegisterEntity registerEntity = null;
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			//传参
			ps.setString(1, pid);
			//执行sql
			ResultSet resultSet = ps.executeQuery();
			while(resultSet.next()) {
				registerEntity = new RegisterEntity();
				registerEntity.setId(resultSet.getInt("id"));
				registerEntity.setCaseNo(resultSet.getString("case_no"));
				registerEntity.setRname(resultSet.getString("rname"));
				registerEntity.setSex(resultSet.getInt("sex"));
				registerEntity.setAge(resultSet.getInt("age"));
				registerEntity.setBirthday(resultSet.getString("birthday"));
				registerEntity.setSettleType(resultSet.getInt("settle_type"));
				registerEntity.setMcardNo(resultSet.getString("mcard_no"));
				registerEntity.setMedicalType(resultSet.getInt("medical_type"));
				registerEntity.setIdCard(resultSet.getString("id_card"));
				registerEntity.setAddress(resultSet.getString("address"));
				registerEntity.setVistDate(resultSet.getString("vist_date"));
				registerEntity.setRegLevel(resultSet.getInt("reg_level"));
				registerEntity.setDeptNo(resultSet.getInt("dept_no"));
				registerEntity.setDrId(resultSet.getInt("dr_id"));
				registerEntity.setRegPay(resultSet.getInt("reg_pay"));
				registerEntity.setRegSrc(resultSet.getInt("reg_src"));
				registerEntity.setDiagState(resultSet.getInt("diag_state"));
				registerEntity.setRegState(resultSet.getInt("reg_state"));
				registerEntity.setInvNo(resultSet.getString("inv_no"));
				registerEntity.setRegDate(resultSet.getString("reg_date"));
				registerEntity.setAgeType(resultSet.getString("age_type"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return registerEntity;
	}

	public int getUnRegisterById(int id) {
				// 获取连接
				Connection connection = DBUtil.getConnection();
				// 创建数据库操作
				String sql ="UPDATE register SET reg_state=1 WHERE id=?";
				PreparedStatement ps = null;
				try {
					ps = connection.prepareStatement(sql);
					ps.setInt(1, id);
					// 执行sql
					int i = ps.executeUpdate();
					return i;
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return 0;
	}

	public List<RegisterEntity> getWaitRegisterByDorIdCommon(String doctorId,int diagState) {
		//1、创建连接
		Connection conn = DBUtil.getConnection();
		//创建数据库操作
		String sql = "SELECT * FROM register WHERE dr_id=? AND diag_state=?";
		if(diagState == 1) {
			sql = "SELECT r.*,ci.c_info FROM register r,case_info ci WHERE ci.c_no=r.case_no AND dr_id=? AND diag_state=?";
		}
		RegisterEntity registerEntity = null;
		List<RegisterEntity> list = new ArrayList<>();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			//执行sql
			ps.setInt(1, Integer.parseInt(doctorId));
			ps.setInt(2, diagState);
			ResultSet resultSet = ps.executeQuery();
			while(resultSet.next()) {
				registerEntity = new RegisterEntity();
				registerEntity.setCaseNo(resultSet.getString("case_no"));
				registerEntity.setRname(resultSet.getString("rname"));
				registerEntity.setSex(resultSet.getInt("sex"));
				registerEntity.setAge(resultSet.getInt("age"));
				registerEntity.setBirthday(resultSet.getString("birthday"));
				registerEntity.setSettleType(resultSet.getInt("settle_type"));
				registerEntity.setMcardNo(resultSet.getString("mcard_no"));
				registerEntity.setMedicalType(resultSet.getInt("medical_type"));
				registerEntity.setIdCard(resultSet.getString("id_card"));
				registerEntity.setAddress(resultSet.getString("address"));
				registerEntity.setVistDate(resultSet.getString("vist_date"));
				registerEntity.setRegLevel(resultSet.getInt("reg_level"));
				registerEntity.setDeptNo(resultSet.getInt("dept_no"));
				registerEntity.setDrId(resultSet.getInt("dr_id"));
				registerEntity.setRegPay(resultSet.getInt("reg_pay"));
				registerEntity.setRegSrc(resultSet.getInt("reg_src"));
				registerEntity.setDiagState(resultSet.getInt("diag_state"));
				registerEntity.setRegState(resultSet.getInt("reg_state"));
				registerEntity.setInvNo(resultSet.getString("inv_no"));
				registerEntity.setRegDate(resultSet.getString("reg_date"));
				registerEntity.setAgeType(resultSet.getString("age_type"));
				if(diagState == 1) {
					registerEntity.setCaseInfo(resultSet.getString("c_info"));
				}
				//将取到的单条数据装入list中
				list.add(registerEntity);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public int updateCaseInfoByCaseNo(String caseno) {
		// 获取连接
		Connection connection = DBUtil.getConnection();
		// 创建数据库操作
		String sql ="UPDATE register SET diag_state=1 WHERE case_no=?";
		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, caseno);
			// 执行sql
			int i = ps.executeUpdate();
			return i;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public RegisterEntity getRegisterByCaseNo(String caseNo, int diaState) {
		//1、创建连接
		Connection conn = DBUtil.getConnection();
		//创建数据库操作
		String sql = "SELECT * FROM register WHERE case_no=? AND diag_state=?";
		if(diaState == 1) {
			sql = "SELECT r.*,ci.c_info FROM register r,case_info ci WHERE ci.c_no=r.case_no AND case_no=? AND diag_state=?";
		}
		RegisterEntity registerEntity = null;
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			//传参
			ps.setString(1, caseNo);
			ps.setInt(2, diaState);
			//执行sql
			ResultSet resultSet = ps.executeQuery();
			while(resultSet.next()) {
				registerEntity = new RegisterEntity();
				registerEntity.setCaseNo(resultSet.getString("case_no"));
				registerEntity.setRname(resultSet.getString("rname"));
				registerEntity.setSex(resultSet.getInt("sex"));
				registerEntity.setAge(resultSet.getInt("age"));
				registerEntity.setBirthday(resultSet.getString("birthday"));
				registerEntity.setSettleType(resultSet.getInt("settle_type"));
				registerEntity.setMcardNo(resultSet.getString("mcard_no"));
				registerEntity.setMedicalType(resultSet.getInt("medical_type"));
				registerEntity.setIdCard(resultSet.getString("id_card"));
				registerEntity.setAddress(resultSet.getString("address"));
				registerEntity.setVistDate(resultSet.getString("vist_date"));
				registerEntity.setRegLevel(resultSet.getInt("reg_level"));
				registerEntity.setDeptNo(resultSet.getInt("dept_no"));
				registerEntity.setDrId(resultSet.getInt("dr_id"));
				registerEntity.setRegPay(resultSet.getInt("reg_pay"));
				registerEntity.setRegSrc(resultSet.getInt("reg_src"));
				registerEntity.setDiagState(resultSet.getInt("diag_state"));
				registerEntity.setRegState(resultSet.getInt("reg_state"));
				registerEntity.setInvNo(resultSet.getString("inv_no"));
				registerEntity.setRegDate(resultSet.getString("reg_date"));
				registerEntity.setAgeType(resultSet.getString("age_type"));
				if(diaState == 1) {
					registerEntity.setCaseInfo(resultSet.getString("c_info"));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return registerEntity;
	}

	public RegisterEntity chargeGetRegByCaseNo(String caseNo) {
		//1、创建连接
		Connection conn = DBUtil.getConnection();
		//创建数据库操作
		String sql = "SELECT re.*, c_info, de.dep_name, di.username FROM case_info AS ci , register AS re , department AS de , doctor_info AS di WHERE re.dept_no = de.dep_id AND re.dr_id = di.id AND ci.c_no = re.case_no AND re.case_no = ?";
		//String sql = "SELECT * FROM register WHERE case_no=?";
		RegisterEntity registerEntity = null;
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			//传参
			ps.setString(1, caseNo);
			//执行sql
			ResultSet resultSet = ps.executeQuery();
			while(resultSet.next()) {
				registerEntity = new RegisterEntity();
				registerEntity.setId(resultSet.getInt("id"));
				registerEntity.setCaseNo(resultSet.getString("case_no"));
				registerEntity.setRname(resultSet.getString("rname"));
				registerEntity.setSex(resultSet.getInt("sex"));
				registerEntity.setAge(resultSet.getInt("age"));
				registerEntity.setBirthday(resultSet.getString("birthday"));
				registerEntity.setSettleType(resultSet.getInt("settle_type"));
				registerEntity.setMcardNo(resultSet.getString("mcard_no"));
				registerEntity.setMedicalType(resultSet.getInt("medical_type"));
				registerEntity.setIdCard(resultSet.getString("id_card"));
				registerEntity.setAddress(resultSet.getString("address"));
				registerEntity.setVistDate(resultSet.getString("vist_date"));
				registerEntity.setRegLevel(resultSet.getInt("reg_level"));
				registerEntity.setDeptNo(resultSet.getInt("dept_no"));
				registerEntity.setDrId(resultSet.getInt("dr_id"));
				registerEntity.setRegPay(resultSet.getInt("reg_pay"));
				registerEntity.setRegSrc(resultSet.getInt("reg_src"));
				registerEntity.setDiagState(resultSet.getInt("diag_state"));
				registerEntity.setRegState(resultSet.getInt("reg_state"));
				registerEntity.setInvNo(resultSet.getString("inv_no"));
				registerEntity.setRegDate(resultSet.getString("reg_date"));
				registerEntity.setAgeType(resultSet.getString("age_type"));
				registerEntity.setDepName(resultSet.getString("dep_name"));
				registerEntity.setUserName(resultSet.getString("username"));
				registerEntity.setCaseInfo(resultSet.getString("c_info"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return registerEntity;
	}

	
}
