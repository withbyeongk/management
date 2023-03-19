<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<title>사이트 조회 페이지</title>
</head>
<body>
    <h1>사이트 정보 조회</h1>
    <br><hr><br>
    <label for="siteId">SITE ID : </label>
    <input type="text" class="insertSite" id="siteId" name="siteId" required><br><br>
    <button type="button" onclick="selectSite();">ID로 사이트 조회</button>
    <br><hr><br>
    <div id="selectOneDiv">현재 응답 데이터 없음</div>
    <script>
    	function selectSite(){
    		$.ajax({
				url : "selectSite.st",
				data : { siteId : $("#siteId").val() },
				success : function(site){
					$("#selectOneDiv").text("ID : " + site.siteId + ", 이름 : " + site.siteNm);
				},
				error : function(){
					console.log("통신 실패");
				}
			});
    	};
    </script>
    <br><hr><br>
    <h1>사이트 목록 조회</h1>
    <br><br>
    <button type="button" id="getSiteListBtn">사이트 목록 조회</button><br>
    <br><hr><br>
    <div id="selectListDiv">현재 응답 데이터 없음</div>
    <script>
    	$(function(){
    		$("#getSiteListBtn").click(function(){
    			$.ajax({
    				url : "selectSiteList.st",
    				success : function(list){
						var str = "";
						
						for(var i in list){
							str += "<tr>"
								  +"<td>"+list[i].siteId+"</td>"
								  +"<td>"+list[i].siteNm+"</td>"
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