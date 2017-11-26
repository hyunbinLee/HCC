<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<div class="header_wrap m_b30">
		<c:url value="/main" var="main"></c:url>
		<c:url value="/selfDiagno_detail" var="self"></c:url>
		<c:url value="/hospInfoBoard" var="hosp"></c:url>
		<c:url value="/fmbList" var="fmbList"></c:url>
		<c:url value="/noticeList" var="noticeList"></c:url>
	<div class="logo_area">
		<a href="${main}" class="main_logo"><span> </span></a>
	</div>
	<div class="header_nav">

		<ul>
			<!-- li><a href="${main }" >홈 버튼</a></li>
			<li><button type="button">리스트</button></li -->
			<li><a href="${self }" class="">자가진단</a></li>
			<li><a href="${hosp }" class="">병원정보공유</a></li>
			<li><a href="${fmbList }" class="">병에대한후기</a></li>
			<li><a href="${noticeList }" class="">공지사항</a></li>
		</ul>
	</div>
</div>

<div class="content_wrap">
	<c:url value="/myPage" var="myPage"/>
	<div class="fixed_nav">
		<button type="button" class="" id="" title="접혀있는 정보 열고 닫는 아이콘"></button>
		<a href="${myPage }" class="" title="마이페이지 이동 아이콘"></a>
	</div>
