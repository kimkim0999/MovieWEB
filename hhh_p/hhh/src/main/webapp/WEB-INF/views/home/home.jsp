<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="loginOutLink1" value="${sessionScope.id == null ? '/home/login' : '' }"/>
<c:set var="loginOutLink2" value="${sessionScope.id == null ? '/home/join' : '/home/logout' }"/>
<c:set var="loginOut1" value="${sessionScope.id == null ? '로그인' : '' }"/>
<c:set var="loginOut2" value="${sessionScope.id == null ? '회원가입' : '로그아웃' }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<c:url value="/css/home.css"/>">
<title>Insert title here</title>
</head>
<body>
    <div id="main_total">

  <!-- 헤더 -->
        <div id="main_header">
            <!--로고+로그인+회원가입+마이페이지-->
            <div id="main_header_header">
                <!-- 로고 앞단 공백 -->
                <div id="main_header_middle1"></div>
                <!-- 로고 -->
				<a href="<c:url value="/home/home"/>">
	                <div id="main_logo">
                        <img id="logo" src="<c:url value="/img/hhh_logo.png"/>" alt="">
                        <div id=logo_name>
                        HHH Project
                        </div>
	                </div>
                </a>
                <!-- 로고 뒷단 공백 -->
                <div id="main_header_middle2"></div>
                <!-- 로그인+회원가입+마이페이지 -->
                <div id="main_header_service">
                    <!-- 로그인 -->
                  	<a href="<c:url value='${loginOutLink1}'/>">
                    	<div id="maid_header_login">
                            ${loginOut1}
                    	</div>
					</a>
                    <!-- 회원가입 -->
                    <a href="<c:url value='${loginOutLink2}'/>">
                    	<div id="maid_header_join">
                            ${loginOut2}
	                    </div>
                    </a>
                    <!-- 마이페이지 -->
                    <a href="<c:url value="/mypage/mypage"/>">
                    	<div id="maid_header_mypage">
                            Mypage
	                    </div>
                    </a>
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
                        <input id="sertext" type="text" size="5">
                        <button id="serbtn">검색</button>
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
	

        <!-- 서비스 -->
        <div id="main_service">
            <!-- 공개예정 영화 -->
            <div id="main_service_commingsoon">
                <div id="main_service_commingsoon_title">
                    공개예정 영화
                    <br>
                </div>
                
				<c:forEach var="mitem" items="${movie}">
					<img alt="?" src="<c:url value="/img/${mitem.movie_img}"/>" >
					영화제목 : ${mitem.movie_name}
				    상영일자 : 
				</c:forEach>
				
            </div>
            <!-- 상영중 영화 -->
            <div id="main_service_movie">
                <div id="main_service_movid_title">
                    상영중 영화 이미지랑 제목 예매버튼 별점
                    <br>
                </div>
                영화 영화
            </div>
            <!-- 이벤트 및 게시물 -->
            <div id="main_service_border">
                이벤트 및 게시물 등등
                <br> <!-- 원래 br은 절대 쓰믄 안댐 -->
                이벤트랑 게시물 반띵 해서 구분!!
            </div>
        </div>

        <!-- 푸터 -->
        <div id="main_footer">
            카피라이트 + 회사정보
        </div>

    </div>
</body>
</html>