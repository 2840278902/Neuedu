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
import com.dr.his.service.DoctorService;
@WebServlet("/getDoctor")
public class GetDoctorServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// ȡֵ������Id
		String depId = req.getParameter("depId");
		// �ж�depId�Ƿ�Ϊ��
		if (!"".equals(depId) && null != depId) {
			// ��Ϊ��ִ��ת��
			int depNo = Integer.parseInt(depId);
			DoctorServlet doctorServlet = new DoctorServlet();
			List<DoctorInfoEntity> doctorInfoList = DoctorService.getDoctorByDep(depNo);
			// �������
			resp.setCharacterEncoding("utf-8");
			PrintWriter out = resp.getWriter();
			if (doctorInfoList.size() != 0) {
				// ������ת��Ϊjson��ʽ
				String jsonstr = JSON.toJSONString(doctorInfoList);
				out.write(jsonstr);
			} else {
				out.write("��ҽ����Ϣ��");
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
