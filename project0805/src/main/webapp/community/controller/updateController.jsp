<%@page import="repository.BoardRepository"%>
<%@page import="dto.BoardDTO"%>
<%@page import="dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
BoardRepository dao = new BoardDAO();
dao.updateBoard(Integer.parseInt(request.getParameter("boardNo")),
request.getParameter("title"),
request.getParameter("content"));
response.sendRedirect("../list.jsp");
%>
