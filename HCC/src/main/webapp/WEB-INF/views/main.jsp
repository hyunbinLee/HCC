<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>


<%@ include file="common/inc_header.jsp"%>


</head>
<body>
	<div class="wrap">

		<!-- Top Menu -->
		<%@ include file="common/inc_top.jsp"%>

		<div class="left_area">

			<!--회원센터 영역 -->
			<sec:authorize access="isAnonymous()">
				<c:url value="/login" var="loginUrl" />
				<form name="f" action="${loginUrl}" method="post">
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
					<div class="login_area m_b30">
						<div class="login_title m_b10 p_b5">
							<span class="p_b5">회원센터</span>
						</div>
						<div class="login_box m_b5">
							<div></div>
							<input type="text" name="id" id="id" class="" value=""
								placeholder="아이디">
							<div></div>
							<input type="password" name="pw" id="pw" class="" value=""
								placeholder="비밀번호">
						</div>
						<c:if test="${param.error != null}">
							<p>아이디와 비밀번호가 잘못되었습니다.</p>
						</c:if>
						<div class="other_login">
							<div class="left">
								<input type="checkbox" id="" name="" class="m_r4" value="">
								<span>자동로그인</span>
							</div>
							<a href="#" class="" id="">아이디 / 비밀번호 찾기 </a>&nbsp;&nbsp;
							<button type="button" onclick="join()" class="">회원가입</button>
							<input type="submit" class="right" value="Login">
						</div>
					</div>
				</form>
			</sec:authorize>

			<sec:authorize access="isAuthenticated()">
				<c:url value="/logout" var="logoutUrl" />
				<form name="f" action="${logoutUrl}" method="post">
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
					<div class="login_area m_b80">
						<div class="login_title m_b10 p_b5">
							<span class="p_b5">회원센터</span>
						</div>
						<sec:authentication property="principal.realusername" />
						님 환영합니다!
						<div class="other_login">
							<div class="left">
								<c:url value="/myPage" var="myPage"/>
								<a href="${myPage }" class="" id="">마이 페이지 </a>
							</div>
							&nbsp;
							<div class="left">
								<sec:authorize access="hasRole('ROLE_ADMIN')">
									<c:url value="./memberManagement" var="memberManagement"/>
									<a href="${memberManagement }">회원 관리</a> &nbsp;&nbsp;
									<c:url value="./blameList" var="blameList"/>
									<a href="${blameList }">나쁜놈들</a>
								</sec:authorize>
							</div>
							<input type="submit" class="right" value="Logout">
						</div>
					</div>
				</form>
			</sec:authorize>
			<!--회원센터 영역 끝-->

			<!-- 배너 영역 -->
			<div class="banner_area m_b70">
				<ul>
					<li><img src="resources/img/logo.png" alt="배너1 이미지"></li>
					<li><img src="" alt="배너2 이미지"></li>
					<li><img src="" alt="배너3 이미지"></li>
					<li><img src="" alt="배너4 이미지"></li>
				</ul>
			</div>
			<!-- 배너 영역 끝-->


			<!--병원 정보 공유 게시판-->
			<div class="notice_board_wrap">
			<c:url value="/hospInfoBoard" var="hospList" />
				<div class="notice_board_title p_b5">
					<span class="p_b5">병원정보 공유</span> <a href="${hospList }?page=1" class="right"><span>+ 더보기</span></a>
				</div>
				<div class="notice_board">
					<ul>
						<li>test</li>
						<li>test</li>
						<li class="on">test</li>
						<li>test</li>
						<li>test</li>
					</ul>
				</div>
			</div>
			<!--병원 정보 공유 게시판 끝-->
		</div>

		<div class="right_area">
			<!--병에 대한 후기 게시판-->
			<c:url value="/fmbList" var="fmbList" />
			<div class="notice_board_wrap m_b80">
				<div class="notice_board_title p_b5">
					<span class="p_b5">병에 대한 후기</span> <a href="${fmbList }" class="right"><span>+더보기</span></a>
				</div>
				<div class="notice_board_tap">
					<ul>
						<li>극복하는 중</li>
						<li>극복한 사람들</li>
					</ul>
				</div>
				<div class="notice_board">
				<c:url var="fcontenturl" value="/fmbContentPage"/>
					<ul>
						<c:forEach var="list" items="${fmb }">
							<li><a href="${fcontenturl }?seq=${list.fmb_seq}">${list.fmb_title }</a> <span class="board_date">${list.fmb_reg_date }</span></li>
						</c:forEach>
						
					</ul>
				</div>
			</div>
			<!--병에 대한 후기 게시판 끝-->

			<!--게시판-->
			<c:url value="/noticeList" var="noticeList" />
			<div class="notice_board_wrap">
				<div class="notice_board_title p_b5">
					<span class="p_b5">게시판</span> 
					<a href="${noticeList }" class="right"><span>+더보기</span></a>
				</div>
				<div class="notice_board_tap">
					<ul>
						<li>의사</li>
						<li>일반</li>
					</ul>
				</div>
				<div class="notice_board">
				<c:url var="ncontenturl" value="/noticeContentPage"/>
					<ul>
						<c:forEach var="list" items="${notice }">
							<li><a href="${ncontenturl }?seq=${list.notice_seq}&code=1">${list.notice_title }</a> <span class="board_date">${list.notice_reg_date }</span></li>
						</c:forEach>
					</ul>
				</div>
			</div>
			<!--게시판 끝-->
		</div>
		<c:url var="test" value="/chatting"/>
	<a href="${ test}">채팅하기</a>
	<c:forEach items="${userList }" var="userElement">
		${userElement }
	</c:forEach>
		</div>
	

	<!-- 회원가입 부분(레이어 팝업) -->
	<%@ include file="common/inc_join.jsp"%>

	</div>
</body>
</html>
