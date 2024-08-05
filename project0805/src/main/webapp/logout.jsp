<%@page import="model.MemberCon"%>
<%@page import="model.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
session.removeAttribute("memberNo");
%>
<script>
	alert('로그아웃 되었습니다.');
	location.href='index.jsp';
</script>  

