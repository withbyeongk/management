<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<title>그룹 조회 페이지</title>
</head>
<body>
    <h1>그룹 정보 조회</h1>
    <br><hr><br>
    <label for="groupId">ID : </label>
    <input type="text" class="insertGroup" id="groupId" name="groupId" required><br><br>
    <button type="button" onclick="selectGroup();">ID로 그룹 조회</button>
    <br><hr><br>
    <div id="selectOneDiv">현재 응답 데이터 없음</div>
    <script>
    	function selectGroup(){
    		$.ajax({
				url : "selectUser.group",
				data : { groupId : $("#groupId").val() },
				success : function(group){
					$("#selectOneDiv").text("ID : " + group.groupId + ", 이름 : " + group.groupNm);
				},
				error : function(){
					console.log("통신 실패");
				}
			});
    	};
    </script>
    <br><hr><br>
    <h1>그룹 목록 조회</h1>
    <br><br>
    <button type="button" id="getGroupListBtn">그룹 목록 조회</button><br>
    <br><hr><br>
    <div id="selectListDiv">현재 응답 데이터 없음</div>
    <script>
    	$(function(){
    		$("#getGroupListBtn").click(function(){
    			$.ajax({
    				url : "selectGroupList.group",
    				success : function(list){
						var str = "";
						
						for(var i in list){
							str += "<tr>"
								  +"<td>"+list[i].groupId+"</td>"
								  +"<td>"+list[i].groupNm+"</td>"
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