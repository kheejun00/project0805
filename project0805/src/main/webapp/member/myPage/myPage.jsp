<%@page import="dto.MemberDTO"%>
<%@page import="dao.MemberDAO"%>
<%@page import="repository.MemberRepository"%>
<%@page import="repository.BoardRepository"%>
<%@page import="dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
MemberRepository dao = new MemberDAO();
MemberDTO dto = null;
int mNo = 0;
if(session.getAttribute("memberNo")!=null){
	mNo = (Integer)session.getAttribute("memberNo");
	dto = dao.getMember(mNo);
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
if(dto==null){
%>
게시판 번호에 해당하는 글이 없음
<%
}else if(dao.isAdmin(mNo)){ 
%>
<input type="button" value="유저 정보 조회" onClick="location.href='./userList.jsp'">
<%}else{ %>
이름:<%=dto.getName() %><br>
생년월일:<%=dto.getBirth() %><br>
아이디:<%=dto.getId() %><br>
닉네임:<%=dto.getNickname() %><br>
비밀번호:<%=dto.getPw() %><br>
전화번호:<%=dto.getTel() %><br>
이메일:<%=dto.getEmail() %><br>
<input type = "button" value="내 정보 수정" onClick="location.href='../update.jsp'">
<%} %>
<input type="button" value="내 작성글 확인" onClick="location.href='./list.jsp'">
<input type="button" value="이전" onClick="location.href='../../index.jsp'">
</body>
</html>