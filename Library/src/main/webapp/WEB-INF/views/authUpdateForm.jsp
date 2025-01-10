<%@page import="com.min.edu.dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>권한수정화면</title>
</head>
<%
	MemberDto dto = (MemberDto)request.getAttribute("dto");
%>
<body>
	<form action="./authUpdate.do" method="post">
		<input type="hidden" name="member_id" value="<%=dto.getMember_id()%>">
		<table>
			<tr>
				<th>아이디</th>
				<td>
					<%=dto.getId()%>
				</td>
			</tr>
			<tr>
				<th>이름</th>
				<td>
					<%=dto.getName()%>
				</td>
			</tr>
			<tr>
				<th>권한</th>
				<td>
					<select name="role">
						<option value="ADMIN" <%=dto.getAuth().equalsIgnoreCase("ADMIN")?"selected":"" %>>관리자</option>
						<option value="USER" <%=dto.getAuth().equalsIgnoreCase("USER")?"selected":"" %>>사용자</option>
					</select>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="권한변경">
					<input type="reset" value="초기화">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>