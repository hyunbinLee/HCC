<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>


<%@ include file="../../common/inc_common.jsp"%>

<%@ include file="../../common/inc_header.jsp"%>

</head>
<body>
	<div class="wrap">
	
	<form action="./backache">
	    <!-- Top Menu -->
		<%@ include file="../../common/inc_top.jsp"%>
		
		<tr>
			<td>
				요통과 함께 다음 항목 중 한가지라도 동반되는 사항이 있습니까?
						- 20세 미만 또는 55세 이상에서 처음 시작된 극심한 통증
						- 4주 이상의 치료에도 나아지지 않는 경우
						- 피로감 등 전신 증상이 있는 경우
						- 38도이상의 발열이 있는 경우
						- 최근 외상이 있은 후 시작된 통증
						- 지속적으로 악화되고 쉬어도 나아지지 않는 경우
						- 누운 자세에서 악화되는 허리통증
						- 가슴 부위(흉부) 통증
						- 특정 척추부위의 심한 국소 통증
						- 척추 변형이 있는 경우
						- 골다공증 병력이 있는 경우
			</td>
			<td>
				<input name="q1" type="radio" value="예" />
				<input name="q1" type="radio" value="아니오" />
			</td>
		</tr>
		<tr>
			<td>
				엉덩이나 다리 쪽으로 뻗치는 저린 증상(방사통)
			</td>
			<td>
				<input name="q2" type="radio" value="예" />
				<input name="q2" type="radio" value="아니오" />
			</td>
		</tr>
		<tr>
			<td>
				전신질환 의심 항목
						- 50세 이상
						- 발열/오한
						- 체중감소
						- 당뇨가 있는 경우
						- 암 병력이 있는 경우
						- 장기간 스테로이드를 사용한 경우
						- 혈뇨
			</td>
			<td>
				<input name="q3" type="radio" value="예" />
				<input name="q3" type="radio" value="아니오" />
			</td>
		</tr>
		<tr>
			<td>
				회음부 감각 저하 또는 빈뇨, 요실금, 변실금
			</td>
			<td>
				<input name="q4" type="radio" value="예" />
				<input name="q4" type="radio" value="아니오" />
			</td>
		</tr>
	</form>
	</div>
			

</body>
</html>