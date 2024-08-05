<%@page import="model.BoardDAO"%>
<%@page import="model.BoardCon"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
BoardCon bCon = new BoardDAO();
bCon.deleteBoard(Integer.parseInt(request.getParameter("boardNo")));
response.sendRedirect("list.jsp");
%>