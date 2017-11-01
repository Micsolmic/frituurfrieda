<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>

<!DOCTYPE html>
<html>
<c:import url='/WEB-INF/JSP/fridahead.jsp'>
	<c:param name="title" value="fridas sauzenz"/>
</c:import>
<body>




<c:forEach var='saus' items='${sauzen}'>
	
	<span>${saus.naam}</span>

</c:forEach>


<p>blaff</p>
<h1>${tel}</h1>
<h2>${initParam.tel}</h2>
<h2>${novotel}</h2>
</body>
</html>


