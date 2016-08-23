<%@ include file="/WEB-INF/jspf/directive/page.jspf"%>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf"%>
<html>
<!-- Head -->
<c:set var="title" scope="request" value="Add user"/>
<%@ include file="/WEB-INF/jspf/head.jspf"%>
<body class="security-app">
	
	<!-- Header -->
	<%@ include file="/WEB-INF/jspf/header.jspf"%>

	<div class="lc-block">
	
		<!-- Menu -->
		<%@ include file="/WEB-INF/jspf/adminMenu.jspf"%>
	
		<!-- Error message if there is -->
		<c:if test="${not empty errorMessage}">
				<p>
					<c:out value="${requestScope.errorMessage}" />
				</p>
		</c:if>
		
		<!-- Add user form -->
		<form action="controller" method="post">
			<input type="hidden" name="command" value="addUser">
			
			<div class="wrapper">
				<div class="material-textfield blue">
					<fmt:message key="user_form.input.login" var="login"/>
					<input type="text" name="login"  style="text-align:center" required /> <label data-content="${login}">login</label>
				</div>
	
				<div class="material-textfield red">
					<fmt:message key="user_form.input.password" var="password"/>
					<input type="password" name="password"  style="text-align:center" required /> <label data-content="${password}">password</label>
				</div>
				
				<div class="material-textfield blue">
					<fmt:message key="user_form.input.first_name" var="firstName"/>
					<input type="text" name="firsName"  style="text-align:center" required /> <label data-content="${firstName}">first name</label>
				</div>
				
				<div class="material-textfield blue">
					<fmt:message key="user_form.input.last_name" var="lastName"/>
					<input type="text" name="lastName"  style="text-align:center" required /> <label data-content="${lastName}">last name</label>
				</div>
				
				
				<fmt:message key="user_form.input.email"/>:<input type="checkbox" checked="checked" onclick="this.nextSibling.style.display=this.checked?'':'none';"><div class="material-textfield blue">
					<fmt:message key="user_form.input.email" var="email"/>
					<input type="text" name="email" value="" style="text-align:center" /> <label data-content="${email}">email</label>
				</div><br>
				
			</div>
	
			
			<fmt:message key="user_form.input.role"/>:<br>
			<select id="roleSelect" onchange="JoinedOrNot()" name="roleId">
				<c:forEach var="role" items="${roles}">
					<c:if test="${role ne 'ADMIN'}">
						<option value="${role.id}">${role}</option>
					</c:if>
				</c:forEach>
			</select>
			<br>
			<br>
	
			<fmt:message key="user_form.input.specialization"/>:<br>
			<select id="specSelect" name="specializationId">
				<c:forEach var="specialization" items="${specializations}">
					<option value="${specialization.id}">${specialization}</option>
				</c:forEach>
			</select>
			<br>
			<br>
			
			<fmt:message key="user_form.submit" var="submit"/>
			<input type="submit" value="${submit}" class="button red middle">
		</form>
	</div>
</body>
<script>
	function JoinedOrNot() {
		var cat = document.getElementById("roleSelect");
		if (cat.value == "1") {
			document.getElementById("specSelect").disabled = false;
		} else {
			document.getElementById("specSelect").disabled = true;
		}
	}
</script>
</html>