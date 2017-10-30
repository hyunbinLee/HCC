<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>


<%@ include file="../common/inc_common.jsp"%>

<%@ include file="../common/inc_header.jsp"%>

<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script type="text/javascript">  
	$(document).ready(function(){
	    var bak_height = $('html').height();
	    $('.bak_bl').css('height',bak_height);
	});
	
	function lay_pop_close(){
	    $('.login_wrap').hide();
	    $('.bak_bl').hide();
	}
	
	function join(){
	    $('.login_wrap').show();
	    $('.bak_bl').show();
	}
    
    
    var nowpage = 1;
	
	function changePage(page) {
		search(page);
	}
	
	function search(page) {    
		
		
		var form_data = $("#frm").serialize();
		
		$.ajax({
	        complete: function(jqXHR, textStatus){   }, 
	        type: 'post',
	        dataType: "html",
	        url: './hospInfoBoard',
	        data: form_data,
	        success: function(data, textStatus , jqXHR){
				$('#contents').html(data);
	        },
	        error: function(jqXHR, textStatus, error){
	        	alert(error) ;
	        } 
	    });  
	}
	
	$(function(){
		search(nowpage);
	});
	
	function goDet(boardseq){
   	 $.ajax({
   		 type:'post',
   	 	 url:'/hospInfoBoard_detail',
   	 	 data:{boardseq : boardseq},
   	 	 contentType:"application/x-www-form-urlencoded; charset=UTF-8",
   	 	 dataType:'json'
   	 });
   	 
   	 var form = document.goDetForm;
   	 form.boardseq.value = boardseq;
   	 form.action = "/hospInfoBoard_detail";
   	 form.submit();
    }
	
		
</script> 

</head>
<body>

<div class="wrap">

		<!-- Top Menu -->
		<%@ include file="../common/inc_top.jsp"%>
	
			<h1>병원정보공유 게시판</h1>
			
			
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
                  		  	<c:forEach items="${listt}" var="listt"> 
		                      <tr>
		                          <td class="num"><b>${listt.hospital_info_seq}</b></td>
		                          <a href="#" onclick="goDet('<c:out value="${listt.hospital_info_seq}"/>');" >
		                          <td class="title"><b>${listt.hospital_info_title}</b></td>
		                          </a>
		                          <td class="grade"><b>${listt.hospital_info_score}</b></td>
		                          <td class="name"><b></b></td>
		                          <td class="day"><b>${listt.hospital_info_reg_date}</b></td>
		                          <td class="re"><b>${listt.hospital_info_like_cnt}</b></td>
		                      </tr>
		                    </c:forEach>
                  		</tbody>
              		</table>
			  
          		</div>
		  

			</div>
	
</body>
</html>