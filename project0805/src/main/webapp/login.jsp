<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>로그인</title>
    <link rel="icon" href="favicon.ico" type="image/x-icon">
    <link rel="stylesheet" href="css/style.css">
    <script src="js/ie.js"></script>
</head>
<body>

	<form action="loginController.jsp" method="post">
	아이디:<input type = "text" name="id"><br>
	비밀번호:<input type = "password" name="pw"><br>
	<input type="submit" value="로그인">
	<input type="button" value="회원가입" onClick="location.href='join.jsp'">
	<input type="button" value="이전" onClick="history.back()">
	</form>
</body>

</html>