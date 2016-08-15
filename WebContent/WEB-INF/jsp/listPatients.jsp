<%@ include file="/WEB-INF/jspf/directive/page.jspf"%>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf"%>
<html>

<!-- Head -->
<%@ include file="/WEB-INF/jspf/head.jspf"%>
<body class="security-app">
	
	<!-- Header -->
	<%@ include file="/WEB-INF/jspf/header.jspf"%>
	
	<div class="lc-block">
	
		<!-- Menu  -->
		<c:if test="${userRole == 'ADMIN'}">
			<%@ include file="/WEB-INF/jspf/adminMenu.jspf"%>
		</c:if>
		<c:if test="${userRole == 'DOCTOR'}">
			<div>
				<a href="controller?command=listDischargedPatients" ><button class="dropbtn" type="button">Discharged patients</button></a> 
				<a href="controller?command=listPatientsByDoctorId"><button class="dropbtn" type="button">Patients</button></a>
			</div><br>
		</c:if>
		
		<c:if test="${not empty patients}">
			<table id="patients" class="tablesorter">
				<thead>
					<tr>
						<th>First name</th>
						<th>Last name</th>
						<th>Birthday</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="patient" items="${patients}">
						<tr>
							<td>${patient.firstName}</td>
							<td>${patient.lastName}</td>
							<td>${patient.birthday}</td>
							<td>
								<c:if test="${userRole == 'ADMIN' && patient.doctorId == 0}">
									<a href="controller?command=listDoctors&patientId=${patient.id}"><button class="button red small"
										type="button">set doctor</button></a>
								</c:if>
						
						
								<c:if test="${userRole == 'DOCTOR' || userRole == 'NURSE'}">
									<form action="controller" method="get">
										<input type="hidden" name="command" value="hospitalCard">
										<input type="hidden" name="hospitalCardId" value="${patient.cardId}">
										<input type="submit" value="Hospital Card" class="button red small">
									</form>
								</c:if>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
	</div>
	
	<script type="text/javascript">
	$(document).ready(function() 
		    { 
		        $("#patients").tablesorter(); 
		    } 
		);
	</script>
</html>