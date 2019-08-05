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
import com.dr.his.service.CaseInfoService;
import com.dr.his.service.RegisterService;

/*
 * 挂号
 * 
 * */
@WebServlet("/addCaseInfo")
public class AddCaseInfoServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取前台值
		String caseNo = req.getParameter("caseNo");
		String caseInfo = req.getParameter("caseInfo");
		
		CaseInfoService caseInfoService = new CaseInfoService();
		int result = caseInfoService.addCaseInfo(caseNo,caseInfo);
		
		PrintWriter out = resp.getWriter();
		if(result == 0) {
			out.write("no");
		}else {
			out.write("yes");
		}
		out.flush();
		out.close();
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
