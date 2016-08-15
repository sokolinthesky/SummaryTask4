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
		<c:if test="${userRole == 'DOCTOR'}">
			<div>
				<a href="controller?command=listDischargedPatients" ><button class="dropbtn" type="button">Discharged patients</button></a> 
				<a href="controller?command=listPatientsByDoctorId"><button class="dropbtn" type="button">Patients</button></a>
			</div>
		</c:if>
		<c:if test="${userRole == 'NURSE'}">
			<a href="controller?command=listPatients"><button class="dropbtn" type="button">Patients</button></a>
		</c:if>
		<br>
		<br>
		
		<h3>Diagnosis : ${hospitalCard.diagnosis} </h3>
		<c:if test="${userRole == 'DOCTOR'}">
			<input type="button" name="ok" value="Change" onclick="showField();" class="button red small">
		
			<form action="controller" method="post">
				<input type="hidden" name="command" value="hospitalCard">
				
				<div align="center">
					<input type="text" name='diagnosis' id="field" value="${hospitalCard.diagnosis}" style="display:none; text-align:center">
					<input type="submit" id="submit" value="Edit" style="display:none;" class="button red small">
				</div>	
			</form>
			<br>
			
			<input type="button" name="ok" value="Add treatment" onclick="showAddTreatment();" class="button red small"><br><br>
			<div id="addTreatment" style="display:none;">
				<form action="controller" method="post">
					<input type="hidden" name="command" value="addTreatment">
					
					Select type of treatment:<br>
					<select id="select" name="typeOfTreatmentId">
						<c:forEach var="typeOfTreatment" items="${typesOfTreatments}">
							<option value="${typeOfTreatment.id}">${typeOfTreatment}</option>
						</c:forEach>
					</select><br><br>
					Name of medication:<br>
					<div align="center">
						<input id="fieldAdd" type="text" name="nameOfMedication" style="text-align:center">
						<input id="submitAdd" type="submit" value="Add" class="button red small"><br>
					</div>
				</form>
			</div>
			
			<form action="controller" method="post">
				<input type="hidden" name="command" value="compleateCourseOfTreatment">
				<input type="submit" value="Compleate course of treatment" class="button blue middle">
			</form>
			<br>
	</c:if>
	
	<br>
	
	<c:if test="${not empty treatments}">
		Treatments:<br>
		<table>
			<thead>
				<tr>
					<th>Type of treatment</th>
					<th>Name of treatment</th>
					<th>Done</th>
					<th></th>
				</tr>	
			</thead>
			<tbody>
				<c:forEach var="treatment" items="${treatments}">
					<tr>
						<c:if test="${userRole == 'DOCTOR'}">
							<td>
								<c:forEach var="typesOfTreatment" items="${typesOfTreatments}">
									<c:if test="${treatment.typeOfTreatmentId == typesOfTreatment.id}">
										${typesOfTreatment}
									</c:if>
								</c:forEach>
							</td>
							<td>${treatment.nameOfMedication}</td>
							
							<c:if test="${treatment.done}">
								<td bgcolor="#33cc33" >${treatment.done}</td>
							</c:if>
							<c:if test="${not treatment.done}">
								<td bgcolor="#ff3300" >${treatment.done}</td>
							</c:if>
							
							
							<td>
								<c:if test="${treatment.done == false}">	 
									<form action="controller" method="post">
										<input type="hidden" name="command" value="compleateTreatment">
										<input type="hidden" name="id" value="${treatment.id}">
										<input type="submit" value="to perform treatment">
									</form>
								</c:if>
							</td>
						</c:if>
						<c:if test="${userRole == 'NURSE' && treatment.typeOfTreatmentId ne 3}">
							<td>
								<c:forEach var="typesOfTreatment" items="${typesOfTreatments}">
									<c:if test="${treatment.typeOfTreatmentId == typesOfTreatment.id}">
										${typesOfTreatment}
									</c:if>
								</c:forEach>
							</td>
							<td>${treatment.nameOfMedication}</td>
							
							<c:if test="${treatment.done}">
								<td bgcolor="#33cc33" >${treatment.done}</td>
							</c:if>
							<c:if test="${not treatment.done}">
								<td bgcolor="#ff3300" >${treatment.done}</td>
							</c:if>
							
							<td>
								<c:if test="${treatment.done == false}">	 
									<form action="controller" method="post">
										<input type="hidden" name="command" value="compleateTreatment">
										<input type="hidden" name="id" value="${treatment.id}">
										<input type="submit" value="to perform treatment">
									</form>
								</c:if>
							</td>
						</c:if> 
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>	
	</div>
</body>
<script>
function showField() {
    document.getElementById('field').style.display='block';
    document.getElementById('submit').style.display='block';
}

function showAddTreatment() {
	document.getElementById('addTreatment').style.display='block';
}
</script>
</html>