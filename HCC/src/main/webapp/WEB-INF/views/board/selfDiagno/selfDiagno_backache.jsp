<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>


<%@ include file="../../common/inc_common.jsp"%>

<%@ include file="../../common/inc_header.jsp"%>

<script>

	function div_q1(v) {
		if(v == "y") {
			document.getElementById('A').style.display = "";
			document.getElementById('result').value = "A";
			document.getElementById('but').style.display = "";
			document.getElementById('q2').style.display = "none";
			document.getElementById('q2').reset();
			document.getElementById('q3').style.display = "none";
			document.getElementById('q3').reset();
			document.getElementById('q4').style.display = "none";
			document.getElementById('q4').reset();
			document.getElementById('B').style.display = "none";
			document.getElementById('C').style.display = "none";
			document.getElementById('D').style.display = "none";
			document.getElementById('E').style.display = "none";
		} else if(v == "n") {
			document.getElementById('q2').style.display = "";
			document.getElementById('but').style.display = "none";
			document.getElementById('q3').style.display = "none";
			document.getElementById('q3').reset();
			document.getElementById('q4').style.display = "none";
			document.getElementById('q4').reset();
			document.getElementById('A').style.display = "none";
			document.getElementById('B').style.display = "none";
			document.getElementById('C').style.display = "none";
			document.getElementById('D').style.display = "none";
			document.getElementById('E').style.display = "none";
		}
	}
	
	function div_q2(v) {
		if(v == "y") {
			document.getElementById('q4').style.display = "";
			document.getElementById('q3').style.display = "none";
			document.getElementById('q3').reset();
			document.getElementById('q4').reset();
			document.getElementById('A').style.display = "none";
			document.getElementById('B').style.display = "none";
			document.getElementById('C').style.display = "none";
			document.getElementById('D').style.display = "none";
			document.getElementById('E').style.display = "none";
			document.getElementById('but').style.display = "none";
		} else if(v == "n") {
			document.getElementById('q3').style.display = "";
			document.getElementById('q3').reset();
			document.getElementById('but').style.display = "none";
			document.getElementById('q4').style.display = "none";
			document.getElementById('q4').reset();
			document.getElementById('A').style.display = "none";
			document.getElementById('B').style.display = "none";
			document.getElementById('C').style.display = "none";
			document.getElementById('D').style.display = "none";
			document.getElementById('E').style.display = "none";
		}
	}
	
	function div_q3(v) {
		if(v == "y") {
			document.getElementById('C').style.display = "";
			document.getElementById('result').value = "C";
			document.getElementById('but').style.display = "";
			document.getElementById('q4').style.display = "none";
			document.getElementById('q4').reset();
			document.getElementById('A').style.display = "none";
			document.getElementById('B').style.display = "none";
			document.getElementById('D').style.display = "none";
			document.getElementById('E').style.display = "none";
		} else if(v == "n") {
			document.getElementById('B').style.display = "";
			document.getElementById('result').value = "B";
			document.getElementById('but').style.display = "";
			document.getElementById('q4').style.display = "none";
			document.getElementById('q4').reset();
			document.getElementById('A').style.display = "none";
			document.getElementById('C').style.display = "none";
			document.getElementById('D').style.display = "none";
			document.getElementById('E').style.display = "none";
		}
	}
	
	function div_q4(v) {
		if(v == "y") {
			document.getElementById('E').style.display = "";
			document.getElementById('result').value = "E";
			document.getElementById('but').style.display = "";
			document.getElementById('q3').style.display = "none";
			document.getElementById('q3').reset();
			document.getElementById('A').style.display = "none";
			document.getElementById('B').style.display = "none";
			document.getElementById('C').style.display = "none";
			document.getElementById('D').style.display = "none";
		} else if(v == "n") {
			document.getElementById('D').style.display = "";
			document.getElementById('result').value = "D";
			document.getElementById('but').style.display = "";
			document.getElementById('q3').style.display = "none";
			document.getElementById('q3').reset();
			document.getElementById('A').style.display = "none";
			document.getElementById('B').style.display = "none";
			document.getElementById('C').style.display = "none";
			document.getElementById('E').style.display = "none";
		}
	}

</script>
</head>
<body>
	<div class="wrap">
	
	<form action="./insertSelfDiagno_backache">
	    <!-- Top Menu -->
		<%@ include file="../../common/inc_top.jsp"%>
		
		<div id="q1">
		<tr>
			<td>
				Q1. 요통과 함께 다음 항목 중 한가지라도 동반되는 사항이 있습니까?
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
				<input name="q1" type="radio" value="y" onclick="div_q1(this.value);"/>
				<input name="q1" type="radio" value="n" onclick="div_q1(this.value);"/>
			</td>
		</tr>
		</div>
		
		<div id="q2" style="display:none">
		<tr>
			<td>
				Q2. 엉덩이나 다리 쪽으로 뻗치는 저린 증상(방사통)
			</td>
			<td>
				<input name="q2" type="radio" value="y" onclick="div_q2(this.value);"/>
				<input name="q2" type="radio" value="n" onclick="div_q2(this.value);"/>
			</td>
		</tr>
		</div>
		
		<div id="q3" style="display:none">
		<tr>
			<td>
				Q3. 전신질환 의심 항목
						- 50세 이상
						- 발열/오한
						- 체중감소
						- 당뇨가 있는 경우
						- 암 병력이 있는 경우
						- 장기간 스테로이드를 사용한 경우
						- 혈뇨
			</td>
			<td>
				<input name="q3" type="radio" value="y" onclick="div_q3(this.value);"/>
				<input name="q3" type="radio" value="n" onclick="div_q3(this.value);"/>
			</td>
		</tr>
		</div>
		
		<div id="q4" style="display:none">
		<tr>
			<td>
				Q4. 회음부 감각 저하 또는 빈뇨, 요실금, 변실금
			</td>
			<td>
				<input name="q4" type="radio" value="y" onclick="div_q4(this.value);"/>
				<input name="q4" type="radio" value="n" onclick="div_q4(this.value);"/>
			</td>
		</tr>
		</div>
		
		<div id="A" style="display:none">
		<tr>
			<td>
				빨리 의사의 진료를 받으시기 바랍니다.
			</td>
		</tr>
		</div>
		
		<div id="B" style="display:none">
		<tr>
			<td>
				단순 요통(60%)
			</td>
		</tr>
		</div>
		
		<div id="C" style="display:none">
		<tr>
			<td>
				복합성 요통(37%)
				근골격계 통증(33%)
				전신질환(4%)
			</td>
		</tr>
		</div>
		
		<div id="D" style="display:none">
		<tr>
			<td>
				신경근병(3%)
				허리 디스크(추간판 탈출증)
				척추강 협착증
			</td>
		</tr>
		</div>
		
		<div id="E" style="display:none">
		<tr>
			<td>
				응급상황(1% 미만)
				빨리 의사를 방문하시기 바랍니다.
			</td>
		</tr>
		</div>
		
		<input type="hidden" name="result" id="result">
		
		<div id="but" style="display:none">
			<button type="button" onclick="javascript:location.href='./selfDiagno_backache'"> 다시 </button>
			<input type="submit" value="저장" id="reg_btn">
		</div>
		
		
	</form>
	</div>
			

</body>
</html>