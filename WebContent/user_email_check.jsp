<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>강의평가 웹 사이트</title>
<!-- 부트스트랩 CSS 추가하기 -->
<link rel="stylesheet" href="./css/bootstrap.min.css">
<!-- 커스텀 CSS 추가하기 -->
<link rel="stylesheet" href="./css/custom.css">

</head>
<body>
	<%
	String userID = null;
	if (session.getAttribute("userID") != null) {
		userID = (String) session.getAttribute("userID");
	} else {
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('로그인을 먼저 해주세요.');");
		script.println("location.href = 'user_login.jsp';");
		script.println("</script>");
		script.close();
		return;
	}
%>

	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="index.jsp">강의평가 웹 사이트</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbar">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div id="navbar" class="collapse navbar-collapse">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item"><a class="nav-link"
					href="index.jsp">메인</a></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" role="button"
					id="dropdown" data-toggle="dropdown" aria-haspopup="true"> 회원관리
				</a>
					<div class="dropdown-menu" aria-labelledby="dropdown">
						<%
							if (userID == null) {
						%>
						<a class="dropdown-item" href="user_login.jsp">로그인</a> <a
							class="dropdown-item active" href="user_join.jsp">회원가입</a>
						<%
							} else {
						%>
						<a class="dropdown-item" href="userLogoutAction">로그아웃</a>
						<%
							}
						%>
					</div></li>
			</ul>
			<form class="form-inline my-2 my-lg-0">
				<input class="form-control mr-sm-2" type="search"
					placeholder="내용을 입력하세요"> <input
					class="btn btn-outline-success my-2 my-sm-0" type="submit"
					value="검색">
			</form>
		</div>
	</nav>

	<section class="container mt-3" style="max-width: 560px;">
		<div class="alert alert-success mt-4" role="alert">
			이메일 주소 인증 메일이 전송되었습니다. 회원가입시 입력했던 이메일에 들어가셔서 인증해주세요.
		</div>
	</section>

	
	<footer class="bg-light mt-4 p-4 text-center">
		Copyright &copy; 2018 kim-hak-yoon All Rights Reserved.
	</footer>
	<!-- 제이쿼리 자바스크립트 추가하기 -->
	<script src="./js/jquery.min.js"></script>
	<!-- 파퍼 자바스크립트 추가하기 -->
	<script src="./js/popper.js"></script>
	<!-- 부트스트랩 자바스크립트 추가하기 -->
	<script src="./js/bootstrap.min.js"></script>
</body>
</html>