<%@page import="model.MemberDTO"%>
<%@page import="model.Member"%>
<%@page import="model.MemberDAO"%>
<%@page import="model.MemberCon"%>
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
Member member = new MemberDTO(name,birth,id,nickname,pw,tel,email);

String temp = null;
MemberCon dao = new MemberDAO();

if(dao.join(member)){
%>
<script>
<%

%>
	alert('회원가입 성공!');
	location.href='index.jsp';
</script>
<%          
} else {           
}
%>
<script>
	alert('회원가입 실패.');
	location.href='index.jsp';
</script>

