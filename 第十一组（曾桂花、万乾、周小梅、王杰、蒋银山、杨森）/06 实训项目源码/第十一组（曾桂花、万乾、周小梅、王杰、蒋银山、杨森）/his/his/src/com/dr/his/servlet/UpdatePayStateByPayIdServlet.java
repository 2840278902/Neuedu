package com.dr.his.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dr.his.service.PayInfoService;

@WebServlet("/updatePayStateByPayId")
public class UpdatePayStateByPayIdServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String[] payIds =req.getParameterValues("payId");
		//Ð´ÈëÊý¾Ý¿â
		PayInfoService payInfoService = new PayInfoService();
		int i = payInfoService.updatePayStateByPayId(payIds);
		PrintWriter out = resp.getWriter();
		if(i != 0) {
			out.write("yes");
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
