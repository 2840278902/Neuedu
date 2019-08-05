package com.dr.his.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.dr.his.entity.DoctorInfoEntity;
import com.dr.his.service.DoctorService;
//����servlet.jar��
//�̳�HttpServlet
//��дdoGet/doPost
//������
@WebServlet("/Login")
public class DoctorServlet extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO Auto-generated method stub
	
		/*
		 * req.getParameter("zhanghao"); req.getParameter("inputpwd");
		 */
	System.out.println("������");
	//����ǰ̨�Ĳ���
	String zhanghao = req.getParameter("zhanghao");
	String inputpwd = req.getParameter("inputpwd");
	System.out.println("zhanghao:"+zhanghao);
	System.out.println("inputpwd:"+inputpwd);
	DoctorService ds = new DoctorService();
	DoctorInfoEntity di = ds.login(zhanghao,inputpwd);
	resp.setCharacterEncoding("utf-8");
	//���ص�ҳ��
	PrintWriter out = resp.getWriter();
	if(null == di) {
		out.write("error");
	}else {
		//��ҽ���ĵ�¼��Ϣ���ص�ǰ��
		String jsonStr = JSON.toJSONString(di);
		out.write(jsonStr);
	}
	out.flush();
	out.close();
}
@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
}
