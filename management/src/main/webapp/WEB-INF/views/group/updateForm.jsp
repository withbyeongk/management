<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>그룹 수정 페이지</title>
</head>
<body>
    <h1>그룹 수정</h1>
    <br><hr><br>
    <form action="update.group" method="post">
        <div class="update-group">
            <label for="groupId">ID : </label>
            <input type="text" class="updateGroup" id="groupId" name="groupId" required><br>
            
            <label for="groupNm">이름 : </label>
            <input type="text" class="updateGroup" id="groupNm" name="groupNm" required><br>
        </div><br>
        <div class="update-btn" align="center">
            <button type="submit" class="updateBtn">그룹 수정</button>
            <button type="reset">초기화</button>
        </div>
    </form>
    <br><hr><br>
    <button type="button" onclick="location.href='managePage.go';">관리홈으로</button>
</body>
</html>