<%@page import="com.min.edu.dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 후 페이지</title>
</head>
<%
	MemberDto loginDto = (MemberDto)session.getAttribute("loginDto");
%>
<body>
	<h2><%=loginDto.getAuth().equalsIgnoreCase("ADMIN")?"관리자":"사용자"%> 모드</h2>
	<div>
		<span><%=loginDto.getName()%>님 환영합니다. (등급:<%=loginDto.getAuth()%>)</span>
	</div>
	<div>
		<a href="./loginServlet.do">로그아웃</a>
	</div>
	<%
		if(loginDto.getAuth().equalsIgnoreCase("USER")) {
			%>
				<div>
					<a href="./userInfo.do">마이페이지</a>
				</div>
			<%
		}
	
		if(loginDto.getAuth().equalsIgnoreCase("ADMIN")) {
			%>
				<div>
					<a href="./userListState.do">회원상태전체조회</a>
				</div>		
				<div>
					<a href="./userListServlet.do">전체사용자조회</a>
				</div>		
			<%
		}
	%>
</body>
</html>