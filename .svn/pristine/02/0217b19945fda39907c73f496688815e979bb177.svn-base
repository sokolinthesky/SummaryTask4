<%@tag pageEncoding="UTF-8"%>
<%@tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ attribute name="doctor" required="true" type="ua.nure.soklakov.SummaryTask4.core.user.User"%>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf"%>

<td>${doctor.login}</td>
<td>${doctor.firstName}</td>
<td>${doctor.lastName}</td>
<td>
	<c:forEach var="specialization" items="${specializations}">
		<c:if test="${doctor.specializationId == specialization.id}">
			${specialization}
		</c:if>
	</c:forEach>
</td>
<td>${doctor.countOfPatients}</td>
<td>
	<c:if test="${not empty param.patientId}">
		<form action="controller" method="post">
			<input type="hidden" name="command" value="appointDoctor">
			<input type="hidden" name="doctorId" value="${doctor.id}">
			<input type="hidden" name="patientId" value="${param.patientId}">
			<fmt:message key="doctors.submit.select" var="select"/>
			<input type="submit" value="${select}" class="button red small">
		</form>
	</c:if>
</td>