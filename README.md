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
<br>*************************************************************************************************
<br> <b>To download the project's microservices, you should follow those steps: </b>
<ol>
  <li>Open Git Bash.</li>
  <li>Change the current working directory to the location where you want the cloned directory.</li>
  <li>Type git clone, and then paste the URL you copied from repo code  as follows:
  <br>git clone https://github.com/omarelbeggar/Microservices-Project.git</li>
  <li>Open Eclipse and import a new maven project for each microservice.li>
</ol>
