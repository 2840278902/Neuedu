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
		//��ѯ����ҩƷ��Ϣ
		DrugInfoService drugInfoService = new DrugInfoService();
		List<DrugInfoEntity> drugInfoList = drugInfoService.getAllDrugInfo();
		//������д��ҳ��
		resp.setCharacterEncoding("utf-8");
		PrintWriter out = resp.getWriter();
		//������ȵ���0��Ϊ��
		if(drugInfoList.size() != 0) {
			//����������ת��Ϊjson�ַ���
			String dataJson = JSON.toJSONString(drugInfoList);
			System.out.println("dataJson:"+dataJson);
			out.write(dataJson);
		}else {
			
			out.write("���ݲ�����");
		}
		out.flush();
		out.close();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
