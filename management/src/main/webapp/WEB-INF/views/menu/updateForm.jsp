<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메뉴 수정 페이지</title>
</head>
<body>
    <h1>메뉴 수정</h1>
    <br><hr><br>
    <form action="update.mn" method="post">
        <div class="update-group">
            <label for="menuId">ID : </label>
            <input type="number" class="updateMenu" id="menuId" name="menuId" value="0" required><br>
            
            <label for="menuNm">NAME : </label>
            <input type="text" class="updateMenu" id="menuNm" name="menuNm" required><br>
            
            <label for="menuUrl">URL : </label>
            <input type="text" class="updateMenu" id="menuUrl" name="menuUrl" required><br>
            
            <label for="menuRefId">상위메뉴ID : </label>
            <input type="number" class="updateMenu" id="menuRefId" name="menuRefId" value="0" required><br>
            
            <label for="menuLevel">LEVEL : </label>
            <input type="number" class="updateMenu" id="menuLevel" name="menuLevel" value="0" required><br>
            
            <label for="menuOrder">ORDER : </label>
            <input type="number" class="updateMenu" id="menuOrder" name="menuOrder" value="0" required><br>
        </div><br>
        <div class="update-btn" align="center">
            <button type="submit" class="updateBtn">메뉴 수정</button>
            <button type="reset">초기화</button>
        </div>
    </form>
    <br><hr><br>
    <button type="button" onclick="location.href='managePage.go';">관리홈으로</button>
</body>
</html>