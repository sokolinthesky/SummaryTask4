<%@ include file="/WEB-INF/jspf/directive/page.jspf"%>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	Patients<br>
	<c:forEach var="str" items="${list}">
		${str}<br>
	</c:forEach>
	<c:if test="${userRole == 'DOCTOR'}">
		Doctor content!<br>
	</c:if>
	nurse content!
</body>
</html>