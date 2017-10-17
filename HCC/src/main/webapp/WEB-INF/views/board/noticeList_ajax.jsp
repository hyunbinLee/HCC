<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>


<form id="frm" name="frm" method="post" action="#">
	<table id="products">
		<tr>
			<td>글 번호</td>
			<td>제목</td>
			<td>게시 날짜</td>
			<td>최종 수정 날짜</td>
		</tr>
		<c:forEach items="${list }" var="list">
			<tr>
				<td>${list.fmb_seq }</td>
				<td><a href="./noticeContentPage?seq=${list.fmb_seq }">${list.fmb_title }</a>
				</td>
				<td>${list.fmb_reg_date }</td>
				<td>${list.fmb_upd_date }</td>
			</tr>
		</c:forEach>
	</table>
	<a href="./noticeWritePage" class="">글쓰기</a> <br />

	<c:if test="${block == 1}">
		<button type="button" disabled>
			<i class="fa fa-angle-double-left" aria-hidden="true"></i>
		</button>
		<button type="button" disabled>
			<i class="fa fa-angle-left" aria-hidden="true"></i>
		</button>
	</c:if>

	<c:if test="${block > 1 }">
		<button type="button"
			onclick="javascript:location.href='./noticeList?block=1'">
			<i class="fa fa-angle-double-left" aria-hidden="true"></i>
		</button>
		<button type="button"
			onclick="javascript:location.href='./noticeList?block=${block -1}'">
			<i class="fa fa-angle-left" aria-hidden="true"></i>
		</button>
	</c:if>

	<c:forEach begin="1" end="${pages}" var="pages">
		<a href="noticeList?block=${block }&page=${pages }">${pages }</a>
	</c:forEach>

	<c:if test="${block == blocks }">
		<button type="button" disabled>
			<i class="fa fa-angle-right" aria-hidden="true"></i>
		</button>
		<button type="button" disabled>
			<i class="fa fa-angle-double-right" aria-hidden="true"></i>
		</button>
	</c:if>
	<c:if test="${block != blocks }">
		<button type="button"
			onclick="javascript:location.href='./noticeList?block=${block+1}'">
			<i class="fa fa-angle-right" aria-hidden="true"></i>
		</button>
		<button type="button"
			onclick="javascript:location.href='./noticeList?block=${blocks}'">
			<i class="fa fa-angle-double-right" aria-hidden="true"></i>
		</button>
	</c:if>
	<br />
	----------------------------------------------------------------------------------------------
</form>
