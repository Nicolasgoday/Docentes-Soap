# Docentes-Soap
 Docentes-Soap

 --> install 
 
 mvn clean install -DskipTests
 
 --> ejecturar

java -jar target/docentesoap-v0.0.1.jar
 
 
 TEST
 
 http://docentes-soap-api.herokuapp.com:8080/employeeservice?wsdl
 
 
## Docker Compose:

1. Generar jar:

         mvn clean install -DskipTests

2. Correr:

         docker-compose up -d