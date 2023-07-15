<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Try To Edit</title>
</head>
<body>
	<form action="/editBoard-Pro" method="post">
		<h2>게시글 수정하기</h2>
		<input type="hidden" name="bId" value="${board.bId}">
		<div>
			<textarea name="bTitle" rows="1" cols="55">${board.bTitle}</textarea>
		</div>
		
		<div>
			<textarea name="bContent" rows="14" cols="80">${board.bContent}</textarea>
		</div>
		
		<div>
			<button type="submit">수정하기</button>
		</div>
	</form>
</body>
</html>