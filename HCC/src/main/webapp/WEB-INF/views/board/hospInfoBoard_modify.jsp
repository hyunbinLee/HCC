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


		<div class=write_page>
			<form action="./modifyHospInfo" method="get">
				<div class="search_nav">
					<h2>병원정보공유 게시판 수정</h2>
				</div>

				<div class="write_top">
					평점
					<select name="star" id="star">
						<option value="5.0" <c:if test="${detail.hospital_info_score.equals('5.0')}">selected</c:if>>★★★★★</option>
						<option value="4.0" <c:if test="${detail.hospital_info_score.equals('4.0')}">selected</c:if>>★★★★☆</option>
						<option value="3.0" <c:if test="${detail.hospital_info_score.equals('3.0')}">selected</c:if>>★★★☆☆</option>
						<option value="2.0" <c:if test="${detail.hospital_info_score.equals('2.0')}">selected</c:if>>★★☆☆☆</option>
						<option value="1.0" <c:if test="${detail.hospital_info_score.equals('1.0')}">selected</c:if>>★☆☆☆☆</option>
						<option value="0.0" <c:if test="${detail.hospital_info_score.equals('0.0')}">selected</c:if>>☆☆☆☆☆</option>
					</select>
					<input type="text" id="title" name="title" class="write_input" placeholder="${detail.hospital_info_title}"> 
					<input type="hidden" name="boardseq" value="${detail.hospital_info_seq}" />
				</div>

				<div class="write_mid">
					<textarea cols="50" rows="40" id="content" name="content" class="content"
						placeholder="${detail.hospital_info_content}"></textarea>
				</div>
				<div class="write_bottom">
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
