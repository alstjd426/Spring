<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
xml 객체 : ${obj }<br>
생성자 DI 객체 : ${obj.sms }<br>
생성자 DI 기본 데이터 : ${obj.num }<br>

Setter DI 객체 : ${obj.unit }<br>
Setter DI 기본 데이터 : ${obj.msg }<br>
</body>
</html>