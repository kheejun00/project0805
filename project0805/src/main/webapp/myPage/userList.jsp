<%@page import="model.Member"%>
<%@page import="model.MemberCon"%>
<%@page import="model.MemberDAO"%>
<%@page import="model.Board"%>
<%@page import="java.util.List"%>
<%@page import="model.BoardDAO"%>
<%@page import="model.BoardCon"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
MemberCon mCon = new MemberDAO();
List<Member> list = mCon.getMembers();
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <style>
        table     { width:680px; text-align:center; }
        th        { background-color:cyan; }
                    
        a:link    { text-decoration:none; color:blue; }
        a:visited { text-decoration:none; color:gray; }
        a:hover   { text-decoration:none; color:red;  }
    </style>
</head>
<body>
<table>
    <tr>
        <th>번호    </th>
        <th>아이디    </th>
        <th>닉네임  </th>
        <th>전화번호</th>
        <th>이메일  </th>
    </tr>
    
<%
for(Member member : list){
	%>
	<tr>
		<td><%=member.getMemberNo() %></td>
		<td><%=member.getId()%></td>
		<td><%=member.getNickname() %></td>
		<td><%=member.getTel() %></td>
		<td><%=member.getEmail() %></td>
	</tr>
<%
}
%>
</table>
<br>
<input type="button" value="ㅇ" onclick="location.href='../community/write.jsp'">
<input type="button" value="이전" onclick="location.href='../index.jsp'">
</body>
</html>