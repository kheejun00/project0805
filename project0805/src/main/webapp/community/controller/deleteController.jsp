<%@page import="dao.BoardDAO"%>
<%@page import="repository.BoardRepository"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
BoardRepository dao = new BoardDAO();
dao.deleteBoard(Integer.parseInt(request.getParameter("boardNo")));
response.sendRedirect("../list.jsp");
%>