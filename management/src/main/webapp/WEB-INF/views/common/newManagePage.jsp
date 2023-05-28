<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>관리자 페이지</title>
    <link rel="stylesheet" href="resources/css/common/newManagePage.css" type="text/css">
</head>
<body>
    <div id="container">
        <div id="nav">
            <ul>
                <li><a href="#menu-user">사용자 관리</a></li>
                <li><a href="#menu-group">그룹 관리</a></li>
                <li><a href="#menu-site">사이트 관리</a></li>
                <li><a href="#menu-access">접근권한 관리</a></li>
            </ul>
        </div>
        <div id="content">
            <div id="menu-user" class="hide">
                <h1>USER</h1>
                <br>
                <div class="area-user">
                    <span>사용자 목록</span>
                    <button>목록 새로 고침</button>
                    <table id="user-table">
                        <thead>
	                        <tr>
	                            <th>USER ID</th>
	                            <th>USER NAME</th>
	                            <th>GROUP</th>
	                            <th>정보수정일시</th>
	                            <th>사용자등록일시</th>
	                        </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>iron</td>
                                <td>아이언</td>
                                <td>개발팀</td>
                                <td>아이언</td>
                                <td>개발팀</td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div><!-- 사용자 DIV 끝 -->
            <div id="menu-group" class="hide">
                <h1>GROUP</h1>
                <br>
                <div class="area-group">
                    <span>그룹 목록</span>
                    <button>그룹목록 새로 고침</button>
                    <table id="group-table">
                        <thead>
	                        <tr>
	                            <th>GROUP ID</th>
	                            <th>GROUP NAME</th>
	                            <th>정보수정일시</th>
	                            <th>사용자등록일시</th>
	                        </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>DEV</td>
                                <td>개발팀</td>
                                <td>수정일시</td>
                                <td>등록일시</td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
            <div id="menu-site" class="hide">
                <h1>SITE</h1>
                <p>SITE 상세페이지 내용입니다.</p>
            </div>
        </div>
    </div>
    <script type="script" src="resources/js/common/newManagePage.js"></script>
    <script>
        const menuLinks = document.querySelectorAll("#nav a");
        const contents = document.querySelectorAll("#content > div");
        menuLinks.forEach((menuLink) => {
            menuLink.addEventListener("click", (e) => {
                e.preventDefault();
                const targetId = menuLink.getAttribute("href").substring(1);
                contents.forEach((content) => {
                    if (content.id === targetId) {
                        content.classList.remove("hide");
                    } else {
                        content.classList.add("hide");
                    }
                });
            });
        });
    </script>
</body>
</html>