<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>



</head>
<body>

<div class="wrap">
	
	
	<form action = "./apiTest">
		<input type="text" name="hospNm" value="병원명" onfocus="this.value='';">
		<input type="submit" value="검색">
	</form>

	
</div>
</body>
</html>