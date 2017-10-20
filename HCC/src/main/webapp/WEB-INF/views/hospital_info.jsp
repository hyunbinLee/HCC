<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>


<%@ include file="common/inc_header.jsp"%>
<script>
	$(document).ready(function() {
		var bak_height = $('html').height();
		$('.bak_bl').css('height', bak_height);
	});

	function lay_pop_close() {
		$('.login_wrap').hide();
		$('.bak_bl').hide();
	}

	function join() {
		$('.login_wrap').show();
		$('.bak_bl').show();
	}
</script>

</head>


<body>
	<div class="wrap">
		<!-- Top Menu -->
		<%@ include file="common/inc_top_post.jsp"%>
		
		<div id="contents">
			<div id="search">
				<div class="search_nav">
					<p>검색</p>
				</div>
				<div class="search_box">
					<div>
						<input type="checkbox" value="제목"> 제목 <input
							type="checkbox" value="작성자"> 작성자
					</div>
					<select name="select" id="select">
						<option value="흉부외과">흉부외과</option>
						<option value="흉부외과">정형외과</option>
						<option value="흉부외과">이빈인후과</option>
						<option value="흉부외과">내과</option>
					</select> <input type="text" placeholder="검색어 입력" class="search"> <input
						type="button" id="search_btn" value="검색">
				</div>

				<div id="list_box">
					<div id="adult">성인</div>
					<div id="teenager">소아/청소년</div>
				</div>
				<table>
					<thead>
						<tr>
							<td class="num"><b>번호</b></td>
							<td class="title"><b>제목</b></td>
							<td class="grade"><b>평점</b></td>
							<td class="name"><b>이름</b></td>
							<td class="day"><b>날짜</b></td>
							<td class="re"><b>추천수</b></td>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td class="num"><b>5</b></td>
							<td class="title"><b>고려대학병원 추천합니다.</b></td>
							<td class="grade"><b>평점</b></td>
							<td class="name"><b>유인준</b></td>
							<td class="day"><b>2017-10-06</b></td>
							<td class="re"><b>10</b></td>
						</tr>
						<tr>
							<td class="num"><b>4</b></td>
							<td class="title"><b>고려대학병원 추천합니다.</b></td>
							<td class="grade"><b>평점</b></td>
							<td class="name"><b>이름</b></td>
							<td class="day"><b>날짜</b></td>
							<td class="re"><b>추천수</b></td>
						</tr>
						<tr>
							<td class="num"><b>3</b></td>
							<td class="title"><b>고려대학병원 추천합니다.</b></td>
							<td class="grade"><b>평점</b></td>
							<td class="name"><b>이름</b></td>
							<td class="day"><b>날짜</b></td>
							<td class="re"><b>추천수</b></td>
						</tr>
						<tr>
							<td class="num"><b>2</b></td>
							<td class="title"><b>고려대학병원 추천합니다.</b></td>
							<td class="grade"><b>평점</b></td>
							<td class="name"><b>이름</b></td>
							<td class="day"><b>날짜</b></td>
							<td class="re"><b>추천수</b></td>
						</tr>
						<tr>
							<td class="num"><b>1</b></td>
							<td class="title"><b>고려대학병원 추천합니다.</b></td>
							<td class="grade"><b>평점</b></td>
							<td class="name"><b>이름</b></td>
							<td class="day"><b>날짜</b></td>
							<td class="re"><b>추천수</b></td>
						</tr>
					</tbody>
				</table>

			</div>

			<div id="name">
				<div class="search_nav">
					<p>회원센터</p>
				</div>
				<div id="name_box">
					<c:url value="/logout" var="logoutUrl" />
					<form name="f" action="${logoutUrl}" method="post">
						<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />
						<div id="top">
							<div></div>
							<div>
								<sec:authentication property="principal.realusername" />
								님 환영합니다!
							</div>
						</div>
						<div class="bottom">
							<p>
								<a href="#" class="" id="">마이 페이지 </a>
							</p>
							<p>
								<input type="submit" class="right" value="Logout">
							</p>
						</div>
					</form>
				</div>


				<div id="rank_box">
					<div class="search_nav">
						<p>TOP 5</p>
					</div>
					<div id="rank_top">
						<table>
							<tbody>
								<tr>
									<td class="number"><b>1</b></td>
									<td><b>고려대학병원 추천합...</b></td>
									<td class="rank_num"><b>51321</b></td>
								</tr>
								<tr>
									<td class="number"><b>2</b></td>
									<td><b>고려대학병원 추천합...</b></td>
									<td class="rank_num"><b>1321</b></td>
								</tr>
								<tr>
									<td class="number"><b>3</b></td>
									<td><b>고려대학병원 추천합...</b></td>
									<td class="rank_num"><b>321</b></td>
								</tr>
								<tr>
									<td class="number"><b>4</b></td>
									<td><b>고려대학병원 추천합...</b></td>
									<td class="rank_num"><b>21</b></td>
								</tr>
								<tr>
									<td class="number"><b>5</b></td>
									<td><b>고려대학병원 추천합...</b></td>
									<td class="rank_num"><b>1</b></td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>

			</div>


		</div>
	</div>
</body>
</html>