<%@page import="com.min.edu.dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
	MemberDto loginDto = (MemberDto)session.getAttribute("loginDto");
%>
<body>
	로그인 정보 <%=loginDto%>
</body>
</html>