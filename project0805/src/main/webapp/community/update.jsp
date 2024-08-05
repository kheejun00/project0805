<%@page import="model.BoardCon"%>
<%@page import="model.BoardDTO"%>
<%@page import="model.BoardDAO"%>
<%@page import="model.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
BoardCon dao = new BoardDAO();
dao.updateBoard(Integer.parseInt(request.getParameter("boardNo")),
request.getParameter("title"),
request.getParameter("content"));
response.sendRedirect("list.jsp");
%>
