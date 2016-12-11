# Distributed Systems Project
Fourth Year Project for Distributed Systems Module
<br>
G00312351
Martin Coleman

This project is An Asynchronous RMI String Comparison Service for my fourth year Distributed Systems project.
It compares two strings to find their distance using string comparison algorithms.	

#StringService.jar
This jar file contains the RMI service for comparing strings.
Also contains server and client for testing RMI service

#Comparator.war
This war file is for deployment on a tomcat server.
It contains all the files for handling the queuing of requests to the RMI Service.
QueueManager Handles requests to the RMI Service.

#src
Contains all of my source code

#Run the program
In the project directory run:

java –cp ./string-service.jar ie.gmit.sw.Servant

This should start up the RMI service on port 1099

Tomcat:

Startup your tomcat server by running Startup.bat in tomcats bin folder.

Place the comparator.war file into the webapps folder of the Tomcat server.

then navigate to the link below to view the JSP page:

http://127.0.0.1:8080/comparator/
