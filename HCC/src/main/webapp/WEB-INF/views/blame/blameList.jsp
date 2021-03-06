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
							<td class="title"><b>신고 내용</b></td>
							<td class="title"><b>신고 접수</b></td>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${list}" var="list">
							<tr>
								<td class="num"><b>${list.blame_seq}</b></td>
								<td class="num"><b>${list.blame_gubun}</b></td>
								<td class="title"><b>${list.blame_type}</b></td>
								<c:if test="${list.blame_gubun == 'D'.charAt(0)}">
									<td class="title"><b><a href="./fmbContentPage?seq=${list.blame_code}">${list.blame_content}_</a></b></td>
									
								</c:if>
								
								<c:if test="${list.blame_gubun == 'H'.charAt(0) }">
									<td class="title"><b><a href="./hospInfoBoard_detail?boardseq=${list.blame_code }">${list.blame_content}_</a></b></td>
								</c:if>
								
								
								<td>
									<a href="./DeclarationOK?seq=${list.blame_seq }">O</a>/
									<a href="./DeclarationX?seq=${list.blame_seq }">X</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

				<c:if test="${page==1 || page == null}">
					<button type="button"
						onclick="javascript:location.href='./blameList?page=1'">처음
					</button>
					<button type="button"
						onclick="javascript:location.href='./blameList?page=1">이전</button>
				</c:if>
				<c:if test="${page>1 }">
					<button type="button"
						onclick="javascript:location.href='./blameList?page=1'">처음
					</button>
					<button type="button"
						onclick="javascript:location.href='./blameList?page=${page-1}'">이전
					</button>
				</c:if>

				<!---------------- 페이지 넘버링 ----------------->
				<c:forEach begin="${startPage }" end="${endPage }" var="pages">
					<a href="blameList?page=${pages }">${pages }</a>
				</c:forEach>


				<c:if test="${page == lastPage }">
					<button type="button"
						onclick="javascript:location.href='./blameList?page=${lastPage}'">
						다음 <i class="fa fa-angle-right" aria-hidden="true"></i>
					</button>
				</c:if>
				<c:if test="${page != lastPage }">
					<button type="button"
						onclick="javascript:location.href='./blameList?page=${page+1}'">
						다음 <i class="fa fa-angle-right" aria-hidden="true"></i>
					</button>
				</c:if>
				<button type="button"
					onclick="javascript:location.href='./blameList?page=${lastPage}'">
					끝 <i class="fa fa-angle-double-right" aria-hidden="true"></i>
				</button>
				<br />
		</div>
</body>
</html>