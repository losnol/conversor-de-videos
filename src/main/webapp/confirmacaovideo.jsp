<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Confirmação</title>
<link rel="stylesheet" href="dark-matter.css" type="text/css">
</head>
<body>
	<h1>Vídeo enviado com sucesso!</h1>
	<form action="confirmacaovideo" method="GET" class="dark-matter">
		<input type="hidden" name="urlvideo" value= ${urlvideo} >
		<input type="submit" value="Ver o Vídeo" />
	</form>
	<form method="get" action="index"  class="dark-matter" >
		<input type="submit" value="Retornar a página principal" />
	</form>
</body>
</html>