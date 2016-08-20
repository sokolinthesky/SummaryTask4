<%@ include file="/WEB-INF/jspf/directive/page.jspf"%>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf"%>
<%@ taglib prefix="user" tagdir="/WEB-INF/tags"%>
<html>
<!-- head  -->
<c:set var="title" scope="request" value="Doctors"/>
<%@ include file="/WEB-INF/jspf/head.jspf"%>
<body class="security-app">

	<!-- Header  -->
	<%@ include file="/WEB-INF/jspf/header.jspf"%>

	<div class="lc-block">
		
		<!-- Menu -->
		<%@ include file="/WEB-INF/jspf/adminMenu.jspf"%>
		
		<!-- Doctors table -->
		<table id="doctors" class="tablesorter">
		<thead>
			<tr>
				<th><fmt:message key="doctors.table.login"/></th>
				<th><fmt:message key="doctors.table.first_name"/></th>
				<th><fmt:message key="doctors.table.last_name"/></th>
				<th><fmt:message key="doctors.table.specialization"/></th>
				<th><fmt:message key="doctors.table.count_of_patients"/></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="doctor" items="${doctors}">
				<tr>
					<user:doctor doctor="${doctor}"/>
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