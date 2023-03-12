<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>계정 수정 페이지</title>
</head>
<body>
    <h1>계정 수정</h1>
    <br><hr><br>
    <form action="update.ad" method="post">
        <div class="insert-group">
            <label for="adminId">ID : </label>
            <input type="text" class="insertAdmin" id="adminId" name="adminId" required><br>
            
            <label for="adminPw">PW : </label>
            <input type="text" class="insertAdmin" id="adminPw" name="adminPw" required><br>
            
            <label for="adminNewPw">New : </label>
            <input type="text" class="insertAdmin" id="adminNewPw" name="adminNewPw" required><br>
            
            <label for="adminChk">확인 : </label>
            <input type="text" class="insertAdmin" id="adminChk" name="adminChk" required><br>
            
            <label for="adminNm">이름 : </label>
            <input type="text" class="insertAdmin" id="adminNm" name="adminNm" required><br>
        </div><br>
        <div class="insert-btn" align="center">
            <button type="submit" class="enrollBtn">계정 수정</button>
            <button type="reset">초기화</button>
        </div>
    </form>
    <br><hr><br>
    <button type="button" onclick="location.href='home.go';">홈으로</button>
</body>
</html>