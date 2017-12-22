<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Waiting Page</title>
</head>
<body>
	<center>
		<table border="2px solid black" width= 600px>
			<tr>
				<td>
					<form name="doGetForm" method="get" action="DictionaryServlet">
						<input name="ID" value=<%=request.getAttribute("ID") %> type="hidden">
					</form>
					<h1>Dictionary Service</h1>
					<br/>
					<h3>Waiting for Response .........</h3>
				</td>
			</tr>
		</table>
	</center>
	<script type="text/javascript">
	
	document.doGetForm.submit();
	
	</script>
</body>
</html>