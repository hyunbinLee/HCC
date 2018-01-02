<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>


<%@ include file="../common/inc_common.jsp"%>
<%@ include file="../common/inc_header.jsp"%>
  
</head>

<body>
	<div class="wrap">
	
	    <!-- Top Menu -->
		<%@ include file="../common/inc_top.jsp"%>
		</div>
			<div id="contents">
			<div id="search">
				<div class="search_nav">
					<p>게시판</p>
				</div>
				<div class="search_box">
					<div>
						<input type="checkbox" value="제목"> 제목 
						<input type="checkbox" value="작성자"> 작성자
					</div>
					<input type="text" placeholder="검색어 입력" class="search_noti"> 
					<input type="button" id="search_btn" value="검색">
				</div>

				<div id="list_box">
					<div class="write"><a href="./noticeWritePage">글쓰기</a></div>
				</div>
				<table>
					<thead>
						<tr>
							<td class="num"><b>번호</b></td>
							<td class="title"><b>제목</b></td>
							<!-- td class="grade"><b>평점</b></td>
                          <td class="name"><b>이름</b></td -->
							<td class="day"><b>게시 날짜</b></td>
							<td class="day"><b>최종 수정 날짜</b></td>
							<td class="re"><b>조회수</b></td>
						</tr>
						<tr>
					</thead>
					<tbody>
						<c:forEach items="${fmb}" var="fmb">
							<tr>
								<td class="num"><b>${fmb.notice_seq}</b></td>
								<td class="title"><b><a href="./noticeContentPage?seq=${fmb.notice_seq}&code=1">${fmb.notice_title}</a></b></td>
								<!-- td class="grade"><b>평점</b></td>
                          <td class="name"><b>유인준</b></td -->
								<td class="day"><b>${fmb.notice_reg_date}</b></td>
								<td class="day"><b>${fmb.notice_upd_date}</b></td>
								<td class="re"><b>${fmb.notice_cnt}</b></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

				<c:if test="${page==1 || page == null}">
					<button type="button"
						onclick="javascript:location.href='./noticeList?page=1'">처음
					</button>
					<button type="button"
						onclick="javascript:location.href='./noticeList?page=1">이전</button>
				</c:if>
				<c:if test="${page>1 }">
					<button type="button"
						onclick="javascript:location.href='./noticeList?page=1'">처음
					</button>
					<button type="button"
						onclick="javascript:location.href='./noticeList?page=${page-1}'">이전
					</button>
				</c:if>

				<!---------------- 페이지 넘버링 ----------------->
				<c:forEach begin="${startPage }" end="${endPage }" var="pages">
					<a href="noticeList?page=${pages }">${pages }</a>
				</c:forEach>


				<c:if test="${page == lastPage }">
					<button type="button"
						onclick="javascript:location.href='./noticeList?page=${lastPage}'">
						다음 <i class="fa fa-angle-right" aria-hidden="true"></i>
					</button>
				</c:if>
				<c:if test="${page != lastPage }">
					<button type="button"
						onclick="javascript:location.href='./noticeList?page=${page+1}'">
						다음 <i class="fa fa-angle-right" aria-hidden="true"></i>
					</button>
				</c:if>
				<button type="button"
					onclick="javascript:location.href='./noticeList?page=${lastPage}'">
					끝 <i class="fa fa-angle-double-right" aria-hidden="true"></i>
				</button>
				<br />
			
			</div>

			<%@ include file="../common/notice_right.jsp"%>
		</div>

</body>
</html>
	
	