<%@page import="dto.MemberDTO"%>
<%@page import="dao.MemberDAO"%>
<%@page import="repository.MemberRepository"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
MemberRepository dao= new MemberDAO();
MemberDTO dto= dao.getMember((Integer)session.getAttribute("memberNo"));
%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>정보 수정</title>
    <link rel="icon" href="favicon.ico" type="image/x-icon">
    <link rel="stylesheet" href="css/style.css">
    <script src="js/ie.js"></script>
</head>
<body>
<form action="./controller/updateController.jsp"method="post">
<input type = "hidden" name="memberNo" value="<%=session.getAttribute("memberNo")%>">
<input type = "hidden" name="id" value="<%=dto.getId()%>">
이름:<input type = "text" name="name" value="<%=dto.getName()%>"><br>
생년월일:<input type = "text" name="birth" value="<%=dto.getBirth()%>"><br>
닉네임:<input type="text" name="nickname" value="<%=dto.getNickname()%>"><br>
비밀번호:<input type = "password" name="pw"><br>
전화번호:<input type = "text" name="tel" value="<%=dto.getTel()%>"><br>
이메일:<input type = "text" name="email" value="<%=dto.getEmail()%>"><br>
<input type="submit" value="수정">
</form>
</body>
</html>