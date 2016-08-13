<%@ include file="/WEB-INF/jspf/directive/page.jspf"%>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<a href="controller?command=logout" >Logout</a><br>
	<c:if test="${userRole == 'DOCTOR'}">
		<a href="controller?command=listDischargedPatients" >Discharged patients</a><br>
	</c:if>
	Patients:<br>
	<c:forEach var="patient" items="${patients}">
		* ${patient.firstName}
		<c:if test="${userRole == 'ADMIN'}">
			<a href="controller?command=listDoctors&patientId=${patient.id}">set doctor</a>
		</c:if>
		<c:if test="${userRole == 'DOCTOR' || userRole == 'NURSE'}">
			<form action="controller" method="get">
				<input type="hidden" name="command" value="hospitalCard">
				<input type="hidden" name="hospitalCardId" value="${patient.cardId}">
				<input type="submit" value="Hospital Card">
			</form><br>
		</c:if>
		<br>
	</c:forEach>
</html>