<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사이트 등록 페이지</title>
</head>
<body>
    <h1>사이트 등록</h1>
    <br><hr><br>
    <form action="insert.st" method="post">
        <div class="insert-group">
            <label for="siteId">사이트ID : </label>
            <input type="text" class="insertSite" id="siteId" name="siteId" required><br>
            
            <label for="siteUrl">사이트 URL : </label>
            <input type="text" class="insertSite" id="siteUrl" name="siteUrl" required><br>
            
            <label for="siteComment">사이트 설명 : </label>
            <input type="text" class="insertSite" id="siteComment" name="siteComment" required><br>
            
        </div><br>
        <div class="insert-btn" align="center">
            <button type="submit" class="enrollBtn">사이트 등록</button>
            <button type="reset">초기화</button>
        </div>
    </form>
    <br><hr><br>
    <button type="button" onclick="location.href='managePage.go';">관리홈으로</button>
</body>
</html>