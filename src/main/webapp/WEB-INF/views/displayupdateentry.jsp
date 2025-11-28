<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update page</title>
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
	<h1>UPDATE ENTRY</h1><br/><br/><br/>
	<form action = "./processupdateentry" method = "POST">
	
	<label>Date</label><input type = "text" name = "entrydate" class = "formcontrol" value = "<fmt:formatDate value="${entry.entrydate}" pattern = "yyyy-MM-dd"/>"readonly><br/><br/>
	<label>Description</label>
	<textarea rows = "10" cols = "30" name = "description">
	 ${entry.description}
	</textarea>
	<input type = "hidden" name = "userid" value = "${user.id}" >
	<input type = "hidden" name = "id" value = "${entry.id}" >
	
	<br/><br/><br/>
	<button type = "submit">UPDATE ENTRY</button>
	
	</form>
	
	</div>
	
	</div>
	
</body>
</html>