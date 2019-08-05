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
		// 取值：科室Id
		String depId = req.getParameter("depId");
		// 判断depId是否为空
		if (!"".equals(depId) && null != depId) {
			// 不为空执行转型
			int depNo = Integer.parseInt(depId);
			DoctorServlet doctorServlet = new DoctorServlet();
			List<DoctorInfoEntity> doctorInfoList = DoctorService.getDoctorByDep(depNo);
			// 解决乱码
			resp.setCharacterEncoding("utf-8");
			PrintWriter out = resp.getWriter();
			if (doctorInfoList.size() != 0) {
				// 将数据转换为json格式
				String jsonstr = JSON.toJSONString(doctorInfoList);
				out.write(jsonstr);
			} else {
				out.write("无医生信息！");
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
