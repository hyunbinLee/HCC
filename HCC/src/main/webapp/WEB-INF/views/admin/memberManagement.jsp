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
				

				<div id="list_box">
					<div id=" ">회원 목록</div>
				</div>
				<table>
					<thead>
						<tr>
							<td class="title"><b>아이디</b></td>
							<!-- td class="grade"><b>평점</b></td>
                          <td class="name"><b>이름</b></td -->
							<td class="day"><b>이름</b></td>
							<td class="num"><b>성별</b></td>
							<td class="day"><b>생년월일</b></td>
							<td class="re"><b>신고횟수</b></td>
						</tr>
						<tr>
					</thead>
					<tbody>
						<c:forEach items="${list}" var="list">
							<tr>
								<td class="title"><b><a
										href="./userInfo?id=${list.user_id}">${list.user_id}</a></b></td>
								<!-- td class="grade"><b>평점</b></td>
                          <td class="name"><b>유인준</b></td -->
								<td class="day"><b>${list.user_name}</b></td>
								<td class="num"><b>${list.user_gender}</b></td>
								<td class="day"><b>${list.user_birth}</b></td>
								<td class="re"><b>${list.user_blame_cnt}</b></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

				<c:if test="${page==1 || page == null}">
					<button type="button"
						onclick="javascript:location.href='./memberManagement?page=1'">처음
					</button>
					<button type="button"
						onclick="javascript:location.href='./memberManagement?page=1">이전</button>
				</c:if>
				<c:if test="${page>1 }">
					<button type="button"
						onclick="javascript:location.href='./memberManagement?page=1'">처음
					</button>
					<button type="button"
						onclick="javascript:location.href='./memberManagement?page=${page-1}'">이전
					</button>
				</c:if>

				<!---------------- 페이지 넘버링 ----------------->
				<c:forEach begin="${startPage }" end="${endPage }" var="pages">
					<a href="noticeList?page=${pages }">${pages }</a>
				</c:forEach>


				<c:if test="${page == lastPage }">
					<button type="button"
						onclick="javascript:location.href='./memberManagement?page=${lastPage}'">
						다음 <i class="fa fa-angle-right" aria-hidden="true"></i>
					</button>
				</c:if>
				<c:if test="${page != lastPage }">
					<button type="button"
						onclick="javascript:location.href='./memberManagement?page=${page+1}'">
						다음 <i class="fa fa-angle-right" aria-hidden="true"></i>
					</button>
				</c:if>
				<button type="button"
					onclick="javascript:location.href='./memberManagement?page=${lastPage}'">
					끝 <i class="fa fa-angle-double-right" aria-hidden="true"></i>
				</button>
				<br />
			
			</div>

			<%@ include file="../common/inc_right.jsp"%>
		</div>
	</div>
</body>
</html>
	
	