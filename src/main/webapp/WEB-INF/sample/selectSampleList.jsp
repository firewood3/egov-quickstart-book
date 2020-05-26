 
<%--
<%@page import="java.util.List"%>
<%@page import="egovframework.sample.service.impl.SampleDAOJDBC"%>
<%@page import="egovframework.sample.service.SampleVO"%> 
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<%
	// 세션에 저장된 목록 정보를 꺼낸다.
	// List<SampleVO> sampleList = (List) session.getAttribute("sampleList");

	// HttpServletRequest에 저장된 목록 정보를 꺼낸다.
	// List<SampleVO> sampleList = (List) request.getAttribute("sampleList");

	// 1. DB 연동 처리
	/*
	SampleVO vo = new SampleVO();
	SampleDAOJDBC sampleDAO = new SampleDAOJDBC();
	List<SampleVO> sampleList = sampleDAO.selectSampleList(vo);
	*/ 
	
	// 2. 응답 화면 구성
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SAMPLE 목록</title>
</head>
<body>
<center>
<h1>SAMPLE 목록</h1>

<!-- 검색 시작 -->
<form action="selectSampleList.do" method="post">
<table border="1", cellpadding="0" cellspacing="0" width="800" >
<tr>
	<td align="right">
		<select name="searchCondition">
			<c:forEach items="${conditionMap }" var="option">
				<option value="${option.value }" >${option.key} 
			</c:forEach>
		</select>
		<input name="searchKeyword" type="text"/>
		<input type="submit" value="검색"/>
	</td>
</tr>
</table>
</form>

<table border="1" cellpadding="0" cellspacing="0" width="800">
<tr>
	<th bgcolor="orange" width="60">아이디</th>
	<th bgcolor="orange" width="240">제목</th>
	<th bgcolor="orange" width="40">작성자</th>
	<th bgcolor="orange" width="60">등록일</th>
</tr>

<%-- <% for(SampleVO sample : sampleList) { %>
<tr>
	<td align="center"><a href="selectSample.jsp?id=<%= sample.getId() %>"><%= sample.getId() %></a></td>
	<td><%= sample.getTitle() %></td>
	<td align="center"><%= sample.getRegUser() %></td>
	<td align="center"><%= sample.getRegDate() %></td>
</tr>
<% } %> --%>

 
<c:forEach var="sample" items="${sampleList}">
<tr>
	<td align="center"><a href="selectSample.do?id=${sample.id}">${sample.id}</a></td>
	<td>${sample.title}</td>
	<td align="center">${sample.regUser}</td>
	<td align="center">${sample.regDate}</td>
</tr> 
</c:forEach>

</table>
<br>
<a href="insertSample.do">샘플 등록</a>	
</center>

<script>
	console.log("333");
</script>
</body>
</html>
