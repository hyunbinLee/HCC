<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>


<%@ include file="../common/inc_common.jsp"%>

<%@ include file="../common/inc_header.jsp"%>
</head>
<body>

 <c:url value="/infoupdate" var="infoupdate" />
				<form name="f" action="${infoupdate}" method="post">
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
					<div class="login_area m_b80">
						<div class="login_title m_b10 p_b5">
							<span class="p_b5">회원센터</span>
						</div>
						<div class="">
							<label><sec:authentication property="principal.username" /></label><br/>
							<input type="password" name="passwordcheck" id="passwordcheck" class="" value="" placeholder="비밀번호"><br/><br/><br/>
						</div>
						<div class="other_login">
						<input type="submit" class="left" value="회원정보수정">
						</div>
					</div>
				</form>
				
</body>
</html>