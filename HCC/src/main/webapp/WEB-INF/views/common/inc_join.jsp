<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

        <!-- 레이어 팝업 백그라운드 부분-->
		<div class="bak_bl"></div>
		
		<!-- 레이어 팝업 백그라운드 부분 끝-->
		<div class="login_wrap">
			<div class="login_header">
				<h1>회원가입</h1>
				<button type="button" onclick="lay_pop_close()">X</button>
			</div>
			<c:url value="/register" var="regiUrl"></c:url>
			<form name="regiform" action="${regiUrl }" method="get">
			<input type="hidden" id="dupCheck" name="dupCheck" value="false">	
 			<input type="hidden" id="authCheck" name="authCheck" value="false"> 
			<div class="login_content">
				<input type="text" id="user_id" name="user_id" class="" value="" placeholder="아이디">
				<input type="button" id="regi_id_auth" name="regi_id_auth" class="" value="중복확인">
				<input type="password" id="user_pw" name="user_pw" class="" value="" placeholder="비밀번호">
				<input type="password" id="regi_pw2" name="regi_pw2" class="" value="" placeholder="비밀번호 재확인"> 
				<input type="text" id="user_name" name="user_name" placeholder="이름">
				<input type="text" id="user_phone" name="user_phone" placeholder="핸드폰번호">
				<input type="date" id="user_birth" name="user_birth" class="" placeholder="생년월일(ex 19900101)">
				<div class="e_wrap m_b30">
					<input type="text" id="regi_email_f" name="regi_email_f" class="login_e" value="" placeholder="이메일">@
					<select name="regi_email_b" id="regi_email_b">
						<option>naver.com</option>
						<option>daum.net</option>
						<option>hanmail.com</option>
						<option>yahoo.com</option>
					</select>
					<button type="button" id="regi_auth" name="regi_auth">인증</button>
				</div>
				<div class="e_wrap">
					<input type="text" id="input_code" name="input_code" class="login_e" value="" placeholder="인증번호">
					<button type="button" id="regi_auth_confirm" name="regi_auth_confirm">확인</button>
				</div>
				<div>
				<br/>
				<input type="radio" id="user_gender" name="user_gender" value="M" checked="checked">남자 &nbsp;&nbsp;&nbsp;&nbsp;
				
				<input type="radio" id="user_gender" name="user_gender" value="W">여자
				<br/><br/>
				
				</div>
				
			</div>
			<input type="submit" value="가입하기" onclick="return checkfield()" />
			</form>
			</div>