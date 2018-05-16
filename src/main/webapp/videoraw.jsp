<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
	<p>Insira o video aqui:</p>
	<form method="post" action="videoraw" enctype="multipart/form-data">
		<input type="file" name="video" />
			<br /><br /> 
		<input type="text" name="uuid" /> 
		<input type="hidden" name="urlvideo" value=${link} /> 
			<br /><br /> 
		<input type="hidden" name="UUID_STRING" value=${UUID_STRING} >
		<input type="hidden" name="AMAZON_ACCESS_KEY" value=${AMAZON_ACCESS_KEY} >
		<input type="hidden" name="AMAZON_SECRET_KEY" value=${AMAZON_SECRET_KEY} >
		<input type="hidden" name="ZENCODER_API_KEY" value=${ZENCODER_API_KEY} >
		<input type="hidden" name="S3_BUCKET_NAME" value=${S3_BUCKET_NAME} >
		<input type="submit" value="Enviar" /> 
	</form>
</body>
</html>