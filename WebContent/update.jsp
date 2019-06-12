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
BoardDTO dto = (BoardDTO)request.getAttribute("dto");

%>
<form action="updateresult.do" method="post">
		<ul>
			<li><label for="empno">사원번호</label> <input type="text"
				name="empno" id="empno" required value=<%=dto.getEmpno() %> readonly="readonly"></li>
			<li><label for="ename">이름</label> <input type="text"
				name="ename" id="ename"required value = <%=dto.getEname() %>></li>
			<li><label for="job">직무</label> <input type="text" name="job"
				id="job" required value = <%=dto.getJob() %>></li>
			<li><label for="sal">연봉</label> <input type="text" name="sal"
				id="sal" required value =<%=dto.getSal() %>></li>
				<li>
				<input type="submit" value="수정">
				<input type="reset" value="취소">
				</li>
		</ul>
	</form>
</body>
</html>