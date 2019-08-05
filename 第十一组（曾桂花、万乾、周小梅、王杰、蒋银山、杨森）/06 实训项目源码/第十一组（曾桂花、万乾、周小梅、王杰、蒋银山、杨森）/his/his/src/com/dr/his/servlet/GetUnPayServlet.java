package com.dr.his.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.dr.his.entity.PayInfoEntity;
import com.dr.his.service.PayInfoService;

@WebServlet("/getUnPay")
public class GetUnPayServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String caseNo = req.getParameter("caseNo");
		PayInfoService payInfoService = new PayInfoService();
		List<PayInfoEntity> list  = payInfoService.getUnPayByCaseNo(caseNo);
		resp.setCharacterEncoding("utf-8");
		PrintWriter out = resp.getWriter();
		if(list.size() != 0) {
			String jsonStr = JSON.toJSONString(list);
			out.write(jsonStr);
		}else {
			out.write("no");
		}
		out.flush();
		out.close();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
