<%@ include file="/WEB-INF/jspf/directive/page.jspf"%>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf"%>
<html>

<!-- head  -->
<%@ include file="/WEB-INF/jspf/head.jspf"%>

<body class="security-app">

	<!-- header  -->
	<%@ include file="/WEB-INF/jspf/header.jspf"%>

	
		<div class="lc-block">
			<c:if test="${not empty error}">
				<c:out value="${error}"></c:out>
			</c:if>
			<form action="controller" method="post">
				<input type="hidden" name="command" value="login" />
				
				<div class="wrapper">
					<div class="material-textfield blue">
						<fmt:message key="login.login" var="login" />
						<input type="text" name="login"  style="text-align:center" required /> <label data-content="${login}">login</label>
					</div>

					<div class="material-textfield red">
						<fmt:message key="login.password" var="password" />
						<input type="password" name="password"  style="text-align:center" required /> <label data-content="${password}">password</label>
					</div>
				</div>
				
				<fmt:message key="login.submit" var="submit" />
				<input type="submit" value="${submit}" class="dropbtn">
			</form>
		
		</div>
</body>
</html>