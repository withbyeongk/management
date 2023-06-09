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
        <h1>계정 관리</h1>
        <br><hr><br>
        <button type="button" onclick="location.href='insertForm.user';">계정 등록</button>
        <br><hr><br>
        <button type="button" onclick="location.href='updateForm.user';">계정 수정</button>
        <br><hr><br>
        <button type="button" onclick="location.href='deleteForm.user';">계정 삭제</button>
        <br><hr><br>
        <button type="button" onclick="location.href='selectForm.user';">계정 정보 조회</button>
        <br><hr><hr><br>
        
        <h1>그룹 관리</h1>
        <br><hr><br>
        <button type="button" onclick="location.href='insertForm.group';">그룹 등록</button>
        <br><hr><br>
        <button type="button" onclick="location.href='updateForm.group';">그룹 수정</button>
        <br><hr><br>
        <button type="button" onclick="location.href='deleteForm.group';">그룹 삭제</button>
        <br><hr><br>
        <button type="button" onclick="location.href='selectForm.group';">그룹 정보 조회</button>
        <br><hr><hr><br>
        
        <h1>메뉴 관리</h1>
        <button type="button" onclick="location.href='insertForm.mn';">메뉴 등록</button>
        <br><hr><br>
        <button type="button" onclick="location.href='updateForm.mn';">메뉴 수정</button>
        <br><hr><br>
        <button type="button" onclick="location.href='deleteForm.mn';">메뉴 삭제</button>
        <br><hr><br>
        <button type="button" onclick="location.href='selectForm.mn';">메뉴 정보 조회</button>
        <br><hr><br>
        <button type="button" onclick="location.href='accessForm.mn';">메뉴 권한</button>
        <br><hr><hr><br>
        
        <h1>사이트 관리</h1>
        <button type="button" onclick="location.href='insertForm.st';">사이트 등록</button>
        <br><hr><br>
        <button type="button" onclick="location.href='updateForm.st';">사이트 수정</button>
        <br><hr><br>
        <button type="button" onclick="location.href='deleteForm.st';">사이트 삭제</button>
        <br><hr><br>
        <button type="button" onclick="location.href='selectForm.st';">사이트 정보 조회</button>
        <br><hr><br>
        <button type="button" onclick="location.href='accessForm.st';">사이트 권한</button>
        <br><hr><hr><br>
        
        <button type="button" onclick="location.href='home.go';">로그아웃</button>
	</div>
</body>
</html>