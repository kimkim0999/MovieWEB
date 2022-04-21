<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.net.URLDecoder" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css" />
    <style>
       * { box-sizing:border-box; }
       a { text-decoration: none; }
        form {
            width:400px;
            height:400px;
            display : flex;
            flex-direction: column;
            align-items:center;
            position : absolute;
            top:50%;
            left:50%;
            transform: translate(-50%, -50%) ;
            border: 1px solid rgb(0,1,3);
            border-radius: 10px;
        }
        
		img{
        	width: 100px;
        	height: 100px;
        }
        
        input[type='text'], input[type='password'] {
            width: 300px;
            height: 40px;
            border : 1px solid rgb(0,1,3);
            border-radius:5px;
            padding: 0 10px;
            margin-bottom: 10px;
        }
        button {
            background-color: rgb(0,1,3);
            color : white;
            width:300px;
            height:50px;
            font-size: 17px;
            border : none;
            border-radius: 5px;
            margin : 20px 0 30px 0;
        }
        .title {
            padding-top: 30px
        }
        #msg {
            height: 30px;
            text-align:center;
            font-size:16px;
            color:red;
            margin-bottom: 20px;
        }
        #login_header{
        	float: left;
        }
    </style>
</head>
<body>
    <form action="<c:url value='/home/login'/>" method="post" onsubmit="return formCheck(this);">
        <div class="title">
        	<a href="/hhh/home/home">
	        	<img alt="" src="<c:url value="/img/hhh_logo.png"/>">
       		</a>
        </div>
        <div id="msg">
	    <c:if test="${not empty param.msg}">
		<i class="fa fa-exclamation-circle"> ${URLDecoder.decode(param.msg)}</i>            
	    </c:if>        
		</div>
        <input type="text" name="user_id" value="${cookie.id.value }" placeholder="이메일 입력" autofocus>
        <input type="password" name="user_pw" placeholder="비밀번호">
        <!-- Mypage 가려는데 로그인 X 시 MyPage url을 get방식으로 보내준다 -->
        <!-- 그리고 여기서 toURL로 받는데 히든!! -->
        <input type="hidden" name="toURL" value="${param.toURL}"><!--  로 확인 가능 -->
        <button>로그인</button>
        <div>
            <label><input type="checkbox" name="rememberId" ${empty cookie.id.value ? "" : "checked" }> 아이디 기억</label> |
            <a href="">비밀번호 찾기</a> |
            <a href="">회원가입</a>
        </div>
        <script>
            function formCheck(frm) {
                 let msg ='';
     
                 if(frm.id.value.length==0) {
                     setMessage('id를 입력해주세요.', frm.id);
                     return false;
                 }
     
                 if(frm.pwd.value.length==0) {
                     setMessage('password를 입력해주세요.', frm.pwd);
                     return false;
                 }
                 return true;
            }
     
            function setMessage(msg, element){
                 document.getElementById("msg").innerHTML = ` ${'${msg}'}`;
     
                 if(element) {
                     element.select();
                 }
            }
        </script>
    </form>
</body>
</html>