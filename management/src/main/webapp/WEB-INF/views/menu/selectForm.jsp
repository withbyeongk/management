<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<title>메뉴 조회 페이지</title>
</head>
<body>
    <h1>메뉴 정보 조회</h1>
    <br><hr><br>
    <label for="menuId">ID : </label>
    <input type="text" class="insertMenu" id="menuId" name="menuId" required><br><br>
    <button type="button" onclick="selectMenu();">ID로 메뉴 정보 조회</button>
    <br><hr><br>
    <div id="selectOneDiv">현재 응답 데이터 없음</div>
    <script>
    	function selectMenu(){
    		$.ajax({
				url : "selectMenu.mn",
				data : { menuId : $("#menuId").val() },
				success : function(menu){
					$("#selectOneDiv").text("ID : " + menu.menuId + ", 이름 : " + menu.menuNm 
					+ ", REF ID : " + menu.menuRefId + ", LEVEL" + menu.menuLevel + ", ORDER : " + menu.menuOrder);
				},
				error : function(){
					console.log("통신 실패");
				}
			});
    	};
    </script>
    <br><hr><br>
    <h1>메뉴 목록 조회</h1>
    <br><br>
    <button type="button" id="getMenuListBtn">메뉴 목록 조회</button><br>
    <br><hr><br>
    <div id="selectListDiv">현재 응답 데이터 없음</div>
    <script>
    	$(function(){
    		$("#getMenuListBtn").click(function(){
    			$.ajax({
    				url : "selectMenuList.mn",
    				success : function(list){
						var str = "";
						
						for(var i in list){
							str += "<tr>"
								  +"<td>"+list[i].menuId+"</td>"
								  +"<td>"+list[i].menuNm+"</td>"
								  +"<td>"+list[i].menuRefId+"</td>"
								  +"<td>"+list[i].menuLevel+"</td>"
								  +"<td>"+list[i].menuOrder+"</td>"
								  +"</tr>";
						}
						$("#selectListDiv").html(str);
					
					},
    				error : function(){
    					console.log("통신 실패");
    				}
    			});
    		});
    	});
    </script>
    <br><hr><br>
    <button type="button" onclick="location.href='managePage.go';">관리홈으로</button>
</body>
</html>