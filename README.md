# Docentes-Soap
 Docentes-Soap

 --> install 
 
 mvn clean install -DskipTests
 
 --> ejecturar

java -jar target/jee-7-1.0-SNAPSHOT.jar
 
 
 TEST
 
 http://docentes-soap-api.herokuapp.com:8080/employeeservice?wsdl
 
 
## Docker Compose:

1. Generar jar:

         mvn clean install -DskipTests

2. Correr:

         docker-compose up -d