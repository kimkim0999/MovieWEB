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
  <!-- ��� -->
        <div id="main_header">
            <!--�ΰ�+�α���+ȸ������+����������-->
            <div id="main_header_header">
                <!-- �ΰ� -->
                <div id="main_logo">
                    <a href="">
                        <img id="logo" src="hhh_logo.png" alt="">
                    </a>
                </div>
                <!-- �߰� -->
                <div id="main_header_middle"></div>
                <!-- �α���+ȸ������+���������� -->
                <div id="main_header_service">
                    <!-- �α��� -->
                    <div id="maid_header_login">
                        <a href="">
                            �α���
                            <!-- <img class="main_img" src="login.PNG" alt=""> -->
                        </a>
                    </div>
                    <!-- ȸ������ -->
                    <div id="maid_header_join">
                        <a href="">
                            ȸ������
                            <!-- <img  class="main_img"  src="join.PNG" alt=""> -->
                        </a>
                    </div>
                    <!-- ���������� -->
                    <div id="maid_header_mypage">
                        <a href="">
                            Mypage
                            <!-- <img  class="main_img"  src="mypage.PNG" alt=""> -->
                        </a>
                    </div>
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
                        <input type="text" size="5">
                        <button>�˻��ϱ�</button>
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
</body>
</html>