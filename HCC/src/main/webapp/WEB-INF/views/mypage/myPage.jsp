<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>


<%@ include file="../common/inc_common.jsp"%>

<%@ include file="../common/inc_header.jsp"%>

</head>
<body>
	<div class="wrap">

		<!-- Top Menu -->
		<%@ include file="../common/inc_top.jsp"%>

		<div class="myinfo">
			<div class="myinfo_nav">
				<p>MyPage</p>
			</div>
			<div class="myinfo_box">
				<c:url value="/logout" var="logoutUrl" />
				<form name="f" action="${logoutUrl}" method="post">
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
					<div id="myinfo_top">
						<div></div>
						<div>
							<sec:authentication property="principal.realusername" />
							님 환영합니다!
						</div>
					</div>
					<div class="myinfo_bottom">
						<p>
							<a href="#" class="" id="">마이 페이지 </a><br/>
							<a href="#" class="" id="">회원 정보 수정 </a><br/>
							<a href="#" class="" id="">회원 탈퇴</a>

						</p>

						<p>
							<input type="submit" class="right" value="Logout">
						</p>
					</div>
				</form>
			</div>

		</div>


		<div class="mycontent">

			<div class="mylist1">
				<div class="mylist_nav">
					<p>내가 좋아요한 게시물</p>
				</div>
				<div class="mylist_top">
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

			<div class="mylist2">
				<div class="mylist_nav">
					<p>내가 ~한 게시물</p>
				</div>
				<div class="mylist_top">
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