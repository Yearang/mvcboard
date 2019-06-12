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
		int su = (Integer)request.getAttribute("result");
		if (su > 0) {
	%>
	<script>
		alert('수정성공')
		location.href = "list.do";
	</script>
	<%
		} else {
	%>
	<script>
		alert("수정실패");
		location.href = "list.do";
	</script>
	<%
		}
	%>
</body>
</html>