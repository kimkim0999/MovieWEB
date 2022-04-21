<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
	<link rel="stylesheet" href="<c:url value="/css/header.css"/>">
</head>
<body>
  <!-- 헤더 -->
        <div id="main_header">
            <!--로고+로그인+회원가입+마이페이지-->
            <div id="main_header_header">
                <!-- 로고 -->
                <div id="main_logo">
                    <a href="">
                        <img id="logo" src="hhh_logo.png" alt="">
                    </a>
                </div>
                <!-- 중간 -->
                <div id="main_header_middle"></div>
                <!-- 로그인+회원가입+마이페이지 -->
                <div id="main_header_service">
                    <!-- 로그인 -->
                    <div id="maid_header_login">
                        <a href="">
                            로그인
                            <!-- <img class="main_img" src="login.PNG" alt=""> -->
                        </a>
                    </div>
                    <!-- 회원가입 -->
                    <div id="maid_header_join">
                        <a href="">
                            회원가입
                            <!-- <img  class="main_img"  src="join.PNG" alt=""> -->
                        </a>
                    </div>
                    <!-- 마이페이지 -->
                    <div id="maid_header_mypage">
                        <a href="">
                            Mypage
                            <!-- <img  class="main_img"  src="mypage.PNG" alt=""> -->
                        </a>
                    </div>
                </div>
            </div>

            <!--메인 메뉴바-->
            <div id="main_header_menubar">
                <!-- 영화 -->
                <div id="main_header_menubar_movie">영화</div>
                
                <!-- 이벤트 -->
                <div id="main_header_menubar_event">이벤트</div>
                
                <!-- Q&A -->
                <div id="main_header_menubar_QA">Q&A</div>

                <!-- 중간 -->
                <div id="main_header_menubar_middle"></div>

                <!-- 검색하기 -->
                <div id="main_header_menubar_search">
                    <form action="">
                        <input type="text" size="5">
                        <button>검색하기</button>
                    </form>
                </div>

                <!-- 숨겨진 하단 메뉴상자 -->
                <div id="main_header_menubar_hidden">
                    <!-- 영화 -->
                    <div id="main_header_menubar_hidden_movie">
                        <a href="">영화순위</a>
                        <a href="">예매하기</a>
                        <a href="">CGV</a>
                    </div>
                    <!-- 이벤트 -->
                    <div id="main_header_menubar_hidden_event">
                        <a href=""> 이벤트 </a>
                        <a href="">제휴할인</a>
                        <a href="">회원등급</a>
                    </div>
                    <!-- Q&A -->
                    <div id="main_header_menubar_hidden_QA">
                        <a href="">문의하기</a>
                        <a href="">Q&A게시판</a>
                    </div>
                </div>
            </div>

        </div>
</body>
</html>