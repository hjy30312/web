/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.servlet.course;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.model.Course;
import com.web.util.DaoFactory;

/**
 *
 * @author Administrator
 */
@WebServlet(name = "GetCourse", urlPatterns = { "/GetCourse" })
public class GetCourse extends HttpServlet {

	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		Course course1 = new Course();
		Course course2 = new Course();
		String cno = request.getParameter("cno");
		String cname = request.getParameter("cname");
		course1 = DaoFactory.getCourseDao().cnoGetCourse(cno);
		course2 = DaoFactory.getCourseDao().cnameGetCourse(cname);
		System.out.println(course1 + " " +course2);
		if (course1 != null) {
			/**
			 * 因为在displayCourse.jsp中的items="${courses}" 是List类型
			 * 所以得到的course需要转换类型
			 */
			List<Course> courses = new ArrayList<Course>();
			courses.add(course1);
			request.setAttribute("courses", courses);
		} else if(course2 != null){
			List<Course> courses = new ArrayList<Course>();
			courses.add(course2);
			request.setAttribute("courses", courses);
		}
		// 第一种方式:转发 携带数据 地址栏不发生变化
		request.getRequestDispatcher("displayCourse.jsp").forward(request, response);
	}

	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * Handles the HTTP <code>POST</code> method.
	 *
	 * @param request
	 *            servlet request
	 * @param response
	 *            servlet response
	 * @throws ServletException
	 *             if a servlet-specific error occurs
	 * @throws IOException
	 *             if an I/O error occurs
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * Returns a short description of the servlet.
	 *
	 * @return a String containing servlet description
	 */
	@Override
	public String getServletInfo() {
		return "Short description";
	}// </editor-fold>

}
