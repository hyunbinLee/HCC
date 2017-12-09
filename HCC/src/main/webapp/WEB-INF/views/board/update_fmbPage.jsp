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
		</div>
		<div id="contents">
		
          <div class="post">
           <!--  <form action="./updateList" method="get">-->
              <div class="search_nav">
                    <h2><input type="text" name="title" value="${fmb.fmb_title }"></input></h2>
              </div>
              <div class="post_top">
                  <div class="post_name">
                      <p>${fmb.user_name}</p>
                  </div>
                  <div class="post_text">
                      <p>댓글수</p>
                  </div>
                  <div class="post_see">
                      <p>${fmb.fmb_cnt}</p>
                  </div>
                  <div class="post_up">
                      <p>좋아요수</p>
                  </div>
                  <div class="post_down">
                      <p>싫어요수</p>
                  </div>
                  <div class="post_date">
                      <p>${fmb.fmb_reg_date}</p>
                  </div>
              </div>
              <div class="post_mid">
                  <textarea cols="80" rows="18" id="content" name="content">${fmb.fmb_content }</textarea>
              </div>
              <div class="post_bottom">

                  <div class="mod">
                  <!--  <input type="submit" value="수정하기">-->
                      <a href="./updateList?seq=${fmb.fmb_seq }">수정</a>
                  </div>
              </div>
			  </form>
               <div class="comments" >
                <span id=test1_1 ></span> 
   
              </div> 
            
			 
          </div>
		  <%@ include file="../common/inc_right.jsp"%>
		  
      </div>
</body>
</html>