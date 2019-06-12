<%@page import="com.bitcamp.dto.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		BoardDTO dto = (BoardDTO) request.getAttribute("dto");
		if (dto == null) {
	%>
	해당 자료가 없습니다.
	<%
		} else {
	%>
	empno :<%=dto.getEmpno()%><br> ename :<%=dto.getEname()%><br>
	job :<%=dto.getJob()%><br> sal :<%=dto.getSal()%><br>
	<%
		}
	%>
	<a href="del.do?empno=<%=dto.getEmpno()%>">삭제</a>
	<a href="update.do?empno=<%=dto.getEmpno()%>">수정</a>
	<a href="list.do">목록</a>
</body>
</html>