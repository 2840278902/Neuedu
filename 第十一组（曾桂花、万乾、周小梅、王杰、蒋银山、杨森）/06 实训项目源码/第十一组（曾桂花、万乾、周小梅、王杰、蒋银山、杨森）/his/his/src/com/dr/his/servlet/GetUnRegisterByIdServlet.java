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
		// ȷ��id��Ϊ�ղ�ת��
		if(null != regsiterId && !"".equals(regsiterId)) {
			int id = Integer.parseInt(regsiterId);
			// �޸��˺�״̬
			int result = registerService.getUnRegisterById(id);
			// �������
			resp.setCharacterEncoding("utf-8");
			PrintWriter out = resp.getWriter();
			if(result != 0) {
				out.write("yes");
			}else {
				out.write("�޹Һ���Ϣ");
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
