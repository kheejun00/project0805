<%@page import="repository.MemberRepository"%>
<%@page import="dao.MemberDAO"%>
<%@page import="dto.BoardDTO"%>
<%@page import="dao.BoardDAO"%>
<%@page import="repository.BoardRepository"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
BoardRepository bDao = new BoardDAO();
MemberRepository mDao = new MemberDAO();
int no = Integer.parseInt(request.getParameter("memberNo"));
System.out.println(no);
bDao.insertBoard(new BoardDTO(request.getParameter("title"),"날짜","수정일",0,
		no,request.getParameter("content")));
response.sendRedirect("../list.jsp");
%>