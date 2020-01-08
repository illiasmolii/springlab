Admin panel for online shopping store.

CRUD operations for users, products, orders.

1. Build the project
    
    $ mvn clean package

2. Create a network:
    
    $ docker network create local
    
3. Run containers (MySQL & App):

    $ docker run --network=local --name=mysql -v ${project_path}/database/src/main/resources/startup:/docker-entrypoint-initdb.d -e MYSQL_ROOT_PASSWORD=admin -e MYSQL_DATABASE=springlab -d mysql:latest
    $ docker run -p 8888:8080 --network=local illiasmolii/test:1.0-SNAPSHOT

UI: http://localhost:8888/web-1.0-SNAPSHOT/users/view

Get all users: http://localhost:8888/web-1.0-SNAPSHOT/users/all

Create user:
    
    POST http://localhost:8888/web-1.0-SNAPSHOT/users
    {
    	"firstName": "John",
    	"lastName": "Doe",
    	"age": "42"
    }
