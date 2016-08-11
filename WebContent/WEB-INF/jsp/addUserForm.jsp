<%@ include file="/WEB-INF/jspf/directive/page.jspf"%>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
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
<body>
	Add user:
	<form action="controller" method="post">
		<input type="hidden" name="command" value="addUser">
		Login<input type="text" name="login"><br> Password<input
			type="password" name="password"><br> First name<input type="text"
			name="firsName"><br> Last name<input type="text" name="lastName"><br>

		Role<select id="mySelect" onchange="JoinedOrNot()" name="roleId">
			<c:forEach var="role" items="${roles}">
				<option value="${role.id}">${role}</option>
			</c:forEach>
		</select><br>
		
		Specialization<select id="mySelect1" name="specializationId">
			<c:forEach var="specialization" items="${specializations}">
				<option value="${specialization.id}">${specialization}</option>
			</c:forEach>
		</select><br>
		
		<input type="submit" value="submit">
	</form>
</body>
</html>