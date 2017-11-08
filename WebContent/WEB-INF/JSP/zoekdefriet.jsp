<%@page contentType='text/html' pageEncoding='UTF-8'%>
<%-- Op de vorige regel wordt session="false" niet vermeld --%>
<%-- Zo komt session="true" (de default) --%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<!doctype html>
<html lang='nl'>
<head>

</head>
<body>
<h1>Zoek de friet</h1>
<form method='post'>
<c:forEach items='${zoekDeFrietSpel.deuren}' var='deur' varStatus="status">
<button type='submit' name='volgnummer' value='${status.index}'>
<c:choose>
<c:when test='${deur.open}'>
<c:choose>
<c:when test='${deur.metFriet}'>
<img src='<c:url value="/img/gevonden.png"/>' alt='gevonden'>
</c:when>
<c:otherwise>
<img src='<c:url value="/img/deuropen.png"/>' alt='deur open'>
</c:otherwise>
</c:choose>
</c:when>
<c:otherwise>
<img src='<c:url value="/img/deurtoe.png"/>' alt='deur toe'>
</c:otherwise>
</c:choose>
</button>
</c:forEach>

</form>
<c:url value='' var='nieuwSpelURL'>
<c:param name='nieuwSpel' value='true'/>
</c:url>
<form method='post' action='${nieuwSpelURL}'>
<input type='submit' value='Nieuw spel'>
</form>
</body>
</html>