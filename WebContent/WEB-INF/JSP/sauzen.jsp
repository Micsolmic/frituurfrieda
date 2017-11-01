<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>

<!DOCTYPE html>
<html>
<c:import url='/WEB-INF/JSP/fridahead.jsp'>
	<c:param name="title" value="fridas sauzenz"/>
</c:import>
<body>







<form method='post' action='verwijdersauzen'>
<c:forEach var='saus' items='${sauzen}'>
<input type='checkbox' name='verwijder' value='${saus.nummer}'><label>${saus.naam}</label>

</c:forEach>

<br>
<c:if test='${not empty sauzen}'>
<input type='submit' value='verwijder selectie' id='deleteButton'>
</c:if>

</form>	







<hr>
<form>
<label>zoek ingredient:</label><input name='ingredient' type='text'/><span id='foutmelding'>${fout}</span>

</form>

<c:if test='${not empty gevondenSauzen}'>
<h1>Gevonden sauzen:</h1>
</c:if>
<ul>
<c:forEach var='saus' items='${gevondenSauzen}'>
	<li>${saus.getNaam()}</li>
	
</c:forEach>

</ul>


</body>
</html>


