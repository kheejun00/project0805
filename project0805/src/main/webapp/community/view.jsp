<%@page import="model.MemberCon"%>
<%@page import="model.MemberDAO"%>
<%@page import="model.Board"%>
<%@page import="model.BoardDAO"%>
<%@page import="model.BoardCon"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <style>
        table { width:680px; text-align:center; }
        th    { width:100px; background-color:cyan; }
        td    { text-align:left; border:1px solid gray; }
    </style>
</head>
<body>


<table>
<%
String temp = null;
int no = (temp = request.getParameter("boardNo"))==null?1:Integer.parseInt(temp);
int memberNo = 0;
if(session.getAttribute("memberNo")!=null){
	memberNo = (Integer)session.getAttribute("memberNo");
}
BoardCon bCon = new BoardDAO();
MemberCon mCon = new MemberDAO();
bCon.increaseHits(no);
Board board = bCon.getBoard(no);
%>
    <tr>
        <th>제목</th>
        <td><%=board.getTitle() %></td>
    </tr>
    <tr>
        <th>작성자</th>
        <td><%=mCon.getMember(board.getMemberNo()).getNickname()%></td>
    </tr>
    <tr>
        <th>작성일시</th>
        <td><%=board.getRegtime() %></td>
    </tr>
    <tr>
        <th>최근 수정된 날짜</th>
        <td><%=board.getUpRegtime() %></td>
    </tr>
    <tr>
        <th>조회수</th>
        <td><%=board.getHits() %></td>
    </tr>
    <tr>
        <th>내용</th>
        <td><%=board.getContent() %></td>
    </tr>
</table>

<br>
<input type="button" value="목록보기" onclick="location.href='list.jsp'">
<%
if(bCon.isUpdatable(no, memberNo)){
%>
<input type="button" value="수정"
       onclick="location.href='write2.jsp?boardNo=<%=board.getBoardNo()%>'">
<input type="button" value="삭제"
       onclick="location.href='delete.jsp?boardNo=<%=board.getBoardNo()%>'">
       
<%} %>

</body>
</html>
