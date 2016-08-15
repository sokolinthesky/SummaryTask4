<%@ include file="/WEB-INF/jspf/directive/page.jspf"%>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf"%>
<html>

<!-- head  -->
<%@ include file="/WEB-INF/jspf/head.jspf"%>

<body class="security-app">

	<!-- header  -->
	<%@ include file="/WEB-INF/jspf/header.jspf"%>

	
		<div class="lc-block">
			<form action="controller" method="post">
				<input type="hidden" name="command" value="login" />
				
				<div class="wrapper">
					<div class="material-textfield blue">
						<input type="text" name="login"  style="text-align:center" required /> <label data-content="login">login</label>
					</div>

					<div class="material-textfield red">
						<input type="password" name="password"  style="text-align:center" required /> <label data-content="password">password</label>
					</div>
				</div>
				
				<input type="submit" value="Submit" class="dropbtn">
			</form>
		
		</div>
</body>
</html>