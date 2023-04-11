<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>영역</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            font-family: 'Noto Sans KR', sans-serif;
        }
        #container {
            display: flex;
            height: 800px;
        }
        #nav {
            width: 20%;
            background-color: #ead9d9;
            padding: 20px;
            box-sizing: border-box;
            height: 100%;
        }
        #nav ul {
            list-style-type: none;
            margin: 0;
            padding: 0;
        }
        #nav li {
            margin-bottom: 10px;
        }
        #nav a {
            display: block;
            padding: 10px;
            background-color: #b84949;
            color: #ffffff;
            text-decoration: none;
            border-radius: 5px;
            transition: background-color 0.3s ease;
        }
        #nav a:hover {
            background-color: #ff9292;
            font-weight: bold;
            color: #ffffff;
        }
        #content {
            width: 80%;
            background-color: #ffffff;
            padding: 20px;
            box-sizing: border-box;
            height: 100%;
        }
        #content h1 {
            margin-top: 0;
        }
        .hide {
            display: none;
        }
    </style>
</head>
<body>
    <div id="container">
        <div id="nav">
            <ul>
                <li><a href="#menu-user">USER</a></li>
                <li><a href="#menu-group">GROUP</a></li>
                <li><a href="#menu-site">SITE</a></li>
            </ul>
        </div>
        <div id="content">
            <div id="menu-user" class="hide">
                <h1>USER</h1>
                <br>
                <div class="">
                    <span>사용자 목록</span>
                    <button>목록 새로 고침</button>
                    <table id="user-table">
                        <thead>
                            <th>USER ID</th>
                            <th>USER NAME</th>
                            <th>GROUP</th>
                        </thead>
                        <tbody>
                            <tr>
                                <td>iron</td>
                                <td>아이언</td>
                                <td>개발팀</td>
                            </tr>
                            <tr>
                                <td>iron</td>
                                <td>아이언</td>
                                <td>개발팀</td>
                            </tr>
                            <tr>
                                <td>iron</td>
                                <td>아이언</td>
                                <td>개발팀</td>
                            </tr>
                            <tr>
                                <td>iron</td>
                                <td>아이언</td>
                                <td>개발팀</td>
                            </tr>
                            <tr>
                                <td>iron</td>
                                <td>아이언</td>
                                <td>개발팀</td>
                            </tr>
                            <tr>
                                <td>iron</td>
                                <td>아이언</td>
                                <td>개발팀</td>
                            </tr>
                            <tr>
                                <td>iron</td>
                                <td>아이언</td>
                                <td>개발팀</td>
                            </tr>
                            <tr>
                                <td>iron</td>
                                <td>아이언</td>
                                <td>개발팀</td>
                            </tr>
                            <tr>
                                <td>iron</td>
                                <td>아이언</td>
                                <td>개발팀</td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                
            </div>
            <div id="menu-group" class="hide">
                <h1>GROUP</h1>
                <p>GROUP 상세페이지 내용입니다.</p>
            </div>
            <div id="menu-site" class="hide">
                <h1>SITE</h1>
                <p>SITE 상세페이지 내용입니다.</p>
            </div>
        </div>
    </div>
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