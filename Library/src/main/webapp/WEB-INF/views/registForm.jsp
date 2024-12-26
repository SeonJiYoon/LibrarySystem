<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 입력화면</title>
<script type="text/javascript" src="./js/login.js"></script>
</head>
<body>
	<form action="./registServlet.do" method="post">
		<table>
			<tbody>
				<tr>
					<th>아이디</th>
					<td>
						<input type="text" name="id" title="n">
						<input type="button" value="중복체크" onclick="idCheck()">
					</td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td>
						<input type="password" name="password">
					</td>
				</tr>
				<tr>
					<th>이름</th>
					<td>
						<input type="text" name="name">
					</td>
				</tr>
				<tr>
					<th>전화번호</th>
					<td>
						<input type="text" name="tel">
					</td>
				</tr>
				<tr>
					<th colspan="2">
						<input type="submit" value="회원가입">
					</th>
				</tr>
			</tbody>
		</table>
	</form>
</body>
</html>