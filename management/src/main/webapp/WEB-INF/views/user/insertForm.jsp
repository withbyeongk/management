<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자 등록 페이지</title>
</head>
<body>
    <h1>사용자 등록</h1>
    <br><hr><br>
    <form action="insert.user" method="post">
        <div class="insert-group">
            <label for="userId">ID : </label>
            <input type="text" class="insertAdmin" id="userId" name="userId" required><br>
            
            <label for="userPw"">PW : </label>
            <input type="text" class="insertUser" id="userPw" name="userPw" required><br>
            
            <label for="userChk">확인 : </label>
            <input type="text" class="insertUser" id="userChk" name="userChk" required><br>
            
            <label for="userNm">이름 : </label>
            <input type="text" class="insertUser" id="userNm" name="userNm" required><br>
        </div><br>
        <div class="insert-btn" align="center">
            <button type="submit" class="enrollBtn">등록</button>
            <button type="reset">초기화</button>
        </div>
    </form>
    <br><hr><br>
    <button type="button" onclick="location.href='managePage.go';">관리홈으로</button>
</body>
</html>