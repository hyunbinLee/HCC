<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>


<%@ include file="../common/inc_common.jsp"%>

<%@ include file="../common/inc_header.jsp"%>

<script language="javascript">

	function popup() {

		var star = document.form.star.value;
		var type = document.form.type.value;
		var title = document.form.title.value;
		var content = document.form.content.value;
		var url = "./toApiTest?star="+star+"&type="+type+"&title="+title+"&content="+content;
		
		window.open(url,'popup','scrollbars=no,resizable=no,width=800,height=600');
	}
</script>
</head>
<body>
	<div class="wrap">
		<%@ include file="../common/inc_top.jsp"%>

		<div id="contents">

		<div class=write_page>
			<form action="./writeHospInfo" method="get" name="form">
				<div class="search_nav">
					<h2>병원정보공유 게시판 글쓰기</h2>
				</div>

				<div class="write_top">
					평점
					<select name="star" id="star">
						<option value="5.0" <c:if test="${star.equals('5.0')}">selected</c:if>>★★★★★</option>
						<option value="4.0" <c:if test="${star.equals('4.0')}">selected</c:if>>★★★★☆</option>
						<option value="3.0" <c:if test="${star.equals('3.0')}">selected</c:if>>★★★☆☆</option>
						<option value="2.0" <c:if test="${star.equals('2.0')}">selected</c:if>>★★☆☆☆</option>
						<option value="1.0" <c:if test="${star.equals('1.0')}">selected</c:if>>★☆☆☆☆</option>
						<option value="0.0" <c:if test="${star.equals('0.0')}">selected</c:if>>☆☆☆☆☆</option>
					</select>
					<input type="text" id="title" name="title" class="write_input" placeholder="${title}"> 
				</div>
				
				<div class="write_top">
				
					타입
					<select name="type" id="type">
						<option value="A" <c:if test="${type.equals('0.0')}">selected</c:if>>성인</option>
						<option value="C" <c:if test="${type.equals('0.0')}">selected</c:if>>소아청소년</option>
					</select>
					  
				</div>  
				<div class="write_top">
					<!-- 
					진료과
					<select name="class" id="class">
		                      <option value="A">내과</option>
		                      <option value="B">신경과</option>
		                      <option value="C">정신건강의학과</option>
		                      <option value="D">외과</option>
		                      <option value="E">정형외과</option>
		                      <option value="F">성형외과</option>
		                      <option value="G">흉부외과</option>
		                      <option value="H">소아청소년과</option>
		                      <option value="I">안과</option>
		                      <option value="J">이비인후과</option>
		                      <option value="K">피부과</option>
		                      <option value="L">비뇨기과</option>
		                      <option value="M">마취통증의학과</option>
		                      <option value="N">영상진단의학과</option>
		                      <option value="O">가정의학과</option>
		                      <option value="P">병리과</option>
		                      <option value="Q">산부인과</option>
		                      <option value="R">신경외과</option>
		                      <option value="S">재활의학과</option>
		                      <option value="T">심장혈관병원</option>
		                      <option value="U">암관련과</option>
		              </select>
		             
		                         병원이름
		              <input type="text" id="hospnm" name="hospnm" class="write_input"	placeholder="병원이름"> 
		                -->
		                
		              
		              <input type="button" value="병원검색" onclick="popup();" />
		              
		              <a href="#" onClick="javascript:popup()"> 클릭 </a>
		              
		         </div>
		                  

				<div class="write_mid">
					<textarea cols="50" rows="40" id="content" name="content" class="content"
						placeholder="내용"></textarea>
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
