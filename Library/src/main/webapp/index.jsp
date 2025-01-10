<%@page import="com.min.edu.dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/mainpage.css">

<script type="text/javascript">
	function regist() {
		location.href="./registServlet.do";
	}
</script>

</head>
<%
	MemberDto loginDto = (MemberDto)session.getAttribute("loginDto");
%>
<body>
	<div class="container">
	<!-- 상단 로고 및 메뉴 -->
	<fieldset>
	<div class = "top-menu">	
			<button>도서관안내</button>
			<button>도서정보</button>
			<button>열린공간</button>
			<button>나의도서관</button>
			<button><a href="./mainlogin.do">로그인</a></button>
			<button onclick="regist()">회원가입</button>
	</div>
		<div class="logo">
			<img alt="도서관 로고" src="./img/library.jpg" class="library-image">
	</div>	
	</fieldset>	
</div>
		<!-- 메인 콘텐츠 -->
		<div class="main-content">
		<!-- 왼쪽 검색 섹션 -->
		<div class="search-section">
			<h2>자료검색</h2>
			<input type="text" placeholder="검색어를 입력해주세요">
		</div>
	<div class="search-section">
		<fieldset>
		<!-- 오른쪽 버튼 섹션 -->
		<div class="button-section">
			<button>대출현황조회</button>
			<button>예약하기</button>
			<button>도서신청</button>
			<button>내정보</button>
			<button>공지사항</button>
			<button>찾아오시는 길</button>
		</div>
	</fieldset>
	</div>
	</div>
</body>
</html>