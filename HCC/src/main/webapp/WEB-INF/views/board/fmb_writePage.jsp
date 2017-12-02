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
		<%@ include file="../common/inc_top.jsp"%>

		<div id="contents">

		<div class=write_page>
			<form action="./fmbWrite" method="get">
				<div class="search_nav">
					<h2>의사 환자게시판 글쓰기</h2>
				</div>

				<div class="write_top">
					<select name="select" id="write_select">
						<option value="P">환자</option>
						<option value="D">의사</option>
						<option value="N">공지</option>
					</select>
					<input type="text" id="title" name="title" class="write_input"	placeholder="제목"> 
				</div>

				<div class="write_mid">
					<textarea cols="50" rows="40" id="content" name="content" class="content"
						placeholder="내용"></textarea>
				</div>
				<div class="write_bottom">
					<input type="radio" name="status" id="status" class="status" value="Y">활성화
					<input type="radio" name="status" id="status" value="N">비활성화
					<div class="reg">
                     <input type="submit" value="글쓰기" id="reg_btn">
                    </div>
				</div>

			</form>
		</div>

		<%@ include file="../common/inc_right.jsp"%>


	</div>
</div>
</body>
</html>
