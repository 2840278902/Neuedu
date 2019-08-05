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
//导入servlet.jar包
//继承HttpServlet
//重写doGet/doPost
//控制器
@WebServlet("/Login")
public class DoctorServlet extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO Auto-generated method stub
	
		/*
		 * req.getParameter("zhanghao"); req.getParameter("inputpwd");
		 */
	System.out.println("来过了");
	//接收前台的参数
	String zhanghao = req.getParameter("zhanghao");
	String inputpwd = req.getParameter("inputpwd");
	System.out.println("zhanghao:"+zhanghao);
	System.out.println("inputpwd:"+inputpwd);
	DoctorService ds = new DoctorService();
	DoctorInfoEntity di = ds.login(zhanghao,inputpwd);
	resp.setCharacterEncoding("utf-8");
	//返回到页面
	PrintWriter out = resp.getWriter();
	if(null == di) {
		out.write("error");
	}else {
		//将医生的登录信息返回到前端
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
