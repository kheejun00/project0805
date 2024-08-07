<%@page import="dto.BoardDTO"%>
<%@page import="repository.BoardRepository"%>
<%@page import="dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String temp;
int no = Integer.parseInt((temp = request.getParameter("boardNo"))!=null?temp:"1");
BoardRepository dao = new BoardDAO();
BoardDTO dto= dao.getBoard(no);
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <style>
        table { width:680px; text-align:center; }
        th    { width:100px; background-color:cyan; }
        input[type=text], textarea { width:100%; }
    </style>
</head>
<body>

<form method="post" action="./controller/updateController.jsp">
<input type = "hidden" name = "boardNo" value = "<%=dto.getBoardNo() %>">
    <table>
        <tr>
            <th>제목</th>
            <td><input type="text" name="title"  maxlength="80"
                       value="<%=dto.getTitle()%>">
            </td>
        </tr>
        <tr>
            <th>내용</th>
            <td><textarea name="content" rows="10"><%=dto.getContent()%></textarea>
            </td>
        </tr>
    </table>

    <br>
    <input type="submit" value="저장">
    <input type="button" value="취소" onclick="history.back()">
</form>

</body>
</html>