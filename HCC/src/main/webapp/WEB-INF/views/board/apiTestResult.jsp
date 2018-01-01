<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import = "java.util.List" %>
<%@ page import = "java.util.Vector" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>


</head>

<body>


<div class="wrap">
	
	
	<tr>
	<form action = "./apiTest">
	
		<input type="hidden" name="star" value="${star}">
		<input type="hidden" name="type" value="${type}">
		<input type="hidden" name="title" value="${title}">
		<input type="hidden" name="content" value="${content}">
	
	    <c:forEach items="${list}" var="list"> 
	    <table>
	    <tr>
		    <td>
		    	${list}
		    	<input type="hidden" name="hospNm" value="${list}">
		    </td>
		    <td>
		    	<input type="submit" value="선택" id="reg_btn">
		    </td>
	    
	    
	    </tr>
		</table>
		</c:forEach>
		
		
	</form>
	</tr>

	
</div>
</body>
</html>