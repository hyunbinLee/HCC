<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>


<%@ include file="../common/inc_common.jsp"%>

<%@ include file="../common/inc_header.jsp"%>

</head>

<body>
  <div class="wrap">
    <div class="header_wrap m_b30">
      <div class="logo_area">
        <a href="#" class="main_logo"><span>건강관리 커뮤니티 사이트</span></a>
      </div>
      <div class="header_nav">
        <ul>
          <li><a href="#" class="">홈 버튼</a></li>
          <li><button type="button">리스트</button></li>
          <li><a href="#" class="">자가진단</a></li>
          <li><a href="#" class="on">병원정보</a></li>
          <li><a href="#" class="">병에대한후기</a></li>
          <li><a href="#" class="">게시판</a></li>
        </ul>
       </div>
      </div>
      <div id="contents">
          <div class="post">
              <div class="search_nav">
                    <h2>${detail.hospital_info_title}</h2>
              </div>
              <div class="post_top">
                  <div class="post_name">
                      <p>${detail.user_name}</p>
                  </div>
                  <div class="post_text">
                      <p>${detail.hospital_info_content}</p>
                  </div>
                  <div class="post_see">
                      <p>${detail.hospital_info_cnt}</p>
                  </div>
                  <div class="post_up">
                      <p>${detail.hospital_info_like_cnt}</p>
                  </div>
                  <div class="post_down">
                      <p>${detail.hospital_info_unlike_cnt}</p>
                  </div>
                  <div class="post_date">
                      <p>${detail.hospital_info_reg_date}</p>
                  </div>
              </div>
              <div class="post_mid">
            ${detail.hospital_info_title}
              </div>
              <div class="post_bottom">
                  <div class="post_bottom_like">
                      좋아요
                  </div>
                  <div class="post_bottom_bad">
                      싫어요
                  </div>
                  <div class="post_bottom_text" id="post_bottom_text">
                       <a href="javascript:Open();">댓글열기</a>
                  </div>
                  <div class="del">
                      <a href="./deleteHospInfo?boardseq=${detail.hospital_info_seq}">삭제</a>
                  </div>
                  <div class="mod">
                      <a href="./hospInfoBoard_modify?boardseq=${detail.hospital_info_seq}">수정</a>
                  </div>
              </div>
			  
			 
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
		  
          <div id="name">
              <div class="search_nav">
                  <p>회원센터</p>
              </div>
              <div id="name_box">
                  <div id="top">
                      <div></div>
                      <div> 닉네임</div>
                  </div>
                  <div id="bottom">
                      <p><a href="#">마이페이지</a></p>
                      <p><a href="#">로그아웃</a></p>
                  </div>
              </div>
			  
			  <div id="rank_box">
			     <div class="search_nav">
                  <p>TOP 5</p>
                 </div>
                 <div id="rank_top">
                   <table>
                      <tbody>
                          <tr>
                              <td class="number"><b>1</b></td>
                              <td><b>고려대학병원 추천합...</b></td>
                              <td class="rank_num"><b>51321</b></td>
                          </tr>
                          <tr>
                              <td class="number"><b>2</b></td>
                              <td><b>고려대학병원 추천합...</b></td>
                              <td class="rank_num"><b>1321</b></td>
                          </tr>
                          <tr>
                              <td class="number"><b>3</b></td>
                              <td><b>고려대학병원 추천합...</b></td>
                              <td class="rank_num"><b>321</b></td>
                          </tr>
                          <tr>
                              <td class="number"><b>4</b></td>
                              <td><b>고려대학병원 추천합...</b></td>
                              <td class="rank_num"><b>21</b></td>
                          </tr>
                          <tr>
                              <td class="number"><b>5</b></td>
                              <td><b>고려대학병원 추천합...</b></td>
                              <td class="rank_num"><b>1</b></td>
                          </tr>
                      </tbody>
                   </table>
                 </div>
			  </div>
			  
          </div>
  
		  
      </div>
  </div>
</body>
</html>