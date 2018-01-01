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
		              <div class="search_nav">
		                  <p>검색</p>
		              </div>
		              <form action="./searchHospInfo" method="get" name="sss">
		              <div class="search_box">
		                  <div>
		                  	 <select name="searchType" id="searchType">
		                  	 	<option value="all" <c:if test="${searchType=='all'}">selected</c:if>>제목+작성자</option>
		                  	 	<option value="title" <c:if test="${searchType=='title'}">selected</c:if>>제목</option>
		                  	 	<option value="name" <c:if test="${searchType=='name'}">selected</c:if>>작성자</option>
		                  	 </select>
		                  </div>
		                  <select name="searchCase" id="searchCase">
		                  	  <option value="Z" <c:if test="${searchCase=='Z'}">selected</c:if>>전체</option>
		                      <option value="A" <c:if test="${searchCase=='A'}">selected</c:if>>내과</option>
		                      <option value="B" <c:if test="${searchCase=='B'}">selected</c:if>>신경과</option>
		                      <option value="C" <c:if test="${searchCase=='C'}">selected</c:if>>정신건강의학과</option>
		                      <option value="D" <c:if test="${searchCase=='D'}">selected</c:if>>외과</option>
		                      <option value="E" <c:if test="${searchCase=='E'}">selected</c:if>>정형외과</option>
		                      <option value="F" <c:if test="${searchCase=='F'}">selected</c:if>>성형외과</option>
		                      <option value="G" <c:if test="${searchCase=='G'}">selected</c:if>>흉부외과</option>
		                      <option value="H" <c:if test="${searchCase=='H'}">selected</c:if>>소아청소년과</option>
		                      <option value="I" <c:if test="${searchCase=='I'}">selected</c:if>>안과</option>
		                      <option value="J" <c:if test="${searchCase=='J'}">selected</c:if>>이비인후과</option>
		                      <option value="K" <c:if test="${searchCase=='K'}">selected</c:if>>피부과</option>
		                      <option value="L" <c:if test="${searchCase=='L'}">selected</c:if>>비뇨기과</option>
		                      <option value="M" <c:if test="${searchCase=='M'}">selected</c:if>>마취통증의학과</option>
		                      <option value="N" <c:if test="${searchCase=='N'}">selected</c:if>>영상진단의학과</option>
		                      <option value="O" <c:if test="${searchCase=='O'}">selected</c:if>>가정의학과</option>
		                      <option value="P" <c:if test="${searchCase=='P'}">selected</c:if>>병리과</option>
		                      <option value="Q" <c:if test="${searchCase=='Q'}">selected</c:if>>산부인과</option>
		                      <option value="R" <c:if test="${searchCase=='R'}">selected</c:if>>신경외과</option>
		                      <option value="S" <c:if test="${searchCase=='S'}">selected</c:if>>재활의학과</option>
		                      <option value="T" <c:if test="${searchCase=='T'}">selected</c:if>>심장혈관병원</option>
		                      <option value="U" <c:if test="${searchCase=='U'}">selected</c:if>>암관련과</option>
		                  </select>
		                  <input type="text" name="searchWord" id="searchWord" placeholder="검색어 입력" class="search"
		                  		 <c:choose>
		                  		 <c:when test="${searchWord==null}">value=""</c:when>
		                  		 <c:otherwise> value="${searchWord}"</c:otherwise>
		                  		 </c:choose>
		                  >
		                  <input type="submit" id="search_btn" value="검색" >
		              </div>
		              </form>
		              
		              <div id="list_box">
                  		  <div class="write"><a href="./hospInfoBoard_write">글쓰기</a> 
                  		  
                  	  </div>
						 
           
              		  <table>
		                  <thead>
		                      <tr>
		                          <td class="num"><b>번호</b></td>
		                          <td class="title"><b>제목</b></td>
		                          <td class="grade"><b>평점</b></td>
		                          <td class="name"><b>작성자</b></td>
		                          <td class="day"><b>날짜</b></td>
		                          <td class="show"><b>조회수</b></td>
		                          <td class="re"><b>추천수</b></td>
	                      	  </tr>
	                  	  </thead>
	                  	  
                  		  <tbody>
                  		  	<c:forEach items="${list}" var="list"> 
		                      <tr>
		                          <td class="num"><b>${list.hospital_info_seq}</b></td>		                            
		                          <td class="title"><b><a href="./hospInfoBoard_detail?boardseq=${list.hospital_info_seq}">${list.hospital_info_title}</a></b></td>
		                          <td class="grade">
			                          	<c:set var="star" value="${detail.hospital_info_score}" />
										<c:choose>
											<c:when test="${star == 5.0}">
												<p>★★★★★</p>
											</c:when>
											<c:when test="${star == 4.0}">
												<p>★★★★☆</p>
											</c:when>
											<c:when test="${star == 3.0}">
												<p>★★★☆☆</p>
											</c:when>
											<c:when test="${star == 2.0}">
												<p>★★☆☆☆</p>
											</c:when><c:when test="${star == 1.0}">
												<p>★☆☆☆☆</p>
											</c:when>
										</c:choose>
		                          </td>
		                          <td class="name"><b>${list.user_name}</b></td>
		                          <td class="day"><b>${list.hospital_info_reg_date}</b></td>
		                          <td class="show"><b>${list.hospital_info_cnt}</b></td>
		                          <td class="re"><b>${list.hospital_info_like_cnt}</b></td>
		                      </tr>
		                    </c:forEach>
                  		</tbody>
              		</table>
              		
              		<c:if test="${page==1 || page == null}">
						<button type="button"
							onclick="javascript:location.href='./hospInfoBoard?page=1'">처음
						</button>
						<button type="button"
							onclick="javascript:location.href='./hospInfoBoard?page=1">이전</button>
					</c:if>
					<c:if test="${page>1 }">
						<button type="button"
							onclick="javascript:location.href='./hospInfoBoard?page=1'">처음
						</button>
						<button type="button"
							onclick="javascript:location.href='./hospInfoBoard?page=${page-1}'">이전
						</button>
					</c:if>

					<!---------------- 페이지 넘버링 ----------------->
					<c:forEach begin="${startPage }" end="${endPage }" var="pages">
						<a href="hospInfoBoard?page=${pages }">${pages }</a>
					</c:forEach>
	
	
					<c:if test="${page == lastPage }">
						<button type="button"
							onclick="javascript:location.href='./hospInfoBoard?page=${lastPage}'">
							다음 <i class="fa fa-angle-right" aria-hidden="true"></i>
						</button>
					</c:if>
					<c:if test="${page != lastPage }">
						<button type="button"
							onclick="javascript:location.href='./hospInfoBoard?page=${page+1}'">
							다음 <i class="fa fa-angle-right" aria-hidden="true"></i>
						</button>
					</c:if>
					<button type="button"
						onclick="javascript:location.href='./hospInfoBoard?page=${lastPage}'">
						끝 <i class="fa fa-angle-double-right" aria-hidden="true"></i>
					</button>
					<br />
              		
              		
              		
			  </div>
			  
			  <%@ include file="../common/inc_right.jsp"%>
          </div>
	</div>
</body>
</html>