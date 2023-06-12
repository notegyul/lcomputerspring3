<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board List</title>
</head>
<style>
	table, div {
		boarder-collapse:collapse;
		margin:40px auto;
	}
	
	div {
		
	}
	table tr td {
		font-weight:700;
	}
	table tr td, table tr th {
		border:1px solid #818181;
		width:200px;
		text-align:center;
	}
	
	a {
		text-decoration:none;
		color:#000;
		font-weigth:700;
	}
	h1 {
		text-align:center;
	}
	
	ul{
		width:500px;
		height:50px;
		margin:10px auto;
	}
	li{
		list-style:none;
		width:50px;
		line-height:50px;
		border:1px solid #ededed;
		float:left;
		text-align:center;
		margin:0 5px;
		border-radius:5px;
	}
</style>

<body>
	<h1>게시글 목록</h1>
		<table>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
			</tr>
			
			<c:forEach items="${list}" var="bList" varStatus="status">
				<tr>
					<td>${status.count}</td>
					<td><a href="#">${bList.bTitle}</a></td>
					<td>${bList.bWriter}</td>
					<td>${bList.bDateTime}</td>
				</tr>
			</c:forEach>
		</table>
</body>
</html>