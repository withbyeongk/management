<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Page - super</title>
    <style>
        .user-outer{
            margin: auto;
            margin-top: 30px;
            width: 1000px;
            height: 700px;
        }
        .first-row{
            width:100%;
            height:330px;
        }
        .second-row{
            width:100%;
            height:330px;
        }
        .column-common{
            width:490px;
            height: 320px;
            border-radius: 20px;
            cursor : pointer;
        }
        .col1{
            float: left;
            margin-right: 10px;
            background-color: rgb(252, 207, 213);
        }
        .col2{
            float: left;
            background-color: rgb(245, 200, 183);
        }
        .col3{
            float: left;
            margin-right: 10px;
            background-color: rgb(253, 253, 163);
        }
        .col4{
            float: left;
            background-color: rgb(248, 201, 248);
        }

        /* font */
        .user-outer h1{
            color :rgb(16, 14, 16);
        }
        .user-outer h2{
            color: rgb(81, 81, 132);
        }

    </style>
</head>
<body>
    <div class="user-outer">
        <h1 align="center">ADMIN 관리자 페이지</h1>
        <div class="first-row">
            <div class="col1 column-common">
                <h2 align="center">USER 관리</h2>
                
                
            </div>
            <div class="col2 column-common">
                <h2 align="center">GROUP 관리</h2>
            </div>
        </div>
        <div class="second-row">
            <div class="col3 column-common">
                <h2 align="center">SITE 관리</h2>
            </div>
            <div class="col4 column-common">
                <h2 align="center">SECTION 4(준비 중)</h2>
            </div>
        </div>
    </div>
    <script>
        let clkOnCol1 = document.querySelector(".col1");
        clkOnCol1.addEventListener("click", function(){
            location.href="";
        });
        let clkOnCol2 = document.querySelector(".col2");
        clkOnCol2.addEventListener("click", function(){
            location.href="";
        });
        let clkOnCol3 = document.querySelector(".col3");
        clkOnCol3.addEventListener("click", function(){
            location.href="";
        });
        let clkOnCol4 = document.querySelector(".col4");
        clkOnCol4.addEventListener("click", function(){
            location.href="";
        });
    </script>
</body>
</html>