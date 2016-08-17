<%@ include file="/WEB-INF/jspf/directive/page.jspf"%>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf"%>
<html>
<!-- Head -->
<%@ include file="/WEB-INF/jspf/head.jspf"%>
<body class="security-app">
	
	<%@ include file="/WEB-INF/jspf/header.jspf"%>

	<div class="lc-block">
	
		<%@ include file="/WEB-INF/jspf/adminMenu.jspf"%>
	
		${requestScope.errorMessage}
		
		<form action="controller" method="post">
			<input type="hidden" name="command" value="addUser">
			
			<div class="wrapper">
				<div class="material-textfield blue">
					<input type="text" name="login"  style="text-align:center" required /> <label data-content="login">login</label>
				</div>
	
				<div class="material-textfield red">
					<input type="password" name="password"  style="text-align:center" required /> <label data-content="password">password</label>
				</div>
				
				<div class="material-textfield blue">
					<input type="text" name="firsName"  style="text-align:center" required /> <label data-content="first name">first name</label>
				</div>
				
				<div class="material-textfield blue">
					<input type="text" name="lastName"  style="text-align:center" required /> <label data-content="last name">last name</label>
				</div>
				
				
				Email:<input type="checkbox" checked="checked" onclick="this.nextSibling.style.display=this.checked?'':'none';"><div class="material-textfield blue">
					<input type="text" name="email" value="" style="text-align:center" /> <label data-content="email">email</label>
				</div><br>
				
			</div>
	
			
			ROLE:<br>
			<select id="mySelect" onchange="JoinedOrNot()" name="roleId">
				<c:forEach var="role" items="${roles}">
					<c:if test="${role ne 'ADMIN'}">
						<option value="${role.id}">${role}</option>
					</c:if>
				</c:forEach>
			</select>
			<br>
			<br>
	
			SPECIALIZATION:<br>
			<select id="mySelect1" name="specializationId">
				<c:forEach var="specialization" items="${specializations}">
					<option value="${specialization.id}">${specialization}</option>
				</c:forEach>
			</select>
			<br>
			<br>
			
			<input type="submit" value="ADD USER" class="button red middle">
		</form>
	
	</div>
</body>
<script>
	function JoinedOrNot() {
		var cat = document.getElementById("mySelect");
		if (cat.value == "1") {
			document.getElementById("mySelect1").disabled = false;
		} else {
			document.getElementById("mySelect1").disabled = true;
		}
	}
</script>
</html>