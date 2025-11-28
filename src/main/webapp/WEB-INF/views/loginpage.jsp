<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MyDiary App Login page</title>
<link rel = "stylesheet" href = "<c:url value = "/resources/styles/style.css"/>">
</head>

<body>
<div class = "header">

<div class = "first">
<img src = "<c:url value = "/resources/images/diary.jpeg"/>"width="80" height="50">
</div>

<div class = "second">MyDiary Application</div>

</div>
<br/>

<hr/>


	<div class = "bodypart">
	
	<div class = "bodypart1">
	<img src = "<c:url value = "/resources/images/diary.jpeg"/>"width="500" height="300">
	</div>
	
	<div class = "bodypart2">
	<h1>LOGIN HERE</h1><br/><br/><br/>
	<form action = "./authenticate" method = "POST">
	
	<label>Username</label><input type = "text" name = "username" class = "formcontrol"><br/><br/>
	<label>Password</label><input type = "password" name = "password" class = "formcontrol"><br/><br/><br/>
	<button type = "submit">LOGIN</button>
	
	</form>
	<br/><br/>
	New User? <a href = "./register">Register</a> here
	</div>
	
	</div>
	
</body>
</html>