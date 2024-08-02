<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
.info {
	width: 416px;
	padding: 48px 48px 40px;
	border-radius: 16px;
	background-color: #fff;
	box-shadow: 0 16px 25px rgba(0, 0, 0, .1), 0 8px 10px rgba(0, 0, 0, .04);
	position: relative;
	text-align: center;
}
</style>



<body>

	<!--
	생일축하 메시지를 입력받을 받아, result페이지로 리디렉션 합니다.
	
	"년-월-일 메시지" 형태로 데이터를 변경하여
	result페이지에서는 생일축하 메시지를 1회성 출력해주세요.
	-->

	<div class="info">
	<form action="?" method="post">
		생년월일:<br> <input type="text" name="year" maxlength="4" size="4"
			placeholder="년(4자)"> <select name="month">
			<c:forEach var="i" begin="1" end="12">
				<option>${i }</option>
			</c:forEach>
		</select> <input type="text" name="day" maxlength="2" size="4" placeholder="일">
		<input type="text" name="msg" placeholder="축하 메시지"> <input
			type="submit" value="전송">
	</form>
	</div>
</body>
</html>