<%@page import="com.min.edu.dto.MemberDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용가능한 사용자 조회</title>
</head>
<%
	List<MemberDto> lists = (List<MemberDto>)request.getAttribute("lists");
%>

<%@ include file="adminHeader.jsp" %>

<body>
<hr>
<h3>회원 전체 조회(사용가능)</h3>
	<table>
		<thead>
			<tr>
				<th>회원번호</th>
				<th>이름</th>
				<th>아이디</th>
				<th>권한</th>
				<th>권한변경</th>
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
						<td><%=dto.getAuth().equalsIgnoreCase("ADMIN")?"관리자":"사용자"%></td>
						<td>
							<button>변경</button>
						</td>
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
<script type="text/javascript">
	var btns = document.querySelectorAll("button");
	for(let i=0; i<btns.length; i++) {
		btns[i].onclick=function() {
			var member_id = this.parentNode.parentNode.children[0].textContent;
// 			console.log("선택된 row의 member_id값 ", member_id);
			location.href="./authUpdate.do?member_id=" + member_id;
		}
	}
</script>
</html>