<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.concurrent.ArrayBlockingQueue"%>
<%@page import="ie.gmit.sw.Job"%>
<%@page import="java.util.concurrent.BlockingQueue"%>
<%@page import="java.util.Iterator"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>RMI Dictionary LookUp</title>
</head>
<body>
<center>
	<table  border="2px solid black" width= 600px>
		<tr >
			<td>
				<h1 align="center">RMI Dictionary LookUp</h1>
				<form action = "DictionaryServlet" method = "post">
				   <center>
					   <p >Enter Word:</p> 
					   <input type = "text" name = "word" />
					   <br />
					   <br />
					   <input type = "submit" value = "Submit" />
				   </center>
				</form>
			</td>
		</tr>
	</table>
</center>

</body>
</html>