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
		<div>
			<a href="controller?command=listDischargedPatients" ><button class="dropbtn" type="button"><fmt:message key="hospital_card.button.discharged_patients"/></button></a> 
			<a href="controller?command=listPatientsByDoctorId"><button class="dropbtn" type="button"><fmt:message key="hopital_card.button.patients"/></button></a>
		</div><br>
		
		<table id="patients" class="tablesorter">
			<thead>
				<tr>
					<th><fmt:message key="dischatged_patients.table.first_name"/></th>
					<th><fmt:message key="dischatged_patients.table.last_name"/></th>
					<th><fmt:message key="dischatged_patients.table.birthday"/></th>
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
						<form action="controller" method="post">
							<input type="hidden" name="command" value="downloadFile">
							<input type="hidden" name="firstName" value="${patient.firstName}">
							<input type="hidden" name="lastName" value="${patient.lastName}">
							<fmt:message key="dischatged_patients.sabmit.download" var="download"/>
							<input type="submit" value="${download}" class="button red small">
						</form>
					</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
</body>
<script type="text/javascript">
	$(document).ready(function() 
		    { 
		        $("#patients").tablesorter(); 
		    } 
		);
	</script>
</html>