# Read Me

### Checkstyle
The project has a checkstyle.xml file. To run it, execute the command: 
* mvn checkstyle:check

### Docker
To run Docker, you need to execute the following commands (assuming that you have PostgreSQL and MongoDB containers running):
* docker build -t marketplace-application .
* docker run -d -p 8080:8080 --name marketplace-container --link [postgresql_container_name]:postgres --link [mongodb_container_name]:mongo marketplace-application