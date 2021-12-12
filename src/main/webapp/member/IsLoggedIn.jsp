<%@page import="utils.JSFunction"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
if(session.getAttribute("UserId") == null){
	JSFunction.alertLocation("아이디 혹은 비밀번호가 일치하지 않습니다.", "../member/Login.jsp", out);
	
	return;
}
%>