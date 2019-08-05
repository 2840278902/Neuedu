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
		
		//查询所有科室信息
		DepService depService = new DepService();
		List<DepartmentEntity> departmentList = depService.getAllDep();
		//将数据写入页面
		resp.setCharacterEncoding("utf-8");
		PrintWriter out = resp.getWriter();
		//如果长度等于0则为空
		if(departmentList.size() == 0) {
			out.write("数据不存在");
		}else {
			//将返回类型转换为json字符串
			String dataJson = JSON.toJSONString(departmentList);
			System.out.println("dataJson:"+dataJson);
			out.write(dataJson);
		}
		out.flush();
		out.close();
	}
	
}
