<%@page import="dao.MemberDAO"%>
<%@page import="repository.MemberRepository"%>
<%@page import="dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");

int memberNo = Integer.parseInt(request.getParameter("memberNo"));
String name = request.getParameter("name");
String birth = request.getParameter("birth");
String nickname = request.getParameter("nickname");
String id = request.getParameter("id");
String pw = request.getParameter("pw");
String tel = request.getParameter("tel");
String email = request.getParameter("email");

MemberDTO dto = new MemberDTO(memberNo, name, birth, nickname, pw, tel, email);
MemberRepository dao = new MemberDAO();
if(id!=null&&pw!=null&&dao.login(id, pw)){
	dao.updateMember(dto);
%>
	<script>
		alert("수정완료");
		location.href='../../index.jsp';
	</script>
<%
}else{
%>
	<script>
		alert("비밀번호 불일치");
		history.back();
	</script>
<%
}
%>
