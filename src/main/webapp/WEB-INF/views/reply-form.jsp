<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>답글 작성 페이지</title>
</head>
<body>
	<form action="/replyToOriginBoardPro" method="post">
		
		<h1>답글 작성 페이지</h1>
		<input type="hidden" name="bGroup" value="${board.bGroup}"/>
		<input type="hidden" name="bOrder" value="${board.bOrder}"/>
		<input type="hidden" name="bDepth" value="${board.bDepth}"/>
		<div>
			<textarea name="bTitle" rows="1" cols="55" placeholder="제목을 입력하세요."></textarea>
		</div>
		
		<div>
			<textarea name="bContent" rows="14" cols="80" placeholder="내용을 입력하세요."></textarea>
		</div>
		
		<div>
			<button type="submit">올리기</button>
		</div>
	</form>

	<h1>${board.bGroup}</h1>
	<h1>${board.bOrder}</h1>
	<h1>${board.bDepth}</h1>
	
	
</body>
</html>