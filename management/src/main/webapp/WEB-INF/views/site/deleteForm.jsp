<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사이트 삭제 페이지</title>
</head>
<body>
	<h1>사이트 정보 삭제</h1>
    <br><hr><br>
    <form action="delete.st" method="post">
            <div class="delete-group">
                <label for="siteId">사이트ID : </label>
                <input type="text" class="deleteSite" id="siteId" name="siteId" required><br>
            </div><br>
            <div class="delete-btn" align="center">
                <button type="submit" class="deleteBtn">사이트 삭제</button>
                <button type="reset">초기화</button>
            </div>
        </form>
        <br><hr><br>
        <button type="button" onclick="location.href='home.go';">홈으로</button>
</body>
</html>