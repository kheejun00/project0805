<%@page import="dto.MemberDTO"%>
<%@page import="repository.MemberRepository"%>
<%@page import="dao.MemberDAO"%>
<%@page import="java.util.List"%>
<%@page import="dao.BoardDAO"%>
<%@page import="repository.BoardRepository"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
MemberRepository dao = new MemberDAO();
List<MemberDTO> list = dao.getMembers();
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
for(MemberDTO dto: list){
	%>
	<tr>
		<td><%=dto.getMemberNo() %></td>
		<td><%=dto.getId()%></td>
		<td><%=dto.getNickname() %></td>
		<td><%=dto.getTel() %></td>
		<td><%=dto.getEmail() %></td>
	</tr>
<%
}
%>
</table>
<br>
<input type="button" value="이전" onclick="location.href='../../index.jsp'">
</body>
</html>