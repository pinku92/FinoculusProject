<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
</head>
<body>
<center>
<h1>Upload a Text File</h1>
<form  method="post" action="fileUpload" enctype="multipart/form-data">
<input path="filePath" type="file" name="FilePath" /><br><br>
<input type="submit" value="Submit File">
</form>
</center>
</body>
</html>