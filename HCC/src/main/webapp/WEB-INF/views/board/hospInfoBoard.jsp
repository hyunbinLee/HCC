<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>


<%@ include file="../common/inc_common.jsp"%>

<%@ include file="../common/inc_header.jsp"%>

<script type="text/javascript">  
    var nowpage = 1;
	
	function changePage(page) {
		search(page);
	}
	
	function search(page) {    
		
		//$("#nowpage").val(page);
		
		var form_data = $("#frm").serialize();
		
		$.ajax({
	       // beforeSend: function(jqXHR, settings){  return checkSession();     },    	// $('.loadingDiv').show();	},
	       // complete: function(jqXHR, textStatus){	$('.loadingDiv').hide();   }, 
	        complete: function(jqXHR, textStatus){   }, 
	        type: 'post',
	        dataType: "html",
	        url: './noticeList',
	        data: form_data,
	        success: function(data, textStatus , jqXHR){
				$('#list_div').html(data);
	        },
	        error: function(jqXHR, textStatus, error){
	        	alert(error) ;
	        } 
	    });  
	}
	
	$(function(){
		search(nowpage);
	});
	
		
</script> 

</head>
<body>
	<div class="wrap">

		<!-- Top Menu -->
		<%@ include file="../common/inc_top.jsp"%>
 
			
			<div id="list_div"></div>

		</div>
</body>
</html>
