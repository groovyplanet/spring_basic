<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<c:forEach var="vo" items="${list }" varStatus="a"> 
<!-- varStatus(카운트와 인덱스를 받아옴)${a.index } ${a.count } -->
${vo.sno}
${vo.name }
${vo.kor }
${vo.eng }
${vo.math }
<button type="button" onclick="location.href='deleteScore?sno=${vo.sno}';">삭제</button>

<br>
</c:forEach>
<a href="scoreRegist">추가 등록하기</a>

</body>
</html>