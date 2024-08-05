<%@page import="model.MemberDAO"%>
<%@page import="model.MemberCon"%>
<%@page import="model.MemberDTO"%>
<%@page import="model.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");

int memberNo = Integer.parseInt(request.getParameter("memberNo"));
String name = request.getParameter("name");
String birth = request.getParameter("birth");
String nickname = request.getParameter("nickname");
String pw = request.getParameter("pw");
String tel = request.getParameter("tel");
String email = request.getParameter("email");

Member member = new MemberDTO(memberNo, name, birth, nickname, pw, tel, email);
MemberCon mCon = new MemberDAO();
mCon.updateMember(member);
%>
<script>
alert("수정완료");
location.href="index.jsp";
</script>
