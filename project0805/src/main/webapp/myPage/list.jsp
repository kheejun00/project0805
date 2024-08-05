<%@page import="model.Board"%>
<%@page import="java.util.List"%>
<%@page import="model.BoardDAO"%>
<%@page import="model.BoardCon"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
BoardCon dao = new BoardDAO();
List<Board> list = dao.getBoardList((Integer)session.getAttribute("memberNo"));
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
for(Board board : list){
	%>
	<tr>
		<td><%=board.getBoardNo() %></td>
		<td style="text-align:left;">
		 <a href="../community/view.jsp?boardNo=<%=board.getBoardNo()%>"><%=board.getTitle() %></a></td>
		<td><%=board.getMemberNo() %></td>
		<td><%=board.getRegtime() %></td>
		<td><%=board.getHits() %></td>
	</tr>
<%
}
%>
</table>
<br>
<input type="button" value="이전" onclick="location.href='../index.jsp'">
</body>
</html>