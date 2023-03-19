<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메뉴 삭제</title>
</head>
<body>
	<h1>메뉴 정보 삭제</h1>
    <br><hr><br>
    <form action="delete.mn" method="post">
            <div class="delete-group">
                <label for="menuId">메뉴 ID : </label>
                <input type="number" class="deleteMenu" id="menuId" name="menuId" value="0" required><br>
            </div><br>
            <div class="delete-btn" align="center">
                <button type="submit" class="deleteBtn">메뉴 삭제</button>
                <button type="reset">초기화</button>
            </div>
        </form>
        <br><hr><br>
        <button type="button" onclick="location.href='managePage.go';">관리홈으로</button>
</body>
</html>