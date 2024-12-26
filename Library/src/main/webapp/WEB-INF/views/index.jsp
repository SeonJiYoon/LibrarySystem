<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
<style type="text/css">
	td{
		border: 3px solid black;
		padding: 10px;
	}
	 
	table {
		border: 4px solid gray;
		border-collapse: collapse;
		width: 350px;
		margin: 300px auto;
	}
	
</style>
<script type="text/javascript">
	function regist() {
		location.href="./registServlet.do";
	}
</script>
</head>
<body>
	<form action="./loginServlet.do" method="post">
		<table>
			<tr>
				<th>아이디</th>
				<td>
					<input type="text" name="id">
				</td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td>
					<input type="password" name="password">
				</td>
			</tr>
			<tr>
				<th colspan="2">
					<input type="submit" value="로그인">
					<input type="button" value="회원가입" onclick="regist()">
				</th>
			</tr>
		</table>
	</form>
</body>
</html>