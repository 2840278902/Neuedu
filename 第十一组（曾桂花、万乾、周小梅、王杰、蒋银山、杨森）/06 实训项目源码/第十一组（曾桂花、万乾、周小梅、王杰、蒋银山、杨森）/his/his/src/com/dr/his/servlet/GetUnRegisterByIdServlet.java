package com.dr.his.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dr.his.service.RegisterService;

@WebServlet("/getUnRegisterById")
public class GetUnRegisterByIdServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RegisterService registerService = new RegisterService();
		
		String regsiterId = req.getParameter("regsiterId");
		// 确定id不为空并转型
		if(null != regsiterId && !"".equals(regsiterId)) {
			int id = Integer.parseInt(regsiterId);
			// 修改退号状态
			int result = registerService.getUnRegisterById(id);
			// 解决乱码
			resp.setCharacterEncoding("utf-8");
			PrintWriter out = resp.getWriter();
			if(result != 0) {
				out.write("yes");
			}else {
				out.write("无挂号信息");
			}
			out.flush();
			out.close();
		}
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
