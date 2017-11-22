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
	
			
			<div id="contents">
		          <div id="search">
		              <div class="search_nav">
		                  <p>검색</p>
		              </div>
		              <div class="search_box">
		                  <div>
		                     <input type="checkbox" value="제목"> 제목
		                     <input type="checkbox" value="작성자"> 작성자
		                  </div>
		                  <select name="select" id="select">
		                      <option value="흉부외과">흉부외과</option>
		                      <option value="흉부외과">정형외과</option>
		                      <option value="흉부외과">이빈인후과</option>
		                      <option value="흉부외과">내과</option>
		                  </select>
		                  <input type="text" placeholder="검색어 입력" class="search">
		                  <input type="button" id="search_btn" value="검색" >
		              </div>
		              
		              <div id="list_box">
                  		  <div id="adult">성인</div>
                  		  <div id="teenager">소아/청소년</div>
                  		  <div class="write"><a href="./hospInfoBoard_write">글쓰기</a></div>
             		  </div>
              		  <table>
		                  <thead>
		                      <tr>
		                          <td class="num"><b>번호</b></td>
		                          <td class="title"><b>제목</b></td>
		                          <td class="grade"><b>평점</b></td>
		                          <td class="name"><b>이름</b></td>
		                          <td class="day"><b>날짜</b></td>
		                          <td class="re"><b>추천수</b></td>
	                      	  </tr>
	                  	  </thead>
	                  	  
                  		  <tbody>
                  		  	<c:forEach items="${list}" var="list"> 
		                      <tr>
		                          <td class="num"><b>${list.hospital_info_seq}</b></td>
		                          <td class="title"><b><a
										href="./hospInfoBoard_detail?boardseq=${list.hospital_info_seq}">${list.hospital_info_title}</a></b></td>
		                          <td class="grade"><b>${list.hospital_info_score}</b></td>
		                          <td class="name"><b></b></td>
		                          <td class="day"><b>${list.hospital_info_reg_date}</b></td>
		                          <td class="re"><b>${list.hospital_info_like_cnt}</b></td>
		                      </tr>
		                    </c:forEach>
                  		</tbody>
              		</table>
			  </div>
			  
			  <%@ include file="../common/inc_right.jsp"%>
          </div>
	</div>
</body>
</html>