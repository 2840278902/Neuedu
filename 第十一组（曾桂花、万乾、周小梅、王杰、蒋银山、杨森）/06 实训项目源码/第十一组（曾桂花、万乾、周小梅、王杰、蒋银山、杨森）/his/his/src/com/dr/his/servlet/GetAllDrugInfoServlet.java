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
import com.dr.his.entity.DrugInfoEntity;
import com.dr.his.service.DrugInfoService;

@WebServlet("/getAllDrugInfo")
public class GetAllDrugInfoServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//查询所有药品信息
		DrugInfoService drugInfoService = new DrugInfoService();
		List<DrugInfoEntity> drugInfoList = drugInfoService.getAllDrugInfo();
		//将数据写入页面
		resp.setCharacterEncoding("utf-8");
		PrintWriter out = resp.getWriter();
		//如果长度等于0则为空
		if(drugInfoList.size() != 0) {
			//将返回类型转换为json字符串
			String dataJson = JSON.toJSONString(drugInfoList);
			System.out.println("dataJson:"+dataJson);
			out.write(dataJson);
		}else {
			
			out.write("数据不存在");
		}
		out.flush();
		out.close();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
