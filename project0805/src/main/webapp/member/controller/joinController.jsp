<%@page import="dto.MemberDTO"%>
<%@page import="dao.MemberDAO"%>
<%@page import="repository.MemberRepository"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");

String name = request.getParameter("name");
String birth = request.getParameter("birth");
String id = request.getParameter("id");
String nickname = request.getParameter("nickname");
String pw = request.getParameter("pw");
String tel = request.getParameter("tel");
String email = request.getParameter("email");
MemberDTO dto = new MemberDTO(name,birth,id,nickname,pw,tel,email);

String temp = null;
MemberRepository dao = new MemberDAO();

if(dao.join(dto)){
%>
<script>
<%

%>
	alert('회원가입 성공!');
	location.href='../../index.jsp';
</script>
<%          
} else {           
}
%>
<script>
	alert('회원가입 실패.');
	location.href='../../index.jsp';
</script>

