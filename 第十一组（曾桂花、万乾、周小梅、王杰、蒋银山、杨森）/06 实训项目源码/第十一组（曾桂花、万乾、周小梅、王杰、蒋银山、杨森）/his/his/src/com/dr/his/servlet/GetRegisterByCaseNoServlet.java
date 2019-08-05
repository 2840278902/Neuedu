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
@WebServlet("/getRegisterByCaseNo")
public class GetRegisterByCaseNoServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			RegisterService registerService = new RegisterService();
			
			String caseNo = req.getParameter("caseNo");
			if(!"".equals(caseNo) && null != caseNo) {
			RegisterEntity registerEntityWait = registerService.getRegisterByCaseNo(caseNo,0);
			RegisterEntity registerEntityBeen = registerService.getRegisterByCaseNo(caseNo,1);
			// 解决乱码
			resp.setCharacterEncoding("utf-8");
			PrintWriter out = resp.getWriter();
			if (registerEntityWait != null) {
				// 将数据转换为json格式
				String jsonstr = JSON.toJSONString(registerEntityWait);
				out.write(jsonstr);
			} else if(registerEntityBeen != null) {
				String jsonstr = JSON.toJSONString(registerEntityBeen);
				out.write(jsonstr);
			} else {
				out.write("无挂号信息！");
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
