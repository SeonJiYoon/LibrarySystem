<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
<link rel="stylesheet" href="./css/login.css">
<script type="text/javascript">
	function regist() {
		location.href="./registServlet.do";
	}
</script>
</head>
<body>
	<div class="container">
		<!-- 상단 메뉴 -->
		<div class="top-menu">
			<span>나의공간</span>|<span>로그인</span>
		</div>
		
		<!-- 매인 로그인 폼 -->
		<div class="login-box">
			<img alt="도서관 로고" src="./img/library_logo.jpg" class="logo">
			<h2>지예유 도서관</h2>
			<form action="./loginServlet.do" method="post">
				<input type="text" placeholder="도서관 아이디" required>
				<input type="password" placeholder="비밀번호(8~15자리)" required>
				<button type="submit" class="login-btn">로그인</button>
			</form>
			<div class="social-login">
				<button class="naver-btn">네이버 로그인</button>
				<button class="kakao-btn">카카오 로그인</button>
			</div>
			<div class="links">
				<a href="#">아이디찾기</a>|
				<a href="#">비밀번호 재설정</a>|
				<button onclick="regist()">회원가입</button>
			</div>
		</div>
		
		<!-- 하단 이미지 -->
		<div class="footer">
			<img alt="도서관 이미지" src="./img/library.jpg" class="footer-img">
			<p>지예유 도서관|(08505) 서울특별시 금천구 가산디지털2로 95(가산동)|전화번호:02)123-1234<br>
			이용시간:월-금 9:00-21:00 / 토,일 9:00-17:00(공휴일휴관)</p>
		</div>
	</div>
</body>
</html>