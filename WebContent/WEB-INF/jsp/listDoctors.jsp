<%@ include file="/WEB-INF/jspf/directive/page.jspf"%>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf"%>
<html>

<!-- head  -->
<%@ include file="/WEB-INF/jspf/head.jspf"%>
<body class="security-app">

	<!-- Header  -->
	<%@ include file="/WEB-INF/jspf/header.jspf"%>

	<div class="lc-block">
		
		<%@ include file="/WEB-INF/jspf/adminMenu.jspf"%>
		
		<!-- Doctors table -->
		<table id="doctors" class="tablesorter" align="center">
		<thead>
			<tr>
				<th>Login</th>
				<th>First name</th>
				<th>Last name</th>
				<th>Specialization</th>
				<th>Count of patients</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="doctor" items="${doctors}">
				<tr>
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
								<input type="submit" value="slect" class="button red small">
							</form>
						</c:if>
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
		        $("#doctors").tablesorter(); 
		    } 
		);
	
	$(document).ready(function(){
		  $(".dropdown").on("hide.bs.dropdown", function(){
		    $(".btn").html('Dropdown <span class="caret"></span>');
		  });
		  $(".dropdown").on("show.bs.dropdown", function(){
		    $(".btn").html('Dropdown <span class="caret caret-up"></span>');
		  });
		});
</script>
</html>