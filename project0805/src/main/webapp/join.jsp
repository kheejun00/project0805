<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원가입</title>
    <link rel="icon" href="favicon.ico" type="image/x-icon">
    <link rel="stylesheet" href="css/style.css">
    <script src="js/ie.js"></script>
</head>
<body>
<form action="joinController.jsp"method="post">
이름:<input type = "text" name="name"><br>
생년월일:<input type = "text" name="birth"><br>
아이디:<input type = "text" name="id"><br>
닉네임:<input type="text" name="nickname"><br>
비밀번호:<input type = "password" name="pw"><br>
전화번호:<input type = "text" name="tel"><br>
이메일:<input type = "text" name="email"><br>
<input type="submit" value="가입">
</form>
</body>
</html>