/**
 * 
 */

//var token = $("meta[name='_csrf']").attr("content");
//var header = $("meta[name='_csrf_header']").attr("content");
//
//$(function() {
//	$(document).ajaxSend(function(e, xhr, options) {
//		xhr.setRequestHeader(header, token);
//	});
//});

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

/**
 * 
 */

$(function() {// 아이디 중복 확인
	$("#regi_id_auth").bind("click", function() {
		var id = $("#user_id").val();

		$.ajax({
			type : "GET",
			data : {
				"id" : id
			},
			dataType : "json",
			url : "/hcc/idCheck",
			success : function(data) {

				if (data == false) {
					alert("사용 할 수 있는 아이디 입니다.");
					$("#dupCheck").val("true");
				} else
					alert("사용 할 수 없는 아이디 입니다.");
			},
			error : function(request, status, error) {
				alert("code1 = " + request.status + " error1 = " + error); // 실패 시 처리

			}
		});
	});
});

$(function() {// 이메일 전송
	$("#regi_auth").bind("click", function() {

		var email = $("#regi_email_f").val() + "@" + $("#regi_email_b").val();
		$.ajax({
			type : "GET",
			dataType : "json",
			data : {
				"email" : email
			},
			url : "/hcc/regiMail",
			success : function(data) {

				if (data == true)
					alert("이메일이 성공적으로 전송되었습니다.");
				else
					alert("이메일 전송 실패");

			},
			error : function(request, status, error) {
				alert("code2 = " + request.status + " error2 = " + error); // 실패 시
																			// 처리

			}
		});
	});
});

$(function() {// 이메일 인증번호 확인
	$("#regi_auth_confirm").bind("click", function() {

		var code = $("#input_code").val();

		$.ajax({
			type : "GET",
			dataType : "json",
			data : {
				"code" : code
			},
			url : "/hcc/regiMail_check",
			success : function(data) {

				if (data == true) {
					alert("이메일 인증이 완료 되었습니다.");
					$("#authCheck").val("true");

				} else
					alert("이메일 인증코드가 다릅니다.");

			},
			error : function(request, status, error) {
				alert("code3 = " + request.status + " error3 = " + error); // 실패 시
																			// 처리

			}
		});
	});
});
