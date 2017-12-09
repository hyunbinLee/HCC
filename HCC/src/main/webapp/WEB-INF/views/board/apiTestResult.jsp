<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import = "com.crossit.hcc.controller.jdom" %>
<%@ page import = "org.jdom2.Document" %>
<%@ page import = "org.jdom2.*" %>
<%@ page import = "org.jdom2.input.*" %>
<%@ page import = "java.util.List" %>
<%@ page import = "java.util.Vector" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<%@ include file="../common/inc_common.jsp"%>
<%@ include file="../common/inc_header.jsp"%>

</head>

<!--  
	jdom jdom = new jdom();
	String hospNm = request.getParameter("hospNm");
	Vector v = new Vector();
	v = jdom.apiTest(hospNm);
	Element item = (Element)v.elementAt(0);
	String errMsg = item.getChildText("errMsg");
	String zipNo = " ";
	String lnmAdres = " "; 
-->


<body>


<div class="wrap">
	<!-- Top Menu -->
	<%@ include file="../common/inc_top.jsp"%>
	
	<tr>
    <c:forEach items="${list}" var="list"> 
    	
    	${list.yadmNm}
	
	</c:forEach>
	</tr>
	
	<%@ include file="../common/inc_right.jsp"%>
</div>
</body>
</html>