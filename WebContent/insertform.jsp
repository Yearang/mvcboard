<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href = "http://localhost:8080/mvcboard2/css/main.css">
</head>
<body>
	<form action="insertresult.do" method="post">
		<ul>
			<li><label for="empno">사원번호</label> <input type="text"
				name="empno" id="empno" required></li>
			<li><label for="ename">이름</label> <input type="text"
				name="ename" id="ename"required></li>
			<li><label for="job">직무</label> <input type="text" name="job"
				id="job" required></li>
			<li><label for="sal">연봉</label> <input type="text" name="sal"
				id="sal" required></li>
				<li>
				<input type="submit" value="추가">
				<input type="reset" value="취소">
				</li>
		</ul>
	</form>
</body>
</html>