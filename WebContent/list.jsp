<%@page import="com.bitcamp.dto.BoardDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>번호</th>
				<th>이름</th>
				<th>직책</th>
				<th>급여</th>
			</tr>
		</thead>
		<tbody>
			<%
				List<BoardDTO> list = (List<BoardDTO>) request.getAttribute("list");

				if (list == null || list.size() == 0) {
			%>
			<td>자료없음</td>
			<%
				} else {
					for (int i = 0; i < list.size(); i++) {
						BoardDTO dto = list.get(i);
			%>
			<tr>
				<td><%=dto.getEmpno()%></td>
				<td><a href="detail.do?empno=<%=dto.getEmpno()%>"><%=dto.getEname()%></a></td>
				<td><%=dto.getJob()%></td>
				<td><%=dto.getSal()%></td>
			</tr>
			<%
				}
				}
			%>
		</tbody>
	</table>
	<a href = "insert.do">추가</a>
</body>
</html>