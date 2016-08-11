<%@ include file="/WEB-INF/jspf/directive/page.jspf"%>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<script>
function showField() {
    document.getElementById('field').style.display='block';
    document.getElementById('submit').style.display='block';
}

function showAddTreatment() {
	document.getElementById('addTreatment').style.display='block';
}
</script>
<body>
patient id: ${patientId}<br>
	<form action="controller" method="post">
		<input type="hidden" name="command" value="hospitalCard">
		diagnosis : ${hospitalCard.diagnosis} <input type="button" name="ok" value="Change" onclick="showField();">
		<input type="text" name='diagnosis' id="field" value="${hospitalCard.diagnosis}" style="display:none;">
		<input type="submit" id="submit" value="Edit" style="display:none;">
	</form>
	<br>
	
	<input type="button" name="ok" value="Add treatment" onclick="showAddTreatment();"><br>
	<div id="addTreatment" style="display:none;">
		<form action="controller" method="post">
			<input type="hidden" name="command" value="addTreatment">
			Select type of treatment:<br>
			<select id="select" name="typeOfTreatmentId">
				<c:forEach var="typeOfTreatment" items="${typesOfTreatment}">
					<option value="${typeOfTreatment.id}">${typeOfTreatment}</option>
				</c:forEach>
			</select><br>
			Name of medication:<br>
			<input id="fieldAdd" type="text" name="nameOfMedication"><br>
			<input id="submitAdd" type="submit" value="Add"><br>
		</form>
	</div>
	
	<c:if test="${userRole == 'DOCTOR'}">
		<form action="controller" method="post">
			<input type="hidden" name="command" value="compleateCourseOfTreatment">
			<input type="submit" value="compleateCourseOfTreatment">
		</form>
	</c:if>
	<br>
	Treatments:<br>
	<c:forEach var="treatment" items="${treatments}">
		* ${treatment.typeOfTreatmentId} / ${treatment.done} 
		<form action="controller" method="post">
			<input type="hidden" name="command" value="compleateTreatment">
			<input type="hidden" name="id" value="${treatment.id}">
			<input type="submit" value="to perform treatment">
		</form>
		<br>
	</c:forEach>
</body>
</html>