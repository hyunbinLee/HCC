<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>


<%@ include file="common/inc_header.jsp"%>
<%@ include file="common/inc_bootstrap.jsp" %>
<meta name="viewport" content="width=device-width,initial-scale=1.0">


</head>
<body>
	<div class="wrap">
		<!-- Top Menu -->
		<%@ include file="common/inc_top.jsp"%>
		<!-- 배너 영역 -->
	
	
			<div id="myCarouser" class="carousel slide" data-ride="carousel">
		  		<ol class="carousel-indicators">
					<li data-target="#myCarouser" data-slide-to="0" class="active"></li>
					<li data-target="#myCarouser" data-slide-to="1"></li>
					<li data-target="#myCarouser" data-slide-to="2"></li>
					<li data-target="#myCarouser" data-slide-to="3"></li>		
		  		</ol>
		  		<div class="carousel-inner">
		    		<div class="item active">
		      			<img src="resources/img/banner_05.jpg"  height="" alt="첫번째 슬라이드">
		    		</div>
		    		<div class="item">
		      			<img src="resources/img/banner_06.jpg" width="100%"  alt="두번째 슬라이드">
		    		</div>
				    <div class="item">
				      <img src="resources/img/banner_07.jpg" width="100%"  alt="세번째 슬라이드">
				    </div>
				    <div class="item">
				      <img src="resources/img/banner_08.jpg" width="100%" alt="네번째 슬라이드">
				    </div>
			    </div>
			    <a class="left carousel-control" href="#myCarouser" data-slide="prev">
			    	<span class="glyphicon glyphicon-chevron-left"></span>
			    </a>
			    <a class="right carousel-control" href="#myCarouser" data-slide="next">
			    	<span class="glyphicon glyphicon-chevron-right"></span>
			    </a>
			</div>
				
		<br/><br/>
		<!-- 배너 영역 끝-->
		<div class="left_area">

			<!--회원센터 영역 -->
			<sec:authorize access="isAnonymous()">
				<c:url value="/login" var="loginUrl" />
				<form name="f" action="${loginUrl}" method="post">
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
					<div class="login_area m_b30">
						<div class="login_title m_b10 p_b5">
							<span class="p_b5 txt_bold">회원센터</span>
						</div>
						<div class="login_box m_b5">
							<p>
								<span><img src="resources/img/member_icon.png" alt="유저 아이콘"></span>
								<input type="text" name="id" id="id" class="" value=""
								placeholder="아이디">
							</p>
							<p>
								<span><img src="resources/img/lock_icon.png" alt="자물쇠 아이콘"></span>
								<input type="password" name="pw" id="pw" class="" value=""
								placeholder="비밀번호">
						</div>
						<c:if test="${param.error != null}">
							<script type="text/javascript">
								alert("아이디와 비밀번호가 잘못되었습니다.");
								history.back();
							</script>
						</c:if>
						<div class="other_login">
							<input type="submit" class="btn_power box_full m_t5 m_b7" value="Login">
							<div class="left">
								<input type="checkbox" id="" name="" class="m_r4" value="">
								<span>자동로그인</span>
							</div>
							<br/>
							<a href="#" class="left" id="">아이디 / 비밀번호 찾기 </a>&nbsp;&nbsp;
							<button type="button" onclick="join()" class="">회원가입</button>
							
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
						<div class="user_info m_b5">
							<img class="m_r7" src="resources/img/member_icon.png" alt="유저 아이콘" width="5%" height="5%">
							<p><sec:authentication property="principal.realusername" /><p>
						</div>
						<div class="left">
							<c:url value="/myPage" var="myPage"/>
							<a href="${myPage }" class="" id="">마이 페이지 </a>
						</div>
						<div class="other_login">
							<input type="submit" class="btn_power box_full m_t5 m_b7" value="Logout">
							
							&nbsp;
							<div class="left">
								<sec:authorize access="hasRole('ROLE_ADMIN')">
									<c:url value="./memberManagement" var="memberManagement"/>
									<a href="${memberManagement }">회원 관리</a> &nbsp;&nbsp;
									<c:url value="./blameList" var="blameList"/>
									<a href="${blameList }">나쁜놈들</a>
								</sec:authorize>
							</div>
							
						</div>
					</div>
				</form>
			</sec:authorize>
			<!--회원센터 영역 끝-->

			


			<!--병원 정보 공유 게시판-->
			<c:url value="/hospInfoBoard" var="hospList" />
			<div class="notice_board_wrap">
				<div class="notice_board_title p_b5">
					<span class="p_b5">병원정보 공유</span> 
					<a href="${hospList }" class="right"><img src="resources/img/plus_icon.png" alt="플러스 아이콘" width="10%" height="10%"></a>
				</div>
				<div class="notice_board">
					<c:url var="hcontenturl" value="/hospInfoBoard_detail"/>
					<ul>
						<c:forEach var="list" items="${hib}">
							<li><a href="${hcontenturl}?boardseq=${list.hospital_info_seq}">${list.hospital_info_title}</a> <span class="board_date">${list.hospital_info_reg_date }</span></li>
						</c:forEach>
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
					<span class="p_b5">병에 대한 후기</span> <a href="${fmbList }" class="right"><img src="resources/img/plus_icon.png" alt="플러스 아이콘" width="10%" height="10%"></a>
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
					<a href="${noticeList }" class="right"><img src="resources/img/plus_icon.png" alt="플러스 아이콘" width="10%" height="10%" ></a>
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
		<c:url var="test" value="/loginuserlist"/>
	<a href="${ test}">채팅하기</a>
	<c:forEach items="${userList }" var="userElement">
		${userElement }
	</c:forEach>
		</div>
	

	<!-- 회원가입 부분(레이어 팝업) -->
	<%@ include file="common/inc_join.jsp"%>

	
</body>
</html>
