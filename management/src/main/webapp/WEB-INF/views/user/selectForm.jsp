<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<title>사용자 조회 페이지</title>
</head>
<body>
    <h1>사용자 정보 조회</h1>
    <br><hr><br>
    <label for="userId">ID : </label>
    <input type="text" class="insertUser" id="userId" name="userId" required><br><br>
    <button type="button" onclick="selectUser();">ID로 계정 조회</button>
    <br><hr><br>
    <div id="selectOneDiv">현재 응답 데이터 없음</div>
    <script>
    	function selectUser(){
    		$.ajax({
				url : "selectUser.user",
				data : { userId : $("#userId").val() },
				success : function(user){
					$("#selectOneDiv").text("ID : " + user.userId + ", 이름 : " + user.userNm);
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
    <button type="button" id="getUserListBtn">계정 목록 조회</button><br>
    <br><hr><br>
    <div id="selectListDiv">현재 응답 데이터 없음</div>
    <script>
    	$(function(){
    		$("#getUserListBtn").click(function(){
    			$.ajax({
    				url : "selectUserList.user",
    				success : function(list){
						var str = "";
						
						for(var i in list){
							str += "<tr>"
								  +"<td>"+list[i].userId+"</td>"
								  +"<td>"+list[i].userNm+"</td>"
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