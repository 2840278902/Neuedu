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

@WebServlet("/addPayInfo")
public class AddPayInfoServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String caseNo = req.getParameter("caseNo");
		String[] drugARR =req.getParameterValues("drugArr");
		List<PayInfoEntity> payInfoList = new ArrayList<>();
		for(int i = 0; i < drugARR.length; i++) {
			PayInfoEntity payInfoEntity = new PayInfoEntity();
			//��������
			String drug = drugARR[i];
			//����ǰ�˸������ַ���ֵõ�����
			String[] result = drug.split(",");
			//װ�����
			payInfoEntity.setDgId(Integer.parseInt(result[0]));
			payInfoEntity.setPayNum(Integer.parseInt(result[1]));
			payInfoEntity.setTotalMoney(Integer.parseInt(result[2]));
			payInfoEntity.setCaseNo(caseNo);
			//װ�뼯��
			payInfoList.add(payInfoEntity);
		}
		//д�����ݿ�
		PayInfoService payInfoService = new PayInfoService();
		int i = payInfoService.addPayInfo(payInfoList);
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
