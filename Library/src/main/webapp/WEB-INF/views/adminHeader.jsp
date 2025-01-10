<%@page import="com.min.edu.dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
	<%
		MemberDto loginDto = (MemberDto)session.getAttribute("loginDto");
		if(loginDto == null) {
			response.sendRedirect("./");
		}
	%>
	
	<h2>관리자 모드</h2>
	<div>
		<span><%=loginDto.getName()%>님 환영합니다.(등급:<%=loginDto.getAuth()%>)</span>
	</div>
	<div>
		<a href="./loginServlet.do">로그아웃</a>
	</div>
	<div>
		<a href="./userListState.do" >회원상태조회</a>
	</div>
	<div>
		<a href="./userListServlet.do">회원정보조회(사용계정)</a>
	</div>
	
</body>
</html>