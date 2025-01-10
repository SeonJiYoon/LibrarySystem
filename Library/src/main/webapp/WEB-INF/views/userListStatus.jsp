<%@page import="com.min.edu.dto.MemberDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원상태 전체 보기 화면</title>
</head>
<%
	List<MemberDto> lists = (List<MemberDto>)request.getAttribute("lists");
%>

<%@ include file="adminHeader.jsp" %>

<body>
	<h3>회원상태 전체 조회</h3>
	<table>
		<thead>
			<tr>
				<th>회원번호</th>
				<th>이름</th>
				<th>아이디</th>
				<th>전화번호</th>
				<th>사용여부</th>
				<th>권한</th>
			</tr>
		</thead>
		<tbody>
			<%
				for(MemberDto dto : lists) {
					%>
					<tr>
						<td><%=dto.getMember_id()%></td>
						<td><%=dto.getName()%></td>
						<td><%=dto.getId()%></td>
						<td><%=dto.getTel()%></td>
						<td><%=dto.getIs_enabled().equalsIgnoreCase("y")?"사용중":"탈퇴"%></td>
						<td><%=dto.getAuth().equalsIgnoreCase("ADMIN")?"관리자":"사용자"%></td>
					</tr>
					<%
				}
			%>
		</tbody>
		<tfoot>
			<tr>
				<th colspan="6">
					<button onclick="history.back(-1)">이전화면이동</button>
				</th>
			</tr>
		</tfoot>
	</table>
</body>
</html>