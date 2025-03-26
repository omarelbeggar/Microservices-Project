# Microservices-Project
This is an example of a microservices-based project.
The project contains the following microservices:
<ul>
<li>Client-SERVICE</li>
<li>Commande-SERVICE</li>
<li>Discovery-SERVICE</li>
<li>Gateway-SERVICE</li>
  </ul>
The inter-communication between microservices is assumed using RESTTEMPLATE.
<br>Meanwhile, the used dbms for the both microservices is postgres with two databases (clientdb and commandedb). Each one includes one table client(id: integer,nom: text) and commande(id:integer,datecmd: date, idc:integer) respectively.
<br>The application.properties contain the necessary configuration for connection to the databases.
