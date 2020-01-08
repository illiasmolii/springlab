Admin panel for online shopping store.

CRUD operations for users, products, orders.

To build and run the project execute dev-env.sh script

UI: http://localhost:8888/web-1.0-SNAPSHOT/users/view

Get all users: http://localhost:8888/web-1.0-SNAPSHOT/users/all

Create user:
    
    POST http://localhost:8888/web-1.0-SNAPSHOT/users
    {
    	"firstName": "John",
    	"lastName": "Doe",
    	"age": "42"
    }
