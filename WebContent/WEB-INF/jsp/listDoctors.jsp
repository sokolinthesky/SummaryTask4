<%@ include file="/WEB-INF/jspf/directive/page.jspf"%>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="controller?command=listDoctors">ALL</a><br>
<a href="controller?command=listDoctorsBySpecialization&specializationId=3">SURGEON</a><br>  
<a href="controller?command=listDoctorsBySpecialization&specializationId=1">PEDIATRICIAN</a><br>
<a href="controller?command=listDoctorsBySpecialization&specializationId=2">TRAUMATOLOGIST</a><br>
list doctors: <br>
	<c:forEach var="doctor" items="${doctors}">
		* ${doctor.firstName}<br>
	</c:forEach>
</body>
</html>