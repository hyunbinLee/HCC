<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<%@ include file="../common/inc_header.jsp"%>

</head>
<body>
	<div class="">
		<div class="">
			<h1>회원가입</h1>
		</div>
		<c:url value="/infoupdatesaved" var="infoupdatesaved"></c:url>
		<form name="regiform" action="${infoupdatesaved }" method="post">
 		<input type="hidden" id="authCheck" name="authCheck" value="false">
 		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /> 
			<div class="login_content">
			
				<label>아이디 : </label>${UserId }<br/>
				<label>이름 : </label>${UserName }<br/>
				<label>성별 : </label>
				<c:set var="gender" value="${UserGender }"/>
				<c:choose>
				<c:when test="${gender eq 'M'}">남자</c:when>
				<c:otherwise>여자</c:otherwise>
				</c:choose> 
				<br/>
				<input type="password" id="user_pw" name="user_pw" class="" value="" placeholder="비밀번호"> 
				<input type="password" id="regi_pw2" name="regi_pw2" class="" value="" placeholder="비밀번호 재확인"> 
				<input type="text" id="user_phone" name="user_phone" placeholder="핸드폰번호"> 
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
			

			</div>
			<input type="submit" value="회원정보수정" onclick="return checkModify()" />
		</form>
	</div>
</body>
</html>