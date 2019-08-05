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
import com.dr.his.entity.DepartmentEntity;
import com.dr.his.service.DepService;

@WebServlet("/dep")
public class DepServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doGet(req, resp);
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//��ѯ���п�����Ϣ
		DepService depService = new DepService();
		List<DepartmentEntity> departmentList = depService.getAllDep();
		//������д��ҳ��
		resp.setCharacterEncoding("utf-8");
		PrintWriter out = resp.getWriter();
		//������ȵ���0��Ϊ��
		if(departmentList.size() == 0) {
			out.write("���ݲ�����");
		}else {
			//����������ת��Ϊjson�ַ���
			String dataJson = JSON.toJSONString(departmentList);
			System.out.println("dataJson:"+dataJson);
			out.write(dataJson);
		}
		out.flush();
		out.close();
	}
	
}
