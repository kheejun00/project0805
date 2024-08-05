<%@page import="model.MemberCon"%>
<%@page import="model.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
MemberCon dao = new MemberDAO();
String id = request.getParameter("id");
String pw = request.getParameter("pw");
%>
<%
if(dao.login(id,pw)){
	int no = dao.getMember(id).getMemberNo();
	session.setAttribute("memberNo", no);
%>
	<script>
	alert('로그인 성공.');
	location.href='index.jsp';
	</script>
<%          
} else {           
}
%>
<script>
	alert('로그인 실패.');
	location.href='index.jsp';
</script>

