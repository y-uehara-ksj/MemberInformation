<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="Stylesheet" href="top.css">
<link rel="stylesheet" href="sign.css">
<meta charset="UTF-8">
<title>会員情報画面</title>
</head>
<body>


<h2>会員情報登録システム</h2>
<form action="../servlet/top1" method = "get" >

<div class="item">
	<input type="submit" value="会員情報新規登録" ><br>
</div>
</form>

<form action="../servlet/top2"	method="get">	
<div class="item">		
	<input type="submit" value="会員情報変更" ><br>
</div>
</form>

<form action="../servlet/top3"	method="get">	
<div class="item">
	<input type="submit" value="会員情報削除" >
</div>
</form>


</body>
</html>