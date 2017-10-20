<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 <c:url value="/login" var="loginUrl" />
				<form name="f" action="${loginUrl}" method="post">
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
					<div class="login_area m_b80">
						<div class="login_title m_b10 p_b5">
							<span class="p_b5">회원센터</span>
						</div>
						<div class="login_box m_b5">
							<div></div>
							<input type="text" name="id" id="id" class="" value=""
								placeholder="아이디">
							<div></div>
							<input type="password" name="pw" id="pw" class="" value=""
								placeholder="비밀번호">
						</div>
						<c:if test="${param.error != null}">
							<p>아이디와 비밀번호가 잘못되었습니다.</p>
						</c:if>
						<div class="other_login">
							<div class="left">
								<input type="checkbox" id="" name="" class="m_r4" value="">
								<span>자동로그인</span>
							</div>
							<a href="#" class="" id="">아이디 / 비밀번호 찾기 </a>&nbsp;&nbsp;
							<button type="button" onclick="join()" class="">회원가입</button>
							<input type="submit" class="right" value="Login">
						</div>
					</div>
				</form>
				
	<%@ include file="common/inc_join.jsp"%>

</body>
</html>