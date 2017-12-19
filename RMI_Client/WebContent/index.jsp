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
	<table border="2px solid black">
		<tr>
			<td>
				<h1>RMI Dictionary LookUp</h1>
				<form action = "DictionaryServlet" method = "post">
				   Enter Word: 
				   <input type = "text" name = "word" />
				   <br />
				   <input type = "submit" value = "Submit" />
				</form>
			</td>
		</tr>
		<tr>
			<td>
				<h3>Jobs in Queue</h3>
  				<%BlockingQueue<Job> jobList = (ArrayBlockingQueue<Job>)request.getAttribute("jobList");
 				if(jobList == null){
 				
 				}
 				else
 				{
 					Iterator<Job> it = jobList.iterator();
 				    while(it.hasNext()){
 				     out.print("<br/>");
 				     out.print("Id: " + it.next().toString());
					 out.print("<br/>");
					 out.print("<br/>");
 				    }
					 
				}
 				
				%>
				
			</td>
		</tr>
		<tr>
			<td>
				<h3>Meaning of your Word</h3>
				
			</td>
		</tr>
	</table>
</center>

</body>
</html>