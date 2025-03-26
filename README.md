# Microservices-Project
This is an example of a microservices-based project.
The project contains the following microservices:
-Client-SERVICE
-Commande-SERVICE
-Discovery-SERVICE
-Gateway-SERVICE
The inter-communication between microservices is assumed using RESTTEMPLATE.
Meanwhile, the used dbms for the both microservices is postgres with two databases (clientdb and commandedb). Each one includes one table client(id: integer,nom: text) and commande(id:integer,datecmd: date, idc:integer) respectively.
The application.properties contain the necessary configuration to the databases.
