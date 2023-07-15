<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판에 글 등록하기</title>
</head>
<body>
	<form action="/writePost" method="post">
		
			<h1>글 등록</h1>
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
	
</body>
</html>