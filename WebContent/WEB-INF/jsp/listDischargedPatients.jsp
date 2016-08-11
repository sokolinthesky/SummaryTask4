<%@ include file="/WEB-INF/jspf/directive/page.jspf"%>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:forEach var="patient" items="${patients}">
		* ${patient.firstName} 
		<form action="controller" method="post">
			<input type="hidden" name="command" value="downloadFile">
			<input type="hidden" name="firstName" value="${patient.firstName}">
			<input type="hidden" name="lastName" value="${patient.lastName}">
			<input type="submit" value="download">
		</form>
	</c:forEach>
</body>
</html>