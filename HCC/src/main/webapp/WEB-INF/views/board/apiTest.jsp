<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="kr">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script>
	function sendData() {
		opener.document.getElementById("hospNm").value = encodeURI(document.getElementById("hospNm").value);
		window.close();
	}

</script>

</head>
<body>

<div class="wrap">
	
	<tr>
	<form action = "./apiTest" method="get">
		<input type="hidden" name="star" value="${star}">
		<input type="hidden" name="type" value="${type}">
		<input type="hidden" name="title" value="${title}">
		<input type="hidden" name="content" value="${content}">
	
		<input type="text" name="hospNm" id="hospNm" placeholder="병원명"
			<c:choose>
 		 	<c:when test="${hospNm==null}">value=""</c:when>
 		 	<c:otherwise> value="${hospNm}"</c:otherwise>
 		 	</c:choose>
		>
		<input type="submit" value="검색">
	</form>
	</tr>
	
	
	<tr>
	<form name = "form" method="get">
		<input type="hidden" name="star" value="${star}">
		<input type="hidden" name="type" value="${type}">
		<input type="hidden" name="title" value="${title}">
		<input type="hidden" name="content" value="${content}">
	
	    <c:forEach items="${list}" var="hosp"> 
	    <table>
	    <tr>
		    <td>
		    	${hosp}
		    	<input type="hidden" name="hosp" id="hosp" value="${hosp}">
		    </td>
		    <td>
		    	<input type="button" value="선택" id="reg_btn" onclick="sendData();">
		    </td>
	    </tr>
		</table>
		</c:forEach>
	</form>
	</tr>
		
	<c:if test="${page==1 || page == null}">
		<button type="button"
			onclick="javascript:location.href='./apiTest?page=1&hospNm=${hospNm}'">처음
		</button>
		<button type="button"
			onclick="javascript:location.href='./apiTest?page=1&hospNm=${hospNm}">이전</button>
	</c:if>
	<c:if test="${page>1}">
		<button type="button"
			onclick="javascript:location.href='./apiTest?page=1&hospNm=${hospNm}'">처음
		</button>
		<button type="button"
			onclick="javascript:location.href='./apiTest?page=${page-1}&hospNm=${hospNm}'">이전
		</button>
	</c:if>	
	
	<!---------------- 페이지 넘버링 ----------------->
	<c:forEach begin="${startPage }" end="${endPage }" var="pages">
		<a href="apiTest?page=${pages }&hospNm=${hospNm}">${pages }</a>
	</c:forEach>	
	<c:if test="${page != lastPage }">
		<button type="button"
			onclick="javascript:location.href='./apiTest?page=${page+1}&hospNm=${hospNm}'">
			다음 <i class="fa fa-angle-right" aria-hidden="true"></i>
		</button>
	</c:if>
	<button type="button"
		onclick="javascript:location.href='./apiTest?page=${lastPage}&hospNm=${hospNm}'">
		끝 <i class="fa fa-angle-double-right" aria-hidden="true"></i>
	</button>
	<br />	
	
	

</div>
</body>
</html>