<%@ include file="/WEB-INF/jspf/directive/page.jspf"%>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	sdfsad
	<form action="controller" method="post">
		<input type="hidden" name="command" value="login" /> <input
			type="text" name="login"><br> <input type="password"
			name="password"><br> <input type="submit" value="Submit">
	</form>
	<br>

	<select id="sel" onchange="Add()" name='choice'>
		<option value='0'>2</option>
		<option value='0'>3</option>
		<option value='1'>6</option>
	</select>
	<div id="list"></div>

</body>
<script>
	function Add() {
		var val = document.getElementById('sel').value
		var parent = document.getElementById('list');
		parent.innerHTML = '';
		if (val == '1') {
			var child = document.createElement('SELECT');
			input = parent.appendChild(child);
			input.setAttribute('id', '123');
			input.setAttribute('name', 'name' + (parent.childNodes.length - 1));
		}

	}
	Add();
</script>
</html>