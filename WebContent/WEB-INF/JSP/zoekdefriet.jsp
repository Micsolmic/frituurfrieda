<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<!doctype html>
<html lang='nl'>
<head>
<title>firetetn zoeken</title>
<link rel="stylesheet" href="<c:url value='/css/zoekdefriet.css'/>">
</head>

<body>

<h1>Zoek die friet</h1>


<c:forEach var='deur' items='${deuren}' varStatus="status">
<form method="post" class="neighbourly">
<button type='submit' name='volgnummer' value="${status.index}">
	
	<img src='<c:url value ="/img/${deur}.png"/>' alt='deur toe'>
	
	
<c:if test='${deur=="gevonden"}'> 
	<c:set var='felicitatie' value='proficiat'/>
	</c:if>

</button>
</form>
</c:forEach>


<form method='post'>
<button type='submit' name='nieuwspel' value='true'>nieuw spel</button>
</form>
<br><br>
<h1>${felicitatie}</h1>

</body>
</html>