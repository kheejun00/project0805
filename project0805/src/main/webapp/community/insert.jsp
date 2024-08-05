<%@page import="model.MemberCon"%>
<%@page import="model.MemberDAO"%>
<%@page import="model.BoardDTO"%>
<%@page import="model.BoardDAO"%>
<%@page import="model.BoardCon"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
BoardCon bCon = new BoardDAO();
MemberCon mCon = new MemberDAO();
int no = Integer.parseInt(request.getParameter("memberNo"));
System.out.println(no);
bCon.insertBoard(new BoardDTO(request.getParameter("title"),"날짜","수정일",0,
		no,request.getParameter("content")));
response.sendRedirect("list.jsp");
%>