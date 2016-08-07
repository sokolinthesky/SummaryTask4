<%@ include file="/WEB-INF/jspf/directive/page.jspf"%>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:forEach var="specialization" items="${specializations}">
		<a href="controller?command=listDoctorsBySpecialization&specializationId=${specialization.id}">${specialization}</a><br>  
	</c:forEach>

<a href="controller?command=listDoctors">ALL</a><br>
<!-- <a href="controller?command=listDoctorsBySpecialization&specializationId=3">SURGEON</a><br>  
<a href="controller?command=listDoctorsBySpecialization&specializationId=1">PEDIATRICIAN</a><br>
<a href="controller?command=listDoctorsBySpecialization&specializationId=2">TRAUMATOLOGIST</a><br> -->
<a href="controller?command=addUser">add user</a><br>
<a href="controller?command=listPatients">all patients</a><br>
<a href="controller?command=addPatient">add patient</a><br>
list doctors: <br>
	<c:forEach var="doctor" items="${doctors}">
		* ${doctor.firstName} ${param.patientId}
		<c:if test="${not empty param.patientId}">
			<%-- <a href="controller?command=appointDoctor&doctorId=${doctor.id}&patientId=${param.patientId}">choose doctor</a> --%>
			<form action="controller" method="post">
				<input type="hidden" name="command" value="appointDoctor">	
				<input type="hidden" name="doctorId" value="${doctor.id}">		
				<input type="hidden" name="patientId" value="${param.patientId}">
				<input type="submit" value="choose doctor">		
			</form>
		</c:if>
		<br>
	</c:forEach>
</body>
</html>