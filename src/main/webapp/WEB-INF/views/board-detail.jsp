<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>

	table {
		border-collpase:collapse;
	}
	table tr th {
		font-weigth:700;
	}
	table tr td, table tr, th {
		border:1px solid #818181;
		width:100px;
		text-align:center;
	}

	a {
		text-decoration:none;
		color:#000;
		font-weight:700;
		border:none;
		cursor:pointer;
		padding:10px;
		display:inline-block;
		text-align:center;		
	}
</style>

<body>
	<h1>게시글 상세 페이지입니다.</h1>
		
	<table border="1" >
		<colgroup>
			<col width="15%" /> <col width="35%" />
			<col width="15%" /> <col width="*" />

		</colgroup>
		
		<tr>
			<td>BID</td><td>${board.bId}</td>
			<td>작성자</td><td>${board.bWriter}</td>
		</tr>
		<tr>
			
			<td>작성일</td><td>${board.bDateTime}</td>
			<td>조회수</td><td></td>
		</tr>
		<tr>
			<td>제목</td><td colspan="3">${board.bTitle}</td>
		</tr>
		<tr>
			<td >내용</td>
			<td colspan="3" height="100" >${board.bContent}</td>
		</tr>
	</table>
	<br />
	<br />
	<br />
	<table>
		<tr>
			<td style="border:none;">
				<a href="/replyToOriginBoard/${board.bGroup}/${board.bOrder}/${board.bDepth}" style="width:70%;font-weight:700;border: 3px solid orange;color:grey;">
					답글
				</a>
			</td>
			
			<td style="border:none;">
				<a href="/boardList" style="width:70%;font-weight:700;border: 3px solid brown;color:brown;">
					글 목록
				</a>
			</td>	
			<c:if test="${author eq currentUser}">
				<td style="border:none;">
					<a href="/tryToEditBoard/${board.bId}" style="width:70%;font-weight:700;border: 3px solid #77af9c;color: #1e6b7b;">
	    				수정
	    			</a>
			</c:if>
			<c:if test="${author eq currentUser or userAuthContainsAdmin}">
				<td style="border:none;">
					<a href="/deleteBoard/${board.bId}" style="width:70%;font-weight:700;border: 3px solid red;color:black;">
						삭제
					</a>				
				</td>
			</c:if>

		</tr>	
	</table>	
	<br />
	<br />
	
	<form action="/boardComment" method="post">
		<input type="hidden" name="bId" value="${board.bId}"/>
		<input type="hidden" name="uId" value="${board.username}"/>
		
		<textarea name="putOnComment" rows="1" cols="55" placeholder="댓글 입력"></textarea>
		<button type="submit">등록</button>
	</form>
	
	<br />	
	<br />	
	
	<table>
		<tr>
			<th>내용</th>			
			<th>작성자</th>			
			<th>작성일</th>			
			<th>UTIL</th>			
		</tr>
		
	<c:forEach items="${cList}" var="comment">
		<tr bid="${comment.bId}">
			
		</tr>	
	</c:forEach>
		
	</table>	
	
	
	
</body>
</html>