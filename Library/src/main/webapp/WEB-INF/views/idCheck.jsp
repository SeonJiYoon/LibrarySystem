<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 중복 확인 자식창</title>

<script type="text/javascript">
	window.onload = function() {
		var id = opener.document.getElementsByName("id")[0];
		document.getElementById("inputId").textContent = id.value;
	}
	
	function confirm() {
		var id = opener.document.getElementsByName("id")[0];
		id.title='y';
		self.close();
	}
	
	function cancel() {
		var id = opener.document.getElementsByName("id")[0];
		id.title='n';
		id.value = '';
		id.focus();
		self.close();
	}
</script>

</head>
<%
	boolean isc = (boolean)request.getAttribute("isc");
%>
<body>
	<table>
		<tr>
			<td id="inputId"></td>
		</tr>
		<tr>
			<td>
				<%=isc?"사용할 수 있습니다.":"사용할 수 없습니다." %>
			</td>
		</tr>
		<tr>
			<%
				if(isc) {
					%>
						<td>
							<input type="button" value="사용하기" onclick="confirm()">
						</td>
					<%
				} else {
					%>
						<td>
							<input type="button" value="창닫기" onclick="cancel()">
						</td>
					<%
				}
			%>
		</tr>
	</table>

</body>
</html>