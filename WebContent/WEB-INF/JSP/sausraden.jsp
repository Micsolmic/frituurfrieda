<%@page contentType='text/html' pageEncoding='UTF-8'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<!doctype html>
<html>
<head>
<title>raad de saus</title>
</head>
<body>

<p>Te raden saus: ${sausGeraden}</p>
<form method="post">

<label for="sausinvoer">letter:</label><input type="text" name="sausinvoer">
<button type="submit">Raden</button>

</form>

<form method="post">

<input type="submit" name="nieuwspel" value="nieuwspel">

</form>

<c:if test='${not empty faalStadium}'>

<img src='<c:url value="/img/${faalStadium}.png"/>'>

</c:if>

</body>
</html>