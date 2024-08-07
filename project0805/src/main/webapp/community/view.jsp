<%@page import="dto.BoardDTO"%>
<%@page import="repository.MemberRepository"%>
<%@page import="dao.MemberDAO"%>
<%@page import="dao.BoardDAO"%>
<%@page import="repository.BoardRepository"%>
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
int bNo = (temp = request.getParameter("boardNo"))==null?1:Integer.parseInt(temp);
int mNo = 0;
if(session.getAttribute("memberNo")!=null){
	mNo = (Integer)session.getAttribute("memberNo");
}
BoardRepository bDao = new BoardDAO();
MemberRepository mDao = new MemberDAO();
bDao.increaseHits(bNo);
BoardDTO dto = bDao.getBoard(bNo);
%>
    <tr>
        <th>제목</th>
        <td><%=dto.getTitle() %></td>
    </tr>
    <tr>
        <th>작성자</th>
        <td><%=mDao.getMember(dto.getMemberNo()).getNickname()%></td>
    </tr>
    <tr>
        <th>작성일시</th>
        <td><%=dto.getRegtime() %></td>
    </tr>
    <tr>
        <th>최근 수정된 날짜</th>
        <td><%=dto.getUpRegtime() %></td>
    </tr>
    <tr>
        <th>조회수</th>
        <td><%=dto.getHits() %></td>
    </tr>
    <tr>
        <th>내용</th>
        <td><%=dto.getContent() %></td>
    </tr>
</table>

<br>
<input type="button" value="목록보기" onclick="location.href='list.jsp'">
<%
if(bDao.isWriter(bNo, mNo) || mDao.isAdmin(mNo)){
%>
<input type="button" value="수정"
       onclick="location.href='update.jsp?boardNo=<%=dto.getBoardNo()%>'">
<input type="button" value="삭제"
       onclick="location.href='./controller/deleteController.jsp?boardNo=<%=dto.getBoardNo()%>'">
       
<%} %>

</body>
</html>
