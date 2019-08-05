package com.dr.his.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dr.his.entity.PayInfoEntity;
import com.dr.his.service.PayInfoService;

@WebServlet("/updatePayNumById")
public class UpdatePayNumByIdServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String[] idArr =req.getParameterValues("idArr");
		//写入数据库
		List<PayInfoEntity> payInfoList = new ArrayList<>();
		for(int i = 0; i < idArr.length; i++) {
			PayInfoEntity payInfoEntity = new PayInfoEntity();
			//遍历数组
			String drug = idArr[i];
			//根据前端给定的字符拆分得到数组
			String[] result = drug.split(",");
			//装入对象
			payInfoEntity.setId(Integer.parseInt(result[0]));//id
			payInfoEntity.setPayNum(Integer.parseInt(result[1]));//剩余数量
			payInfoEntity.setPayMoney(Integer.parseInt(result[2]));//剩余钱
			//装入集合
			payInfoList.add(payInfoEntity);
		}
		//写入数据库
		PayInfoService payInfoService = new PayInfoService();
		int i = payInfoService.updatePayNumById(payInfoList);
		PrintWriter out = resp.getWriter();
		if(i != 0) {
			out.write("yes");
		}else {
			out.write("no");
		}
		out.flush();
		out.close();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
}
