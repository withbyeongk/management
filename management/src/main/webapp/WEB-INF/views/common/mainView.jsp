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
        <br><hr><br>
        <button type="button" onclick="location.href='insertForm.ad';">계정 등록</button>
        <br><hr><br>
        <button type="button" onclick="location.href='updateForm.ad';">계정 수정</button>
        <br><hr><br>
        <button type="button" onclick="location.href='deleteForm.ad';">계정 삭제</button>
        <br><hr><br>
        <button type="button" onclick="location.href='selectForm.ad';">계정 정보 조회</button>
        
	</div>
</body>
</html>