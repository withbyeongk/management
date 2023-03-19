<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<title>메인뷰</title>
    <style>
        .main-login{
            width: 80%;
            height: 150px;
            background-color: rgb(241, 235, 235);/*rgb(245, 207, 212)*/
            border: 1px solid rgba(79, 71, 201, 0.589);
            margin: auto;
            margin-top: 50px;
            margin-bottom: 50px;
        }
        h2{
            margin-top: 5%;
            color: rgb(73, 73, 187);
        }

        .main-login{
            margin:auto;
            margin-top: 5%;
        }
        .id-div{
            margin-top:35px;
            text-align: center;
        }
        .pw-div{
            text-align: center;
        }
        .login-input{
            height: 25px;
            border: 1px solid lightgray;
            padding-left: 3%;
            border-radius: 50px;
            background-color: rgb(255, 255, 255);
        }

        label{
            font-size: 0.8rem;
            font-weight: bold;
            color: rgb(102, 102, 202);
            margin-right: 15px;
        }
        #loginBtn{
            width: 100px;
            height: 30px;
            background-color: rgb(90, 20, 219);
            color: white;
            font-weight: bold;
            border: none;
            border-radius: 4px;
            vertical-align: middle;
            float: right;
            margin-top: 60px;
            margin-right: 100px;
        }
        #loginBtn:hover{
	    	font-size: 14px;
		    font-weight: bold;
	    }
        #adminId:focus{
            outline: none !important;
        	border-color: #1b0ca3;
            box-shadow: 0 0 10px #1b0ca3;
            border: 1px solid #1b0ca3;
        }
        #adminPw:focus{
            outline: none !important;
        	border-color: #1b0ca3;
            box-shadow: 0 0 10px #1b0ca3;
            border: 1px solid #1b0ca3;
        }
    </style>
</head>
<body>
    <div class="main-outer">
        <h2 align="center">Admin Login</h2>
        <div class="main-login">
            <form action="login.go">
                <div class="id-div">
                    <label for="adminId">ADMIN ID : </label>
                    <input type="text" class="login-input" id="adminId" name="adminId" placeholder="ID를 입력해 주세요.">
                </div>
                <br>
                <div class="pw-div">
                    <label for="adminPw">PASSWORD : </label>
                    <input type="password" class="login-input" id="adminPw" name="adminPw" placeholder="비밀번호를 입력해 주세요.">
                </div>
                <div class="login-btn">
                    <button id="loginBtn">LOGIN</button>
                </div>
            </form>
        </div>
        <button onclick="location.href='insertForm.ad'">회원등록 임시 버튼</button>
    </div>
</body>
</html>