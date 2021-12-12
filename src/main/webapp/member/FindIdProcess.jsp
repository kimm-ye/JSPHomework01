<%@page import="membership.MemberDTO"%>
<%@page import="membership.MemberDAO"%>
<%@page import="utils.JSFunction"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String name = request.getParameter("findName"); //Find 시트에 이름의 name
String oracleDriver = application.getInitParameter("OracleDriver");
String oracleURL= application.getInitParameter("OracleURL");
String oracleId = application.getInitParameter("OracleId");
String oraclePwd = application.getInitParameter("OraclePwd");

MemberDAO dao = new MemberDAO(oracleDriver, oracleURL, oracleId, oraclePwd);
String searchId = dao.searchIdDTO(name);

dao.close();

if(searchId != null){	
	JSFunction.alertLocation("아이디는 [" + searchId + "] 입니다.", "Login.jsp", out);
} 
else{
	JSFunction.alertBack("일치하는 아이디가 없습니다.", out);
}
%>

