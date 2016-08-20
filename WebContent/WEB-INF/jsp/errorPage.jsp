<%@ include file="/WEB-INF/jspf/directive/page.jspf"%>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf"%>
<html>
<!-- Head -->
<c:set var="title" scope="request" value="Error page"/>
<%@ include file="/WEB-INF/jspf/head.jspf"%>
<body class="security-app">

	<!-- Header -->
	<%@ include file="/WEB-INF/jspf/header.jspf"%>

	<div class="lc-block">
		<h3><fmt:message key="error_page.title"/></h3>
		
		<c:set var="code"
				value="${requestScope['javax.servlet.error.status_code']}" />
			<c:set var="message"
				value="${requestScope['javax.servlet.error.message']}" />

			<c:if test="${not empty code}">
				<h3>
					Error code:
					<c:out value="${code}" />
				</h3>
			</c:if>

			<c:if test="${not empty message}">
				<h3>
					<c:out value="${message}" />
				</h3>
			</c:if>

			<%-- if get this page using forward --%>
			<c:if test="${not empty errorMessage}">
				<p>
					<c:out value="${errorMessage}" />
				</p>
			</c:if>
	</div>
</body>
</html>