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
import com.dr.his.entity.RegisterEntity;
import com.dr.his.service.RegisterService;

@WebServlet("/getWaitReg")
public class GetWaitRegisterByDorIdServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取医生id
		String doctorId = req.getParameter("doctorId");
		if(!"".equals(doctorId) && null != doctorId) {
			RegisterService registerService = new RegisterService();
			List<RegisterEntity> registerList = registerService.getWaitRegisterByDorIdCommon(doctorId,0);//0表示未诊断
			resp.setCharacterEncoding("utf-8");
			PrintWriter out = resp.getWriter();
			if(registerList.size()!=0) {
				String jsonStr = JSON.toJSONString(registerList);
				out.write(jsonStr);
			}else {
				out.write("failed");
			}
			out.flush();
			out.close();
		}else {
			System.out.println("doctorId 不存在，请检查");
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doGet(req, resp);
	}

}
