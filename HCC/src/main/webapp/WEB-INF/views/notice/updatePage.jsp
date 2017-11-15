<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>


<%@ include file="../common/inc_common.jsp"%>

<%@ include file="../common/inc_header.jsp"%>

</head>
<body>
	<div class="wrap">

		<!-- Top Menu -->
		<%@ include file="../common/inc_top.jsp"%>

		<h1>수정 페이지</h1>
		<br />
		<br />
		<form action=./updateNotice method="get">
			<input type="hidden" id="seq" name="seq" value="${notice.notice_seq }" />
			<textarea cols="50" rows="1" id="title" name="title">${notice.notice_title }</textarea>
			<br /><br />
			<textarea cols="50" rows="40" id="content" name="content">${notice.notice_content }</textarea>
			<br /><br />
			<input type="submit" value="수정하기">
		</form>


	</div>
</body>
</html>
