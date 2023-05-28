<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<title>메인뷰</title>
	<link rel="stylesheet" href="resources/css/common/mainView.css" type="text/css">
</head>
<body>
    <div class="main-outer">
        <br>
        <div class="imgDiv">
            <img id="mainImg" src="resources/Img/mainImg.jpg" alt="이미지 없음">
        </div>
        <h2 align="center">User Login</h2>
        <div class="main-login">
            <form action="login.go" method="post">
                <div class="id-div">
                    <label for="userId">USER ID &nbsp;&nbsp;&nbsp;&nbsp;:</label>
                    <input type="text" class="login-input" id="userId" name="userId" placeholder="ID를 입력해 주세요.">
                </div>
                <br>
                <div class="pw-div">
                    <label for="userPw">PASSWORD : </label>
                    <input type="password" class="login-input" id="userPw" name="userPw" placeholder="비밀번호를 입력해 주세요.">
                </div>
                <div class="login-btn">
                    <button id="loginBtn">LOGIN</button>
                </div>
            </form>
        </div>
        <button type="button" onclick="location.href='insertForm.user';">계정 등록</button>
        <button type="button" onclick="location.href='newManage.go';">새 메뉴페이지</button>
    </div>
</body>
</html>