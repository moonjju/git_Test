package com.kh.mybatis.student.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.kh.mybatis.common.AbstractController;
import com.kh.mybatis.student.model.service.StudentService;
import com.kh.mybatis.student.model.service.StudentServiceImpl;

public class selectOneStudentMapController extends AbstractController {

	private StudentService studentService = new StudentServiceImpl();

	@Override
	public String doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//응답 메세지에 json문자열을 직접 출력
		
		//1. 사용자 입력값
		int no = Integer.parseInt(request.getParameter("no"));
		
		//2. 업무로직
		Map<String, Object> student = studentService.selectOneStudentMap(no);
		System.out.println("student@controller = " + student);
		
		//3. json문자열을 응답 메세지에 출력
		response.setContentType("application/json; charset=utf-8");
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
		gson.toJson(student, response.getWriter());
		return null;
	}
	
	
}
