Admin panel for online shopping store.

CRUD operations for users, products, orders.

1. Run MySQL:
	
	$ docker run --name mysql -e MYSQL_ROOT_PASSWORD=admin -d mysql

2. Put MySQL IP to dao/src/main/resources/context-dao.xml datasource#url
3. Build the project
    
    $ mvn clean package

4. Build app Docker image:

    $ cd web && docker build .
    
5. Run app container:

    $ docker run -p 8888:8080 ${image_id_from_step_4}

UI: http://localhost:8888/web-1.0-SNAPSHOT/users/view
Get all users: http://localhost:8888/web-1.0-SNAPSHOT/users/all
Create user:
    
    POST http://localhost:8888/web-1.0-SNAPSHOT/users
    {
    	"firstName": "John",
    	"lastName": "Doe",
    	"age": "42"
    }
