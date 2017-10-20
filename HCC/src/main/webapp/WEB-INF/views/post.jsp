<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>


<%@ include file="common/inc_header.jsp"%>

<script>
	$(document).ready(function() {
		var bak_height = $('html').height();
		$('.bak_bl').css('height', bak_height);
	});

	function lay_pop_close() {
		$('.login_wrap').hide();
		$('.bak_bl').hide();
	}

	function join() {
		$('.login_wrap').show();
		$('.bak_bl').show();
	}

	function Open() {
		document.getElementById('test1_1').style.display = 'none';
		document.getElementById('test1_2').style.display = '';
		document.getElementById('post_bottom_text').innerHTML = '<a href="javascript:Close();" >댓글닫기</a>';
	}
	function Close() {
		document.getElementById('test1_2').style.display = 'none';
		document.getElementById('test1_1').style.display = '';
		document.getElementById('post_bottom_text').innerHTML = '<a href="javascript:Open();">댓글열기</a>';
	}

	function testInnerHTML(i, comment, seq, register_seq3) {

		var str = "";

		str += '<textarea id="update_text'+i;
    	str +=  '" name="update_text'+i;
    	str +=  '" class="comment" maxlength="250" >';
		str += comment;
		str += '</textarea>';
		str += '<input type="button" id="comment_btn" onClick="javascript:updateComment(';
		str += "'update_text" + i;
		str += "','" + seq;
		str += "','" + register_seq3;
		str += "')";
		str += '" value="Update">';

		document.getElementById("inHere" + i).innerHTML = str;

	}

	function cencleInnerHTML(i, comment) {

		var str = "";

		str += '<a>';
		str += comment;
		str += '</a>';

		document.getElementById("inHere" + i).innerHTML = str;

	}
</script>
</head>

<body>
	<div class="wrap">
		<!-- Top Menu -->
		<%@ include file="common/inc_top_post.jsp"%>

		<div id="contents">
			<div class="post">
				<div class="search_nav">
					<h2>고려대학병원 추천합니다.</h2>
				</div>
				<div class="post_top">
					<div class="post_name">
						<p>이요한</p>
					</div>
					<div class="post_text">
						<p>15075</p>
					</div>
					<div class="post_see">
						<p>155</p>
					</div>
					<div class="post_up">
						<p>150</p>
					</div>
					<div class="post_down">
						<p>2</p>
					</div>
					<div class="post_date">
						<p>2017-09-27</p>
					</div>
				</div>
				<div class="post_mid">고려대학병원 추천합니다.</div>
				<div class="post_bottom">
					<div class="post_bottom_like">좋아요</div>
					<div class="post_bottom_bad">싫어요</div>
					<div class="post_bottom_text" id="post_bottom_text">
						<a href="javascript:Open();">댓글열기</a>
					</div>
					<div class="del">
						<a href="#">삭제</a>
					</div>
					<div class="mod">
						<a href="#">수정</a>
					</div>
				</div>


				<div class="comments">
					<span id=test1_1></span> <span id=test1_2 style="DISPLAY: none;">
						<div class="comments_list">
							<span class="comments_span"> <a class="comments_info">유인준&nbsp;&nbsp;&nbsp;&nbsp;Date
									: 2017-10-07</a> <span class="comments_fun"> <!--testInnerHTML('댓글번호','댓글내용','댓글시퀀스','사용자시퀀스');" -->
									<a href="javascript:testInnerHTML('1','test','1','1');">Update</a>&nbsp;&nbsp;
									<!--commentDelete('댓글시퀀스','사용자시퀀스');" --> <a
									href="javascript:commentDelete('1','1');">Delete</a>&nbsp;&nbsp;
									<!--cencleInnerHTML('댓글번호','댓글내용');" --> <a
									href="javascript:cencleInnerHTML('1','test');">Cancel</a>
							</span>
							</span>
							<div class="inHere" id="inHere1">
								<a>test</a>
							</div>
						</div>

						<div class="comments_text">
							<textarea id="comment" class="comment" name="comment"
								maxlength="250"></textarea>
							<input type="button" id="comment_btn" value="Register">
						</div>
					</span>

				</div>


			</div>

			<div id="name">
				<div class="search_nav">
					<p>회원센터</p>
				</div>
				<div id="name_box">
					<c:url value="/logout" var="logoutUrl" />
					<form name="f" action="${logoutUrl}" method="post">
						<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />
						<div id="top">
							<div></div>
							<div>
								<sec:authentication property="principal.realusername" />
								님 환영합니다!
							</div>
						</div>
						<div class="bottom">
							<p>
								<a href="#" class="" id="">마이 페이지 </a>
							</p>
							<p>
								<input type="submit" class="right" value="Logout">
							</p>
						</div>
					</form>
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
