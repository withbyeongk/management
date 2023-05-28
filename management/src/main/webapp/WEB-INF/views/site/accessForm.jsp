<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사이트 권한 페이지</title>
</head>
<body>
    <h1>사이트 권한 부여</h1>
    <br><hr><br>
    <form action="grantAccess.st" method="post">
        <div class="insert-group">
            <label for="userId">USER ID : </label>
            <input type="text" class="insertAccess" id="userId" name="userId" required><br>
            
            <label for="siteId">SITE ID : </label>
            <input type="text" class="insertAccess" id="siteId" name="siteId" required><br>
            
        </div><br>
        <div class="insert-btn" align="center">
            <button type="submit" class="enrollBtn">사이트 권한 부여</button>
            <button type="reset">초기화</button>
        </div>
    </form>
    <br><hr><br>
    
    <h1>사이트 권한 회수</h1>
    <br><hr><br>
    <form action="revokeAccess.st" method="post">
        <div class="update-group">
            <label for="userId">ADMIN ID : </label>
            <input type="text" class="insertAccess" id="userId" name="userId" required><br>
            
            <label for="siteId">SITE ID : </label>
            <input type="text" class="insertAccess" id="siteId" name="siteId" required><br>
            
        </div><br>
        <div class="update-btn" align="center">
            <button type="submit" class="updateBtn">사이트 권한 회수</button>
            <button type="reset">초기화</button>
        </div>
    </form>
    <br><hr><br>
    <button type="button" onclick="location.href='managePage.go';">관리홈으로</button>
</body>
</html>