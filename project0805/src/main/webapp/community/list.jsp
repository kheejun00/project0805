<%@page import="dto.BoardDTO"%>
<%@page import="dao.BoardDAO"%>
<%@page import="dao.MemberDAO"%>
<%@page import="repository.MemberRepository"%>
<%@page import="repository.BoardRepository"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
BoardRepository bDao = new BoardDAO();
MemberRepository mDao = new MemberDAO();
List<BoardDTO> list = bDao.getBoardList();
Object sessionNo = session.getAttribute("memberNo");
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
<%if(sessionNo==null){ %>
<button onclick="location.href='../login.jsp'">로그인</button>
<%} %>

<table>
    <tr>
        <th>번호    </th>
        <th>제목    </th>
        <th>작성자</th>
        <th>작성일시</th>
        <th>최근 수정된 날짜</th>
        <th                >조회수  </th>
    </tr>
    
<%
for(BoardDTO dto : list){
	%>
	<tr>
		<td><%=dto.getBoardNo() %></td>
		<td style="text-align:left;">
		 <a href="view.jsp?boardNo=<%=dto.getBoardNo()%>"><%=dto.getTitle() %></a></td>
		<td><%=mDao.getMember(dto.getMemberNo()).getNickname() %></td>
		<td><%=dto.getRegtime() %></td>
		<td><%=dto.getUpRegtime() %></td>
		<td><%=dto.getHits() %></td>
	</tr>
<%
}
%>
</table>
<br>
<input type="button" value="글쓰기" onclick="location.href='insert.jsp'" <%=sessionNo==null?"disabled":null %>>
<input type="button" value="이전" onclick="location.href='../index.jsp'">
</body>
</html>