package com.kh.mybatis.student.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.kh.mybatis.common.AbstractController;
import com.kh.mybatis.student.model.service.StudentService;
import com.kh.mybatis.student.model.service.StudentServiceImpl;
import com.kh.mybatis.student.model.vo.Student;

public class SelectStudentListController extends AbstractController {
		
		private StudentService studentService = new StudentServiceImpl();

		@Override
		public String doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			try {
				//1. 업무로직
				List<Student> list = studentService.selectStudentList();
				System.out.println("list@controller = "+list);
				
				List<Map<String, Object>> mapList = studentService.selectStudentMapList();
				System.out.println("maplist@controller = "+mapList);
				
				request.setAttribute("list", list);
				request.setAttribute("mapList", mapList);
	
				
			}catch(Exception e) {
				e.printStackTrace();
				throw e;
			}
			return "student/selectList";
		}
		
		
}
