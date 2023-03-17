<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사이트 수정 페이지</title>
</head>
<body>
    <h1>사이트 수정</h1>
    <br><hr><br>
    <form action="update.st" method="post">
        <div class="update-group">
            <label for="siteId">사이트ID : </label>
            <input type="text" class="updateSite" id="siteId" name="siteId" required><br>
            
            <label for="siteNm">사이트명 : </label>
            <input type="text" class="updateSite" id="siteNm" name="siteNm" required><br>
        </div><br>
        <div class="update-btn" align="center">
            <button type="submit" class="updateBtn">사이트 수정</button>
            <button type="reset">초기화</button>
        </div>
    </form>
    <br><hr><br>
    <button type="button" onclick="location.href='home.go';">홈으로</button>
</body>
</html>