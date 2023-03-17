<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메뉴 등록 페이지</title>
</head>
<body>
    <h1>메뉴 등록</h1>
    <br><hr><br>
    <form action="insert.mn" method="post">
        <div class="insert-group">
            <label for="menuNm">메뉴명 : </label>
            <input type="text" class="insertMenu" id="menuNm" name="menuNm" required><br>
            
            <label for="menuUrl">URL : </label>
            <input type="text" class="insertMenu" id="menuUrl" name="menuUrl" required><br>
            
            <label for="menuRefId">부모ID : </label>
            <input type="number" class="menuRefId" id="menuRefId" name="menuRefId" value="0"><br>
            
            <label for="menuLevel">레벨 : </label>
            <input type="number" class="insertMenu" id="menuLevel" name="menuLevel" value="0"><br>
            
            <label for="menuOrder">순서 : </label>
            <input type="number" class="insertMenu" id="menuOrder" name="menuOrder" value="0"><br>
        </div><br>
        <div class="insert-btn" align="center">
            <button type="submit" class="enrollBtn">메뉴 등록</button>
            <button type="reset">초기화</button>
        </div>
    </form>
    <br><hr><br>
    <button type="button" onclick="location.href='home.go';">홈으로</button>
</body>
</html>