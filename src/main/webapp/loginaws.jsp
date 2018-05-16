<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="loginaws" method="GET">
		AWS UUID <input type="text" name="UUID_STRING" /> <br />
		AWS Access Key <input type="text" name="AMAZON_ACCESS_KEY" /> <br />
		AWS Secret Key <input type="text" name="AMAZON_SECRET_KEY" /> <br />
		Bucket Name <input type="text" name="S3_BUCKET_NAME" /> <br />
		Zencoder Key <input type="text" name="ZENCODER_API_KEY" /> <br />
		<br /> <input type="submit" value="Cadastrar credenciais" />
	</form>
</body>
</html>