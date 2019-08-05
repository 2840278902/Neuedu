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
import com.dr.his.entity.DoctorInfoEntity;
import com.dr.his.entity.RegisterEntity;
import com.dr.his.service.DoctorService;
import com.dr.his.service.RegisterService;
@WebServlet("/getRegister")
public class GetRegisterServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			RegisterService registerService = new RegisterService();
			List<RegisterEntity> list = registerService.getAllRegisterInfo();
			// �������
			resp.setCharacterEncoding("utf-8");
			PrintWriter out = resp.getWriter();
			if (list.size() != 0) {
				// ������ת��Ϊjson��ʽ
				String jsonstr = JSON.toJSONString(list);
				out.write(jsonstr);
			} else {
				out.write("�޹Һ���Ϣ��");
			}
			out.flush();
			out.close();
		}
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
