package com.dr.his.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;

import javax.imageio.spi.RegisterableService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dr.his.entity.RegisterEntity;
import com.dr.his.service.RegisterService;

/*
 * 挂号
 * 
 * */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String caseNo = req.getParameter("caseNo");
		String rName = req.getParameter("rName");
		String sexInt = req.getParameter("sex");
		String ageInt = req.getParameter("age");
		String birthday = req.getParameter("birthday");
		String settleTypeInt = req.getParameter("settle_type");
		String mcardNo = req.getParameter("mcard_no");
		String medicalTypeInt = req.getParameter("medical_type");
		String idCard = req.getParameter("idCard");
		String address = req.getParameter("address");
		String visitDate = req.getParameter("visitDate");
		String regLevelInt = req.getParameter("regLevel");
		String deptNoInt = req.getParameter("deptNo");
		String drIdInt = req.getParameter("drId");
		String regPayInt = req.getParameter("regPay");
		String regSrcInt = req.getParameter("regSrc");
		String invNo = req.getParameter("invNo");
		String ageType = req.getParameter("ageType");
		//String regDate = req.getParameter("regDate");
		
		// String 转 int
		int sex = Integer.parseInt(sexInt);
		int age = Integer.parseInt(ageInt);
		int settleType = Integer.parseInt(settleTypeInt);
		int medicalType = Integer.parseInt(medicalTypeInt);
		int regLevel = Integer.parseInt(regLevelInt);
		int deptNo = Integer.parseInt(deptNoInt);
		int drId = Integer.parseInt(drIdInt);
		int regPay = Integer.parseInt(regPayInt);
		int regSrc = Integer.parseInt(regSrcInt);
		
		//装载数据
		RegisterService registerService = new RegisterService();
		RegisterEntity registerEntity = new RegisterEntity();
		registerEntity.setCaseNo(caseNo);
		registerEntity.setRname(rName);
		registerEntity.setSex(sex);
		registerEntity.setAge(age);
		registerEntity.setBirthday(birthday);
		registerEntity.setSettleType(settleType);
		registerEntity.setMcardNo(mcardNo);
		registerEntity.setMedicalType(medicalType);
		registerEntity.setIdCard(idCard);
		registerEntity.setAddress(address);
		registerEntity.setVistDate(visitDate);
		registerEntity.setRegLevel(regLevel);
		registerEntity.setDeptNo(deptNo);
		registerEntity.setDrId(drId);
		registerEntity.setRegPay(regPay);
		registerEntity.setRegSrc(regSrc);
		registerEntity.setDiagState(0);
		registerEntity.setRegState(0);
		registerEntity.setInvNo(invNo);
		registerEntity.setRegDate(currentDate());
		registerEntity.setAgeType(ageType);
		
		
		int result = registerService.addRegister(registerEntity);
		
		PrintWriter out = resp.getWriter();
		if(result == 0) {
			out.write("no");
		}else {
			out.write("yes");
		}
		out.flush();
		out.close();
	}
	//获取当前日期
	public String currentDate(){
		Calendar c = Calendar.getInstance();
		//获取年份
		int year = c.get(Calendar.YEAR);
		//获取月份
		int month = c.get(Calendar.MONTH) + 1;
		//获取日期
		int day = c.get(Calendar.DATE);
		String cdate = year + "-" + month + "-" + day;
		return cdate;
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
