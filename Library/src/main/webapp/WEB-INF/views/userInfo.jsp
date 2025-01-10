<%@page import="com.min.edu.dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 상세정보</title>
</head>
<%
	MemberDto dto = (MemberDto)request.getAttribute("userInfo");
%>
<body>
	<table>
		<thead>
			<tr>
				<th>이름</th>
				<th>아이디</th>
				<th>전화번호</th>
				<th>권한</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td><%=dto.getName()%></td>
				<td><%=dto.getId()%></td>
				<td><%=dto.getTel()%></td>
				<td><%=dto.getAuth().equalsIgnoreCase("ADMIN")?"관리자":"사용자"%></td>
			</tr>
		</tbody>
		<tfoot>
			<tr>
				<th colspan="8" style="text-align: center;">
					<input type="button" value="수정">
					<input type="button" value="탈퇴" onclick="deleteUser()">
				</th>
			</tr>
		</tfoot>
	</table>
</body>
<script type="text/javascript">
	document.querySelector("input[type=button]").onclick=function() {
		console.log("수정화면 이동");
		location.href="./userModifyServlet.do";
	}
	
	function deleteUser() {
		location.href="./delUserServlet.do";
	}
</script>
</html>