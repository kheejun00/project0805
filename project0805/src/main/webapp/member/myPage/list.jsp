<%@page import="dto.BoardDTO"%>
<%@page import="java.util.List"%>
<%@page import="dao.BoardDAO"%>
<%@page import="repository.BoardRepository"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
BoardRepository dao = new BoardDAO();
List<BoardDTO> list = dao.getBoardList((Integer)session.getAttribute("memberNo"));
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
        <th>제목    </th>
        <th>작성자  </th>
        <th>작성일시</th>
        <th>조회수  </th>
    </tr>
    
<%
for(BoardDTO dto: list){
	%>
	<tr>
		<td><%=dto.getBoardNo() %></td>
		<td style="text-align:left;">
		 <a href="../../community/view.jsp?boardNo=<%=dto.getBoardNo()%>"><%=dto.getTitle() %></a></td>
		<td><%=dto.getMemberNo() %></td>
		<td><%=dto.getRegtime() %></td>
		<td><%=dto.getHits() %></td>
	</tr>
<%
}
%>
</table>
<br>
<input type="button" value="이전" onclick="location.href='../../index.jsp'">
</body>
</html>