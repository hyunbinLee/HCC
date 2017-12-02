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
           <form action="./updateList" method="get">
              <div class="search_nav">
                    <h2><textarea cols="80" rows="3" id="title" name="title">${fmb.fmb_title }</textarea></h2>
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
                  <input type="submit" value="수정하기">
                  <!--  
                      <a href="./updateList">수정</a> -->
                  </div>
              </div>
			  </form>
               <div class="comments" >
                <span id=test1_1 ></span> 
   
                <span id=test1_2  style="DISPLAY: none;">
                     <div class="comments_list">
                       <span class="comments_span">
                              <a class="comments_info">유인준&nbsp;&nbsp;&nbsp;&nbsp;Date : 2017-10-07</a>
                              <span class="comments_fun">
                                 <!--testInnerHTML('댓글번호','댓글내용','댓글시퀀스','사용자시퀀스');" -->
								 <a href="javascript:testInnerHTML('1','test','1','1');" >Update</a>&nbsp;&nbsp;
								 <!--commentDelete('댓글시퀀스','사용자시퀀스');" -->
                                 <a href="javascript:commentDelete('1','1');">Delete</a>&nbsp;&nbsp;
								 <!--cencleInnerHTML('댓글번호','댓글내용');" -->
                                 <a href="javascript:cencleInnerHTML('1','test');">Cancel</a>
						      </span> 
                       </span>
                       <div class="inHere" id="inHere1" >
                         <a>test</a> 
                       </div>
                     </div> 

                     <div class="comments_text" >
                       <textarea id="comment" class="comment" name="comment" maxlength="250" ></textarea>
					   <input type="button" id="comment_btn" value="Register" >
                     </div> 
                </span> 
 
              </div> 
            
			 
          </div>
		  <%@ include file="../common/inc_right.jsp"%>
		  
      </div>
</body>
</html>