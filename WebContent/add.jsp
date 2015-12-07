<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.hanains.guestbook.dao.GuestBookDAO"%>
<%@page import="com.hanains.guestbook.vo.GuestBookVo"%>
<%
 
 	request.setCharacterEncoding("UTF-8");
 
	//Get Parameter
 	String name = request.getParameter("name");
 	String password =request.getParameter("pass");
 	String content = request.getParameter("content");
 
 	GuestBookVo vo = new GuestBookVo(name, password, content);
 	GuestBookDAO dao = new GuestBookDAO();
 	
 	//insert VO
 	dao.insert(vo);
 	
 	//Redirect
 	response.sendRedirect("index.jsp");
 	
 	
 
 %>