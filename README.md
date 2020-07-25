# gerenciamento-pessoas
Crud básico em Java e Spring Boot para gerenciamento de pessoas. 

 
## Endpoints gerenciamento-pessoas

### Requisição - Busca todos os registros

`GET /`
  
````
  http://localhost:8080/api/v1/person
````
  
`[Response - Status 200 OK]`

````
[
    {
        "name": "name",
        "cpf": "709.998.950-28",
        "active": true
    }
]
````
`[Response - Status 400 Bad Request]`

````
{
    "path": "/api/v1/person/",
    "message": "No registration found."
}
````


### Requisição - busca todos os registros - inactive ou active

`GET /get?status=`
  
````
  http://localhost:8080/api/v1/person/get?status=active
````
  
`[Response - Status 200 OK]`

````
[
    {
        "name": "name",
        "cpf": "709.998.950-28",
        "active": true
    }
]
````
`[Response - Status 400 Bad Request]`

````
{
    "path": "/api/v1/person/get",
    "message": "No registration found."
}
````

`GET /get?status=`
  
````
  http://localhost:8080/api/v1/person/get?status=inactive
````
  
`[Response - Status 200 OK]`

````
[
    {
        "name": "name",
        "cpf": "709.998.950-28",
        "active": false
    }
]
````
`[Response - Status 400 Bad Request]`

````
{
    "path": "/api/v1/person/get",
    "message": "No registration found."
}
````

````
  http://localhost:8080/api/v1/person/get?status=invalido
````

`[Response - Status 400 Bad Request]`

````
{
    "path": "/api/v1/person/get",
    "message": "Parameter {invalido} not identify"
}
````

### Requisição - Novo registro

`POST /new`
  
````
  http://localhost:8080/api/v1/person/new
````
  
`[Request Body]`

````
{
    "name":"name",
    "lastname":"last name",
    "cpf":"709.998.950-28"
}
````
`[Response - Status 201 Created]`

````
{
    "name":"name",
    "lastname":"last name",
    "cpf":"709.998.950-28"
}
````
