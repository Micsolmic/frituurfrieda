<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<!doctype html>
<html>
<head>
<title>kies geslacht</title>
<c:if test='${not empty geslacht}'>

<link rel='stylesheet' href='<c:url value="css/${geslacht}.css"/>'>



</c:if>

<link rel="stylesheet" href='<c:url value="css/iedereen.css" />'>

</head>
<body>

<h1>Jongens & Meisjes</h1>

<h1>${geslacht}</h1>


<form method="post">

<div>
 <button name="geslacht" type="submit" value="jongens">dudebros</button>


</div>

<div>
 <button name="geslacht" type="submit" value="meisjes">meisies</button>

</div>


</form>




<h1>${output}</h1>

</body>
</html>