<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>그룹 등록 페이지</title>
</head>
<body>
    <h1>그룹 등록</h1>
    <br><hr><br>
    <form action="insert.group" method="post">
        <div class="insert-group">
            <label for="groupId">ID : </label>
            <input type="text" class="insertGroup" id="groupId" name="groupId" required><br>
            
            <label for="groupNm">이름 : </label>
            <input type="text" class="insertGroup" id="groupNm" name="groupNm" required><br>
        </div><br>
        <div class="insert-btn" align="center">
            <button type="submit" class="enrollBtn">그룹 등록</button>
            <button type="reset">초기화</button>
        </div>
    </form>
    <br><hr><br>
    <button type="button" onclick="location.href='managePage.go';">관리홈으로</button>
</body>
</html>