<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>



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
					<c:url value="/leavecheck" var="leavecheck"/>
					<c:url value="/infoupdatecheck" var="infoupdatecheck"/>
						<p>
							<a href="#" class="" id="">마이 페이지 </a><br/>
							<a href="${infoupdatecheck }" class="" id="">회원 정보 수정 </a><br/>
							<a href="${leavecheck }" class="" id="">회원 탈퇴</a>

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
					<p>내가 좋아한 게시물</p>
				</div>
				<c:url var="myLikeNoticeList" value="/myLikeNoticeList">></c:url>
				<div><a href="${myLikeNoticeList }">더보기</a></div>
				<div class="mylist_top">
				<c:url var="ncontenturl" value="/noticeContentPage"/>
					<table>
						<tbody>
							<c:forEach var="list" items="${List_L }" varStatus="status">
							<c:if test="${status.index < 5 }" >
							<tr>
							<td class="number"><b>${list.notice_seq }</b></td>
							<td><b><a href="${ncontenturl }?seq=${list.notice_seq}">${list.notice_title }</a> </b></td>
							<td class="rank_num"><b>${list.notice_cnt }</b></td>
							</tr>
							</c:if>
							</c:forEach>
							
						</tbody>
					</table>
				</div>
			</div>

			<div class="mylist2">
				<div class="mylist_nav">
					<p>내가 게시한 게시물</p> 
				</div>
				<c:url var="myNoticeList" value="/myNoticeList">></c:url>
				<div><a href="${myNoticeList }">더보기</a></div>
				<div class="mylist_top">
				<c:url var="ncontenturl" value="/noticeContentPage"/>
				
					<table>
						<tbody>
							
							<c:forEach var="list" items="${List }" varStatus="status">
							<c:if test="${status.index < 5 }" >
							<tr>
							<td class="number"><b>${list.notice_seq }</b></td>
							<td><b><a href="${ncontenturl }?seq=${list.notice_seq}">${list.notice_title }</a> </b></td>
							<td class="rank_num"><b>${list.notice_cnt }</b></td>
							</tr>
							</c:if>
							</c:forEach>
							
							
							
							
						
						</tbody>
					</table>
				</div>
			</div>

		</div>

	</div>
	
</body>
</html>