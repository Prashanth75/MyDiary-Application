<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View page</title>
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
<br/>
<h2>Welcome <span style = "color:steelblue">${user.username}</span></h2>
<h2><a href="./signout" style = "color:red; float:right">SignOut</a></h2>

	<div class = "bodypart">
	
	<div class = "bodypart1">
	<img src = "<c:url value = "/resources/images/diary.jpeg"/>"width="500" height="300">
	</div>
	
	<div class = "bodypart2">
	<h1>VIEW ENTRY</h1><br/><br/><br/>
	<table>
	<tr><td>Date</td><td>${entry.entrydate}</td></tr>
	<tr><td>Description</td><td>${entry.description}</td></tr>
	</table>
	
	<br/><br/><br/>
	<a href = "./userhome"><button type = "button">BACK TO HOME</button></a>
	
	
	
	</div>
	
	</div>
	
</body>
</html>