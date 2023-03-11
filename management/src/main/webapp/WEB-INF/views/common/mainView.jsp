<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<title>메인뷰</title>
</head>
<body>
	<div class="mainDiv">
		<form action="insert.ad" method="post">
			<div class="insert-group">
				<label for="adminId">ID : </label>
				<input type="text" class="insertAdmin" id="adminId" name="adminId" required>
				
				<label for="adminPw">ID : </label>
				<input type="text" class="insertAdmin" id="adminPw" name="adminPw" required>
				
				<label for="adminChk">ID : </label>
				<input type="text" class="insertAdmin" id="adminChk" name="adminChk" required>
				
				<label for="adminNm">ID : </label>
				<input type="text" class="insertAdmin" id="adminNm" name="adminNm" required>
			</div><br>
			<div class="insert-btn" align="center">
				<button type="submit" class="enrollBtn">등록</button>
				<button type="reset">초기화</button>
			</div>
		</form>
	</div>
</body>
</html>