<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="loginOutLink1" value="${sessionScope.id == null ? '/home/login' : '' }"/>
<c:set var="loginOutLink2" value="${sessionScope.id == null ? '/home/join' : '/home/logout' }"/>
<c:set var="loginOut1" value="${sessionScope.id == null ? '�α���' : '' }"/>
<c:set var="loginOut2" value="${sessionScope.id == null ? 'ȸ������' : '�α׾ƿ�' }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<c:url value="/css/home.css"/>">
<title>Insert title here</title>
</head>
<body>
    <div id="main_total">

  <!-- ��� -->
        <div id="main_header">
            <!--�ΰ�+�α���+ȸ������+����������-->
            <div id="main_header_header">
                <!-- �ΰ� �մ� ���� -->
                <div id="main_header_middle1"></div>
                <!-- �ΰ� -->
				<a href="<c:url value="/home/home"/>">
	                <div id="main_logo">
                        <img id="logo" src="<c:url value="/img/hhh_logo.png"/>" alt="">
                        <div id=logo_name>
                        HHH Project
                        </div>
	                </div>
                </a>
                <!-- �ΰ� �޴� ���� -->
                <div id="main_header_middle2"></div>
                <!-- �α���+ȸ������+���������� -->
                <div id="main_header_service">
                    <!-- �α��� -->
                  	<a href="<c:url value='${loginOutLink1}'/>">
                    	<div id="maid_header_login">
                            ${loginOut1}
                    	</div>
					</a>
                    <!-- ȸ������ -->
                    <a href="<c:url value='${loginOutLink2}'/>">
                    	<div id="maid_header_join">
                            ${loginOut2}
	                    </div>
                    </a>
                    <!-- ���������� -->
                    <a href="<c:url value="/mypage/mypage"/>">
                    	<div id="maid_header_mypage">
                            Mypage
	                    </div>
                    </a>
                </div>
            </div>

            <!--���� �޴���-->
            <div id="main_header_menubar">
                <!-- ��ȭ -->
                <div id="main_header_menubar_movie">��ȭ</div>
                
                <!-- �̺�Ʈ -->
                <div id="main_header_menubar_event">�̺�Ʈ</div>
                
                <!-- Q&A -->
                <div id="main_header_menubar_QA">Q&A</div>

                <!-- �߰� -->
                <div id="main_header_menubar_middle"></div>

                <!-- �˻��ϱ� -->
                <div id="main_header_menubar_search">
                    <form action="">
                        <input id="sertext" type="text" size="5">
                        <button id="serbtn">�˻�</button>
                    </form>
                </div>

                <!-- ������ �ϴ� �޴����� -->
                <div id="main_header_menubar_hidden">
                    <!-- ��ȭ -->
                    <div id="main_header_menubar_hidden_movie">
                        <a href="">��ȭ����</a>
                        <a href="">�����ϱ�</a>
                        <a href="">CGV</a>
                    </div>
                    <!-- �̺�Ʈ -->
                    <div id="main_header_menubar_hidden_event">
                        <a href=""> �̺�Ʈ </a>
                        <a href="">��������</a>
                        <a href="">ȸ�����</a>
                    </div>
                    <!-- Q&A -->
                    <div id="main_header_menubar_hidden_QA">
                        <a href="">�����ϱ�</a>
                        <a href="">Q&A�Խ���</a>
                    </div>
                </div>
            </div>

        </div>
	

        <!-- ���� -->
        <div id="main_service">
            <!-- �������� ��ȭ -->
            <div id="main_service_commingsoon">
                <div id="main_service_commingsoon_title">
                    �������� ��ȭ
                    <br>
                </div>
                
				<c:forEach var="mitem" items="${movie}">
					<img alt="?" src="<c:url value="/img/${mitem.movie_img}"/>" >
					��ȭ���� : ${mitem.movie_name}
				    ������ : 
				</c:forEach>
				
            </div>
            <!-- ���� ��ȭ -->
            <div id="main_service_movie">
                <div id="main_service_movid_title">
                    ���� ��ȭ �̹����� ���� ���Ź�ư ����
                    <br>
                </div>
                ��ȭ ��ȭ
            </div>
            <!-- �̺�Ʈ �� �Խù� -->
            <div id="main_service_border">
                �̺�Ʈ �� �Խù� ���
                <br> <!-- ���� br�� ���� ���� �ȴ� -->
                �̺�Ʈ�� �Խù� �ݶ� �ؼ� ����!!
            </div>
        </div>

        <!-- Ǫ�� -->
        <div id="main_footer">
            ī�Ƕ���Ʈ + ȸ������
        </div>

    </div>
</body>
</html>