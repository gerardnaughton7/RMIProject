# RMIProject
Distributed Systems Assignment

## [Contents](#contents)
[Introduction](#intro)  
[OverView](#overview)
[Technology](#tech)                     
[How to run Repository](#repo)  
[Conclusion](#con)   
[References](#ref) 

## Introduction <a name = "intro"></a>


## OverView <a name = "overview"></a>

### The OverView of our Project

You are required to use the Servlet/JSP and Java RMI frameworks to develop a remote, asynchronous dictionary
lookup service. A JSP page should provide users with the ability to specify a string which will be checked
against the dictionary. The HTML form information should be dispatched to a servlet that adds the client request
to an in-queue and then returns a job ID to the web client. The web client should poll the web server periodically
(every 10 seconds) and query if the request has been processed. Client requests in the inQueue should
be periodically removed and processed (every 10 seconds).
The processing of a client request will require a RMI method invocation to a remote object which implements
an interface called DictionaryService. The remote object which implements DictionaryService should check
if the string received exists in the dictionary, and return the dictionary definition of the string if it does exist in
the dictionary, or “String not found” if it does not exist in the dictionary. Once the result of the dictionary lookup
has been computed by the remote object, the returned response should be added to the outQueue on the Tomcat
server and returned to the original web client when they next poll the server. The following diagram depicts the
overall system architecture:

<p align="center"><img src="img/diagram.png" width="300" length="300"></p>

## Technology <a name = "tech"></a>


## How to run Repositiory <a name = "repo"></a>


## Conclusion <a name = "con"></a>


## References <a name = "ref"></a>
