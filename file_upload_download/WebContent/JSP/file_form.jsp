<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 업로드</title>
</head>
<body>
	<form action="../Upload" method="post" enctype="multipart/form-data">
		<fieldset>
			<legend> 파일 업로드 </legend>
			<div>
				<label for="name"> 이름 </label> 
				<input type="text" name="name" id="name" required>
			</div>
			
			<div>
				<label for="subject"> 제목 </label> 
				<input type="text" name="subject" id="subject" required>
			</div>
			
			<div>
				<label for="fileName"> 파일명 </label> 
				<input type="file" name="fileName" id="fileName" required>
			</div>
			
			<div>
				<input type="submit" value="전송"> <input type="reset"value="취소">
			</div>
		</fieldset>
	</form>
</body>
</html>