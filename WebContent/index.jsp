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
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="index.jsp">강의평가 웹 사이트</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbar">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div id="navbar" class="collapse navbar-collapse">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link"
					href="index.jsp">메인</a></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" role="button"
					id="dropdown" data-toggle="dropdown" aria-haspopup="true"> 회원관리
				</a>
					<div class="dropdown-menu" aria-labelledby="dropdown">
						<a class="dropdown-item" href="#">로그인</a> <a class="dropdown-item"
							href="#">회원가입</a> <a class="dropdown-item" href="#">로그아웃</a>
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

	<section class="container">
		<form method="get" action="./index.jsp" class="form-inline mt-3">
			<select name="lectureDivide" class="form-control mx-1 mt-2">
				<option value="전체">전체</option>
				<option value="전공">전공</option>
				<option value="교양">교양</option>
				<option value="기타">기타</option>
			</select> <input type="text" name="search" class="form-control mx-1 mt-2"
				placeholder="내용을 입력하세요">
			<button type="submit" class="btn btn-primary mx-1 mt-2">검색</button>
			<a class="btn btn-primary mx-1 mt-2" data-toggle="modal"
				href="#registerModal">등록하기</a> <a class="btn btn-danger mx-1 mt-2"
				data-toggle="modal" href="#reportModal">신고</a>
		</form>

		<%-- 임시 데이터 --%>
		<div class="card bg-light mt-3">
			<div class="card-header bg-light">
				<div class="row">
					<div class="col-8 text-left">
						컴퓨터개론&nbsp;<small>김학윤</small>
					</div>
					<div class="col-4 text-right">
						종합 평가&nbsp;<span style="color: red;">매우만족</span>
					</div>
				</div>
			</div>
			<div class="card-body">
				<h5 class="card-title">
					최고의 강의입니다.&nbsp;<small>겨울학기</small>
				</h5>
				<p class="card-text">강의 구성도 좋고, 이해가 잘되는 강의였습니다.</p>
				<div class="row">
					<div class="col-9 text-left">
						받은성적 <span style="color: red;">A</span> &nbsp; 강의수준 <span
							style="color: red;">높음</span>&nbsp; 친절도 <span style="color: red;">친절</span>
						<span style="color: green;">(추천: 20)</span>
					</div>
					<div class="col-3 text-right">
							<a onclick="return confirm('추천하시겠습니까?')"
								href="./likeAction.jsp?evaluationID">추천</a> <a
								onclick="return confirm('삭제하시겠습니까?')"
								href="./deleteAction.jsp?evaluationID">삭제</a>
					</div>
				</div>
			</div>
		</div>
		
		<div class="card bg-light mt-3">
			<div class="card-header bg-light">
				<div class="row">
					<div class="col-8 text-left">
						컴퓨터개론&nbsp;<small>김학윤</small>
					</div>
					<div class="col-4 text-right">
						종합 평가&nbsp;<span style="color: red;">매우만족</span>
					</div>
				</div>
			</div>
			<div class="card-body">
				<h5 class="card-title">
					최고의 강의입니다.&nbsp;<small>겨울학기</small>
				</h5>
				<p class="card-text">강의 구성도 좋고, 이해가 잘되는 강의였습니다.</p>
				<div class="row">
					<div class="col-9 text-left">
						받은성적 <span style="color: red;">A</span> &nbsp; 강의수준 <span
							style="color: red;">높음</span>&nbsp; 친절도 <span style="color: red;">친절</span>
						<span style="color: green;">(추천: 20)</span>
					</div>
					<div class="col-3 text-right">
							<a onclick="return confirm('추천하시겠습니까?')"
								href="./likeAction.jsp?evaluationID">추천</a> <a
								onclick="return confirm('삭제하시겠습니까?')"
								href="./deleteAction.jsp?evaluationID">삭제</a>
					</div>
				</div>
			</div>
		</div>
		
		<div class="card bg-light mt-3">
			<div class="card-header bg-light">
				<div class="row">
					<div class="col-8 text-left">
						컴퓨터개론&nbsp;<small>김학윤</small>
					</div>
					<div class="col-4 text-right">
						종합 평가&nbsp;<span style="color: red;">매우만족</span>
					</div>
				</div>
			</div>
			<div class="card-body">
				<h5 class="card-title">
					최고의 강의입니다.&nbsp;<small>겨울학기</small>
				</h5>
				<p class="card-text">강의 구성도 좋고, 이해가 잘되는 강의였습니다.</p>
				<div class="row">
					<div class="col-9 text-left">
						받은성적 <span style="color: red;">A</span> &nbsp; 강의수준 <span
							style="color: red;">높음</span>&nbsp; 친절도 <span style="color: red;">친절</span>
						<span style="color: green;">(추천: 20)</span>
					</div>
					<div class="col-3 text-right">
							<a onclick="return confirm('추천하시겠습니까?')"
								href="./likeAction.jsp?evaluationID">추천</a> <a
								onclick="return confirm('삭제하시겠습니까?')"
								href="./deleteAction.jsp?evaluationID">삭제</a>
					</div>
				</div>
			</div>
		</div>

	</section>

	<div class="modal fade" id="registerModal" tabindex="-1" role="dialog"
		aria-labelledby="modal" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="modal">평가 등록</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form action="./evaluationRegister.jsp" method="post">
						<div class="form-row">
							<div class="form-group col-sm-6">
								<label>강의명</label> <input type="text" name="lectureName"
									class="form-control" maxlength="20">
							</div>
							<div class="form-group col-sm-6">
								<label>교수명</label> <input type="text" name="professorName"
									class="form-control" maxlength="20">
							</div>
						</div>

						<div class="form-row">
							<div class="form-group col-sm-4">
								<label>수강 연도</label> <select name="lectureYear"
									class="form-control">
									<option value="2011">2011</option>
									<option value="2012">2012</option>
									<option value="2013">2013</option>
									<option value="2014">2014</option>
									<option value="2015">2015</option>
									<option value="2016">2016</option>
									<option value="2017">2017</option>
									<option value="2018" selected>2018</option>
									<option value="2019">2019</option>
								</select>
							</div>
							<div class="form-group col-sm-4">
								<label>수강 학기</label> <select name="semesterDivide"
									class="form-control">
									<option value="1학기" selected>1학기</option>
									<option value="여름학기">여름학기</option>
									<option value="2학기">2학기</option>
									<option value="겨울학기">겨울학기</option>
								</select>
							</div>
							<div class="form-group col-sm-4">
								<label>강의 구분</label> <select name="lectureDivide"
									class="form-control">
									<option value="전공" selected>전공</option>
									<option value="교양">교양</option>
									<option value="기타">기타</option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label>제목</label> <input type="text" name="evaluationTitle"
								class="form-control" maxlength="30">
						</div>
						<div class="form-group">
							<label>내용</label>
							<textarea name="evaluationContent" class="form-control"
								style="height: 180px" maxlength="2048"></textarea>
						</div>
						<div class="form-row">
							<div class="form-group col-sm-3">
								<label>종합 평가</label> <select name="lectuerEvaluation"
									class="form-control">
									<option value="매우만족">매우만족</option>
									<option value="만족">만족</option>
									<option value="보통" selected>보통</option>
									<option value="불만족">불만족</option>
									<option value="매우불만족">매우불만족</option>
								</select>
							</div>
							<div class="form-group col-sm-3">
								<label>받은 성적</label> <select name="lectuerLevel"
									class="form-control">
									<option value="A">A</option>
									<option value="B">B</option>
									<option value="C" selected>C</option>
									<option value="D">D</option>
									<option value="F">F</option>
								</select>
							</div>
							<div class="form-group col-sm-3">
								<label>강의 수준</label> <select name="lectuerLevel"
									class="form-control">
									<option value="높음">높음</option>
									<option value="중간" selected>중간</option>
									<option value="낮음">낮음</option>
								</select>
							</div>
							<div class="form-group col-sm-3">
								<label>친절도 평가</label> <select name="kindness"
									class="form-control">
									<option value="친절">친절</option>
									<option value="보통" selected>보통</option>
									<option value="불친절">불친절</option>
								</select>
							</div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"
								data-dismiss="modal">취소</button>
							<button type="submit" class="btn btn-primary">등록하기</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

	<div class="modal fade" id="reportModal" tabindex="-1" role="dialog"
		aria-labelledby="modal" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="modal">신고 하기</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form action="./report.jsp" method="post">
						<div class="form-group">
							<label>제목</label> <input type="text" name="evaluationTitle"
								class="form-control" maxlength="30">
						</div>
						<div class="form-group">
							<label>내용</label>
							<textarea name="evaluationContent" class="form-control"
								style="height: 180px" maxlength="2048"></textarea>
						</div>

						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"
								data-dismiss="modal">취소</button>
							<button type="submit" class="btn btn-danger">신고하기</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>


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