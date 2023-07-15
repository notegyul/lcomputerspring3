<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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
	.bTitleStyle{
		width: 500px;
	}
	
</style>

<body>
	<h1>게시글 목록</h1>
		<table>
			<tr>
				
				<th>글번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
			</tr>
			
			<c:forEach items="${list}" var="bList" varStatus="status">
				<tr>
					<td>${pagination.count - (pagination.pageNum + status.index)}</td>
					<td class="bTitleStyle"><a href="/readBoard/${bList.bId}">${bList.bTitle}</a></td>
					<td>${bList.bWriter}</td>
					<td>${bList.bDateTime}</td>
				</tr>
			</c:forEach>
		</table>
		
		<table>
			<tr>
				<td style="border:none;">
					<a href="/tryToWrite" style="width:70%;font-weight:700;border: 3px solid #68de7c;color:#68de7c;">
						새글쓰기 
					</a>
				</td>
			</tr>
		</table>
		<div>
			<ul>
			<c:choose>
				<c:when test="${pagination.prevPage <= pagination.startPage && pagination.prevPage > 0}">
					<li>
						<a href="/boardList/${pagination.prevPage}">
							◀
						</a>
					</li>
				
				</c:when>
			</c:choose>
			
			<c:forEach var="i" begin="${pagination.startPage}" end="${pagination.endPage}" step="1">
					
					<c:choose>
						<c:when test="${pagination.page == i}">
							<li style="background-color:#ededed;">
								<span>${i}</span>
							</li>
						</c:when>
						<c:when test="${pagination.page != i}">
							<li>
								<a href="/boardList/${i}">${i}</a>
							</li>
						</c:when>
					</c:choose>
				</c:forEach>
				<c:choose>
					<c:when test="${ pagination.nextPage <= pagination.lastPage }">
						<li style="">
							<a href="/boardList/${pagination.nextPage}">▶</a>
						</li>
					</c:when>
				</c:choose>
			</ul>
		</div>
</body>
</html>