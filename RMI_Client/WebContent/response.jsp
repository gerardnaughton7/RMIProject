<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Response</title>
</head>
<body>
	<center>
		<table border="2px solid black" width= 600px>
			<tr>
				<td>
					<h1 align="center">Dictionary Service</h1>
					<br/>
					<h3>Response:</h3>
							<%
							String word = (String)request.getAttribute("word");
							String definition = (String)request.getAttribute("definition");
							
							if(definition == null)
							{
								
							}
							else
							{
								out.print("Word: " + word);
								out.print("<br/>");
								out.print(definition);
							}
							%>
					<br/>
					<br/>		
					<p align="center"><a href="index.jsp" id="NavToIndex" >Make another Query</a></p>
				</td>
			</tr>
		</table>
	</center>
</body>
</html>