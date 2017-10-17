<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>


<%@ include file="../common/inc_common.jsp"%>

<%@ include file="../common/inc_header.jsp"%>

</head>
<body>
	<div class="wrap">
	
		<h1>내용</h1>
		<br /><br />
		<textarea cols="50" rows="1" id="title" name="title" value="">${notice.fmb_title }</textarea>
		<br /><br />
		<textarea cols="50" rows="40" id="content" name="content" value="">${notice.fmb_content }</textarea>
		<br /><br />
		
		<a href="./deleteNotice?seq=${notice.fmb_seq }">삭제</a>&nbsp;&nbsp;
		<a href="./updateNoticePage?seq=${notice.fmb_seq }">수정</a>&nbsp;&nbsp;
		<a href="./noticeList">목록</a>

	</div>
</body>
</html>
