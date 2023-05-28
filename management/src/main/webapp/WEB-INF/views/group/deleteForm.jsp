<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MAIN PAGE</title>
</head>
<body>
	<h1>그룹 정보 삭제</h1>
    <br><hr><br>
    <form action="delete.group" method="post">
            <div class="delete-group">
                <label for="groupId">그룹ID : </label>
                <input type="text" class="deleteGroup" id="groupId" name="groupId" required><br>
                
            </div><br>
            <div class="delete-btn" align="center">
                <button type="submit" class="deleteBtn">그룹 삭제</button>
                <button type="reset">초기화</button>
            </div>
        </form>
        <br><hr><br>
        <button type="button" onclick="location.href='managePage.go';">관리홈으로</button>
</body>
</html>