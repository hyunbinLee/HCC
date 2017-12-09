<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<script type="text/javascript" src="resources/js/blame.js"></script>

<%@ include file="../common/inc_common.jsp"%>

<%@ include file="../common/inc_header.jsp"%>

</head>
<body>
	<div class="wrap">
		<%@ include file="../common/inc_top.jsp"%>

		 <div id="contents">
		
          <div class="post">
          	   <!--  <form action="./ReplyWrite">-->
              <div class="search_nav">
                    <h2>${fmb.fmb_title }</h2>
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
                      <p>${fmb.fmb_like_cnt}</p>
                  </div>
                  <div class="post_down">
                      <p>${fmb.fmb_unlike_cnt}</p>
                  </div>
                  <div class="post_date">
                      <p>${fmb.fmb_reg_date}</p>
                  </div>
              </div>
              <div class="post_mid">
                   ${fmb.fmb_content }
              </div>
              <div class="post_bottom">
                  <div class="post_bottom_like">
                     <a href="./likeList?seq=${fmb.fmb_seq}">좋아요</a>
                  </div>
                  <div class="post_bottom_bad">
                     <a href="./unlikeList?seq=${fmb.fmb_seq}">싫어요</a>
                  </div>
                  <div class="post_bottom_text" id="post_bottom_text">
                       <a href="javascript:Open();">댓글열기</a>
                  </div>
                  <div class="">
                  	<button onclick="showBlamePopup('D')">신고</button>
                  </div>
                  <div class="del">
					  <a href="./deleteList?seq=${fmb.fmb_seq}">삭제</a>                  </div>
                  <div class="mod">
                      <a href="./updateListPage?seq=${fmb.fmb_seq }">수정</a>
                  </div>
              </div>
			  
			 
               <div class="comments" >
                <span id=test1_1 ></span> 
   
                <span id=test1_2>
			<c:forEach var="reply" items="${reply}">
                     <div class="comments_list">
                       <span class="comments_span">
                              <a class="comments_info">${reply.fmb_reply_reg_seq}&nbsp;&nbsp;&nbsp;&nbsp;Date : 2017-10-07</a>
                              <span class="comments_fun">
                                 <!--testInnerHTML('댓글번호','댓글내용','댓글시퀀스','사용자시퀀스');" -->
								 <a href="javascript:testInnerHTML('1','test','1','1');" >Update</a>&nbsp;&nbsp;
								 <!--commentDelete('댓글시퀀스','사용자시퀀스');" -->
                                <a href="./deletereply?seq=${reply.fmb_reply_seq}&fmb_seq=${reply.fmb_seq}">Delete</a>&nbsp;&nbsp;
								 <!--cencleInnerHTML('댓글번호','댓글내용');" -->
                                 <a href="javascript:cencleInnerHTML('1','test');">Cancel</a>
						      </span> 
                       </span>
                       <div class="inHere" id="inHere1" >
                         <a>${reply.fmb_reply_comment}</a> 
                       </div>
                     </div> 
                     </c:forEach>
                     <div class="comments_text" >
                       <textarea id="comment" class="comment" name="comment" maxlength="250" ></textarea>
                       <a href="./ReplyWrite?seq=${fmb.fmb_seq}">댓글쓰기</a>
					   <!--  <input type="submit" id="comment_btn" value="Register" >-->
                     </div>
                </span> 
              </div>
               </form>
          </div>
		  
		  <%@ include file="../common/inc_right.jsp"%>

      </div>
</div>
	
</body>
</html>
