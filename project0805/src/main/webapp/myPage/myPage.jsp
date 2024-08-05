<%@page import="model.Member"%>
<%@page import="model.MemberDAO"%>
<%@page import="model.MemberCon"%>
<%@page import="model.Board"%>
<%@page import="model.BoardCon"%>
<%@page import="model.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
MemberCon dao = new MemberDAO();
Member member = null;
int memberNo = 0;
if(session.getAttribute("memberNo")!=null){
	memberNo = (Integer)session.getAttribute("memberNo");
	member = dao.getMember(memberNo);
}
%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>게시판 </title>
    <link rel="icon" href="favicon.ico" type="image/x-icon">
    <link rel="stylesheet" href="css/style.css">
    <script src="js/ie.js"></script>
</head>
<body>
<%
if(member==null){
%>
게시판 번호에 해당하는 글이 없음
<%
}else if(dao.isAdmin(memberNo)){ 
%>
<input type="button" value="유저 정보 조회" onClick="location.href='./userList.jsp'">
<%}else{ %>
이름:<%=member.getName() %><br>
생년월일:<%=member.getBirth() %><br>
아이디:<%=member.getId() %><br>
닉네임:<%=member.getNickname() %><br>
비밀번호:<%=member.getPw() %><br>
전화번호:<%=member.getTel() %><br>
이메일:<%=member.getEmail() %><br>
<input type = "button" value="내 정보 수정" onClick="location.href='../update.jsp'">
<%} %>
<input type="button" value="내 작성글 확인" onClick="location.href='./list.jsp'">
<input type="button" value="이전" onClick="location.href='../index.jsp'">
</body>
</html>