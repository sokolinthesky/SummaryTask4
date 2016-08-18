<%@ include file="/WEB-INF/jspf/directive/page.jspf"%>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf"%>
<html>
<!-- Head -->
<%@ include file="/WEB-INF/jspf/head.jspf"%>
<body class="security-app">

	<!-- Header -->
	<%@ include file="/WEB-INF/jspf/header.jspf"%>

	<div class="lc-block">
	
		<%@ include file="/WEB-INF/jspf/adminMenu.jspf"%>
		
		${errorMessage}
		<form action="controller" method="post">
			<input type="hidden" name="command" value="addPatient">
			
			<div class="wrapper">
				<div class="material-textfield blue">
					<fmt:message key="patiet_form.input.first_name" var="firstName" />
					<input type="text" name="firstName"  style="text-align:center" required /> <label data-content="${firstName}">first name</label>
				</div>
				
				<div class="material-textfield blue">
					<fmt:message key="patiet_form.input.last_name" var="lastName" />
					<input type="text" name="lastName"  style="text-align:center" required /> <label data-content="${lastName}">last name</label>
				</div>
			</div>
			
			<fmt:message key="patiet_form.input.birthday" />:<br>
			<input type="date" name="date">
			<br>
			<br>
			
			<fmt:message key="patiet_form.submit" var="submit" />
			<input type="submit" value="${submit}" class="button red middle">
		</form>
		
	</div>
</body>
</html>