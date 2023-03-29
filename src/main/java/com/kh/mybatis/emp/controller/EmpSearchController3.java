package com.kh.mybatis.emp.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.mybatis.common.AbstractController;
import com.kh.mybatis.emp.model.service.EmpService;
import com.kh.mybatis.emp.model.service.EmpServiceImpl;

public class EmpSearchController3 extends AbstractController {

	private EmpService empService = new EmpServiceImpl();

	@Override
	public String doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//1. 사용자입력값
			String[] jobCodeArr = request.getParameterValues("jobCode");
			String[] deptCodeArr = request.getParameterValues("deptCode");
			
			List<String> deptCodeList = null;
			if(deptCodeArr != null)
				deptCodeList = Arrays.asList(deptCodeArr);//배열 뿐만 아니라 리스트 셋 맵 도 가는ㅇ하다
		
			Map<String, Object> param = new HashMap<>();
			param.put("jobCodeArr", jobCodeArr);
			param.put("deptCodeList", deptCodeList);

			System.out.println("param@controller = " + param);
			
			
			//2. 업무로직
			//jobList조회(job_code, job_name)//이건 출력문이여 반복해서 슈슈.슉.시.시발럼아
			List<Map<String, String>> jobList = empService.selectJobList();
			System.out.println("jobList@controller = " + jobList);
			
			List<Map<String, String>> deptList = empService.selectDeptList();
			System.out.println("deptList@controller = " +  deptList);
			
			
			
			List<Map<String, Object>> list = empService.search3(param);
			System.out.println("list@controller = " + list);

			//3. jsp위임
			request.setAttribute("list", list);
			request.setAttribute("jobList", jobList);
			request.setAttribute("deptList", deptList);
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
		return "emp/search3";
	}
	
	
}
