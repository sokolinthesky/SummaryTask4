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
				<a href="controller?command=listDischargedPatients" ><button class="dropbtn" type="button"><fmt:message key="hospital_card.button.discharged_patients"/></button></a> 
				<a href="controller?command=listPatientsByDoctorId"><button class="dropbtn" type="button"><fmt:message key="hopital_card.button.patients"/></button></a>
			</div>
		</c:if>
		<c:if test="${userRole == 'NURSE'}">
			<a href="controller?command=listPatients"><button class="dropbtn" type="button"><fmt:message key="hopital_card.button.patients"/></button></a>
		</c:if>
		<br>
		<br>
		
		${errorMessage}
		<h3><fmt:message key="hospital_card.diagnosis"/> : ${hospitalCard.diagnosis} </h3>
	
		<c:if test="${userRole == 'DOCTOR'}">
			<fmt:message key="hospital_card.button.change" var="change"/>
			<input type="button" name="ok" value="${change}" onclick="showField();" class="button red small">
		
			<form action="controller" method="post">
				<input type="hidden" name="command" value="hospitalCard">
				
				<div align="center">
					<input type="text" name='diagnosis' id="field" value="${hospitalCard.diagnosis}" style="display:none; text-align:center">
					
					<fmt:message key="hospitl_card.submit.edit" var="edit"/>
					<input type="submit" id="submit" value="${edit}" style="display:none;" class="button red small">
				</div>	
			</form>
			<br>
			
			<fmt:message key="hospital_card.button.add_treatment" var="addTreatment"/>
			<input type="button" name="ok" value="${addTreatment}" onclick="showAddTreatment();" class="button red small"><br><br>
			<div id="addTreatment" style="display:none;">
				<form action="controller" method="post">
					<input type="hidden" name="command" value="addTreatment">
					
					<fmt:message key="hospital_card.select_type_of_treatment"/>:<br>
					<select id="select" name="typeOfTreatmentId">
						<c:forEach var="typeOfTreatment" items="${typesOfTreatments}">
							<option value="${typeOfTreatment.id}">${typeOfTreatment}</option>
						</c:forEach>
					</select><br><br>
					<fmt:message key="hospital_card.name_of_medication"/>:<br>
					<div align="center">
						<input id="fieldAdd" type="text" name="nameOfMedication" style="text-align:center">
						<fmt:message key="hospitl_card.submit.add" var="add"/>
						<input id="submitAdd" type="submit" value="${add}" class="button red small"><br>
					</div>
				</form>
			</div>
			
			<form action="controller" method="post">
				<input type="hidden" name="command" value="compleateCourseOfTreatment">
				<fmt:message key="hospital_card.submit.compleate" var="compleate"/>
				<input type="submit" value="${compleate}" class="button blue middle">
			</form>
			<br>
	</c:if>
	
	<br>
	
	<c:if test="${not empty treatments}">
		<fmt:message key="hospital_card.treatments"/>:<br>
		<table>
			<thead>
				<tr>
					<th><fmt:message key="hospital_card.table.type_of_treatment"/></th>
					<th><fmt:message key="hospital_card.table.name_of_treatment"/></th>
					<th><fmt:message key="hospital_card.table.done"/></th>
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
										<fmt:message key="hospital_card.submit.compleate" var="perform"/>
										<input type="submit" value="${perform}">
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
										<fmt:message key="hospital_card.submit.compleate" var="perform"/>
										<input type="submit" value="${perform}">
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