<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

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
					<c:url value="/myPage" var="myPage"/>
				
				<div class="bottom">
					<p>
						<a href="${myPage }" class="" id="">마이 페이지 </a>
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
