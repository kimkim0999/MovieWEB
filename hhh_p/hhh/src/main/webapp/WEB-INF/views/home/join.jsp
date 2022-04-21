<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<%@ page import="java.net.URLDecoder"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css" />
    <style>
        * { box-sizing:border-box; }
        form {
            width:400px;
            height:600px;
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
        .input-field {
            width: 300px;
            height: 40px;
            border : 1px solid rgb(0,1,3);
            border-radius:5px;
            padding: 0 10px;
            margin-bottom: 10px;
        }
        label {
            width:300px;
            height:30px;
            margin-top :4px;
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
            font-size : 50px;
            margin: 20px 0 10px 0;
        }
        .msg {
            height: 30px;
            text-align:center;
            font-size:16px;
            color:red;
            margin-bottom: 0px;
        }
        .sns-chk {
            margin-top : 5px; 
        }
    </style>
    <title>Register</title>
</head>
<body>
   <form action="<c:url value="/home/joinOk"/>" method="post" onsubmit="return formCheck(this)">
   <!--<form:form modelAttribute="/home" method="post">-->
    <div class="title"><a href="/hhh/home/home"><img alt="" src="<c:url value="/img/hhh_logo.png"/>"></a></div>
    <!-- 
	<div id="msg" class="msg"> ${URLDecoder.decode(param.msg)}</div> 
     -->
	<div id="msg" class="msg">
		<c:if test="${not empty param.msg}">
			<i class="fa fa-exclamation-circle"> ${URLDecoder.decode(param.msg)}</i>            
		</c:if>        
	</div>
    <label for="">아이디</label>
    <input class="input-field" type="text" name="user_id" placeholder="8~12자리의 영대소문자와 숫자 조합">
    <label for="">비밀번호</label>
    <input class="input-field" type="text" name="user_pw" placeholder="8~12자리의 영대소문자와 숫자 조합">
    <label for="">이름</label>
    <input class="input-field" type="text" name="user_name" placeholder="홍길동">
    <label for="">이메일</label>
    <input class="input-field" type="text" name="n" placeholder="hansei@naver.com"> 
    <label for="">생일</label>
    <input class="input-field" type="text" name="nn" placeholder="2022/12/31">
    <label for="">핸드폰 번호</label>
    <input class="input-field" type="text" name="nnn" placeholder="010-1234-5678"> 
    <div class="sns-chk">
        <label><input type="checkbox" name="n" value="facebook"/>페이스북</label>
        <label><input type="checkbox" name="n" value="kakaotalk"/>카카오톡</label>
        <label><input type="checkbox" name="n" value="instagram"/>인스타그램</label>
    </div>
    <button>회원 가입</button>
   </form:form>
   <script>
       function formCheck(frm) {
            var msg ='';
            if(frm.id.value.length<3) {
                setMessage('id의 길이는 3이상이어야 합니다.', frm.id);
                return false;
            }
            if(frm.pwd.value.length<3) {
                setMessage('pwd의 길이는 3이상이어야 합니다.', frm.pwd);
                return false;
            }           
           
           return true;
       }
       <!--
       function setMessage(msg, element){ //												el태그 아닌 척 하려고				
            document.getElementById("msg").innerHTML = `<i class="fa fa-exclamation-circle"> ` ${'${msg}'}`</i>`;
            if(element) {
                element.select();
            }
       }
       -->
       function setMessage(msg, element){
           document.getElementById("msg").innerHTML = ` ${'${msg}'}`;

           if(element) {
               element.select();
           }
      }
   </script>
</body>
</html>