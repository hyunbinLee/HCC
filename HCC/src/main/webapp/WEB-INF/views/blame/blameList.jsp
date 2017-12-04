<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>


<%@ include file="../common/inc_common.jsp"%>
<%@ include file="../common/inc_header.jsp"%>


</head>
<body>

		<div id="contents">
				<table>
					<thead>
						<tr>
							<td class="num"><b>번호</b></td>
							<td class="num"><b>게시판 종류</b></td>
							<td class="title"><b>신고 유형</b></td>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${list}" var="list">
							<tr>
								<td class="num"><b>${list.blame_seq}</b></td>
								<td class="num"><b>${list.blame_gubun}</b></td>
								<td class="title"><b><a href="./noticeContentPage?seq=${list.blame_seq}&code=1">${list.blame_type}</a></b></td>
								<!-- td class="grade"><b>평점</b></td>
                          <td class="name"><b>유인준</b></td -->
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
</body>
</html>