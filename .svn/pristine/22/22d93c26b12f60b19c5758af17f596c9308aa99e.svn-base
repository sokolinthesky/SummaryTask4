<%@tag pageEncoding="UTF-8"%>
<%@tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ attribute name="treatment" required="true"
	type="ua.nure.soklakov.SummaryTask4.core.patient.Treatment"%>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf"%>

<c:if test="${userRole == 'DOCTOR'}">
	<td><c:forEach var="typesOfTreatment" items="${typesOfTreatments}">
			<c:if test="${treatment.typeOfTreatmentId == typesOfTreatment.id}">
			${typesOfTreatment}
		</c:if>
		</c:forEach></td>
	<td>${treatment.nameOfMedication}</td>

	<c:if test="${treatment.done}">
		<td bgcolor="#33cc33">${treatment.done}</td>
	</c:if>
	<c:if test="${not treatment.done}">
		<td bgcolor="#ff3300">${treatment.done}</td>
	</c:if>


	<td><c:if test="${treatment.done == false}">
			<form action="controller" method="post">
				<input type="hidden" name="command" value="compleateTreatment">
				<input type="hidden" name="id" value="${treatment.id}">
				<fmt:message key="hospital_card.submit.compleate" var="perform" />
				<input type="submit" value="${perform}" class="button red small">
			</form>
		</c:if></td>
</c:if>
<c:if test="${userRole == 'NURSE' && treatment.typeOfTreatmentId ne 3}">
	<td><c:forEach var="typesOfTreatment" items="${typesOfTreatments}">
			<c:if test="${treatment.typeOfTreatmentId == typesOfTreatment.id}">
										${typesOfTreatment}
									</c:if>
		</c:forEach></td>
	<td>${treatment.nameOfMedication}</td>

	<c:if test="${treatment.done}">
		<td bgcolor="#33cc33">${treatment.done}</td>
	</c:if>
	<c:if test="${not treatment.done}">
		<td bgcolor="#ff3300">${treatment.done}</td>
	</c:if>

	<td><c:if test="${treatment.done == false}">
			<form action="controller" method="post">
				<input type="hidden" name="command" value="compleateTreatment">
				<input type="hidden" name="id" value="${treatment.id}">
				<fmt:message key="hospital_card.submit.compleate" var="perform" />
				<input type="submit" value="${perform}" class="button red small">
			</form>
		</c:if></td>
</c:if>
