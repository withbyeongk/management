<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MAIN PAGE</title>
</head>
<body>
	<h1>계정 정보 삭제</h1>
    <br><hr><br>
    <form action="delete.ad" method="post">
            <div class="delete-group">
                <label for="adminId">ID : </label>
                <input type="text" class="deleteAdmin" id="adminId" name="adminId" required><br>
                
                <label for="adminPw">PW : </label>
                <input type="text" class="deleteAdmin" id="adminPw" name="adminPw" required><br>
            </div><br>
            <div class="delete-btn" align="center">
                <button type="submit" class="deleteBtn">계정 삭제</button>
                <button type="reset">초기화</button>
            </div>
        </form>
        <br><hr><br>
        <button type="button" onclick="location.href='home.go';">홈으로</button>
</body>
</html>