<%@page import="com.min.edu.dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>정보 수정 화면</title>
<style type="text/css">
	.required-field:required{
		border: 2px solid red;
		outline: none;
	}
	.required-field:required:focus{
		border-color: black;
		box-shadow: 0 0 5px black;
	}
</style>
</head>
<%
	MemberDto dto = (MemberDto)request.getAttribute("userInfo");
%>
<body>
	<form action="./userModifyServlet.do" method="post">
		<table>
			<thead>
				<tr>
					<th>아이디</th>
					<th>비밀번호</th>
					<th>전화번호</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><%=dto.getId()%></td>
					<td><input class="required-field" required type="text" name="password" placeholder="<%=dto.getPassword()%>"></td>
					<td><input class="required-field" required type="text" name="tel" placeholder="<%=dto.getTel()%>"></td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<th colspan="4">
						<input type="submit" value="수정">
						<input type="reset" value="초기화">
						<input type="button" value="뒤로가기" onclick="history.back(-1)">
					</th>
				</tr>
			</tfoot>
		</table>
	</form>
</body>
</html>