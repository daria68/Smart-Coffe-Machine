# Coffee Machine APIs doc

### Packages quick review
1. com.ip.CaffeMachine.Controller - the one with the endpoints
2. com.ip.CaffeMachine.Request - json models for input APIs
3. com.ip.CaffeMachine.Response - json models for output APIs
4. com.ip.CaffeMachine.Models - database entities (direct relationships with them)
5. com.ip.CaffeMachine.Repo - services for database queries (direct relationship with the database)
6. com.ip.CaffeMachine.Exception - custom exception for throwing without stack trace
   
#### Used API for taking the real coffe recipes
[https://api.sampleapis.com/coffee/hot](https://api.sampleapis.com/coffee/hot)

#### Database design link [here](https://drawsql.app/--376/diagrams/ip#)

#### Real data about tea drinks [here](https://tea-api-vic-lo.herokuapp.com/#) 

## Endpoints

GET: Welcome message ```http://localhost:8080/welcome```

POST: User registration ```http://localhost:8080/users/register```

GET: User login ```http://localhost:8080/users/login```

GET: User logout ```http://localhost:8080/users/logout```

PUT: Update user day interval (the interval is used for not letting the user make a drink with coffe after a set hour)

```http://localhost:8080/users/day/interval```

DELETE: Delete user from DB ```http://localhost:8080/users/delete/userId```

PUT: Update user name or password ```http://localhost:8080/users/update/userId```

POST: Create a program ```http://localhost:8080/programs/create```

PUT: Update a program by id ```http://localhost:8080/programs/programId```

DELETE: Delete a program by id ```http://localhost:8080/programs/delete/programId```

GET: Get json for a program by id ```http://localhost:8080/programs/programId```


GET: Make drink now (nothing is saved in the DB, just verifies if is time for making coffee or not - output: json for UI machine to display) ```http://localhost:8080/make```

GET: Make drink from program (make a drink after a program from the database - output: json for UI machine to display) ```http://localhost:8080/make/program/programId```

POST: Insert drinks recipes in the database ```http://localhost:8080/recipes/insert``` PS: *You need to do this when you make a new DB or work on a empty one*