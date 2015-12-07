<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import="com.hanains.guestbook.dao.GuestBookDAO" %>
<%@page import="com.hanains.guestbook.vo.GuestBookVo" %>


<%
	request.setCharacterEncoding("UTF-8");
	
	//Get parameter
	String noTemp = request.getParameter("no");
	long no = Long.parseLong(noTemp);	
	String password = request.getParameter("password");

	// Define
	GuestBookVo vo = new GuestBookVo();
	GuestBookDAO dao = new GuestBookDAO();
	
	//Setter
	vo.setNo(no);
	vo.setPassword(password);
	
	//delete VO
	dao.delete(vo);
	
	//Redirect
	response.sendRedirect("index.jsp");

%>