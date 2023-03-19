<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<title>계정 조회 페이지</title>
</head>
<body>
    <h1>계정 정보 조회</h1>
    <br><hr><br>
    <label for="adminId">ID : </label>
    <input type="text" class="insertAdmin" id="adminId" name="adminId" required><br><br>
    <button type="button" onclick="selectAdmin();">ID로 계정 조회</button>
    <br><hr><br>
    <div id="selectOneDiv">현재 응답 데이터 없음</div>
    <script>
    	function selectAdmin(){
    		$.ajax({
				url : "selectAdmin.ad",
				data : { adminId : $("#adminId").val() },
				success : function(admin){
					$("#selectOneDiv").text("ID : " + admin.adminId + ", 이름 : " + admin.adminNm);
				},
				error : function(){
					console.log("통신 실패");
				}
			});
    	};
    </script>
    <br><hr><br>
    <h1>계정 목록 조회</h1>
    <br><br>
    <button type="button" id="getAdminListBtn">계정 목록 조회</button><br>
    <br><hr><br>
    <div id="selectListDiv">현재 응답 데이터 없음</div>
    <script>
    	$(function(){
    		$("#getAdminListBtn").click(function(){
    			$.ajax({
    				url : "selectAdminList.ad",
    				success : function(list){
						var str = "";
						
						for(var i in list){
							str += "<tr>"
								  +"<td>"+list[i].adminId+"</td>"
								  +"<td>"+list[i].adminNm+"</td>"
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