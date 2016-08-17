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
					<input type="text" name="firstName"  style="text-align:center" required /> <label data-content="first name">first name</label>
				</div>
				
				<div class="material-textfield blue">
					<input type="text" name="lastName"  style="text-align:center" required /> <label data-content="last name">last name</label>
				</div>
			</div>
			
			Birthday:<br>
			<input type="date" name="date">
			<br>
			<br>
			
			<input type="submit" value="Add patient" class="button red middle">
		</form>
		
	</div>
</body>
</html>