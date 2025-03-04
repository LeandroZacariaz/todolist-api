
# Todo List API

API RESTful que permite a los usuarios gestionar su lista de tareas de manera eficiente. Los usuarios pueden registrarse, loguearse y realizar operaciones CRUD sobre sus tareas.

## Características

- Los usuarios pueden registrarse y loguearse.
- Autenticación y autorización con JWT.
- Operaciones CRUD para tareas (crear, leer, actualizar y eliminar).
- Documentación con Swagger.

## Tecnologías Utilizadas
- Java 21

- Spring Boot 3.3.5

- Spring Security

- JWT

- Maven

- Docker

- MySQL

- Swagger


## Dependencias 📦

| Dependencia | Versión     |
| :--------   | :-------    |
| Springdoc OpenAPI Starter WebMvc UI  | 2.5.0    | 
| Spring Boot Starter Web   | 3.3.5    |
| Spring Boot Starter Validation  | 3.3.5    |
| Spring Boot Starter Security| 3.3.5 |
| Spring Boot Starter Data JPA   | 3.3.5   |
| Spring Boot DevTools   | 3.3.5    |
| Spring Boot Starter Test | 3.3.5 |
| JWT | 0.11.5 |
| Lombok   | 1.18.34    |
| MySQL Connector-J   | 8.3.0    |
| MapStruct  | 1.5.5   |
| MapStruct Processor    | 1.5.5.Final    |



## Instalación

### Prerrequisitos

Asegúrate de tener instalados los siguientes programas:

- [Maven](https://maven.apache.org/install.html)
- [Docker](https://www.docker.com/get-started/)
- Docker Compose 



## Instalación
Paso 1: Clonar el repositorio

Paso 2: Iniciar docker

Paso 3: Navegar hasta la carpeta del proyecto (blogging-platform-api)

Paso 4: Ejecutar ```mvn clean package -DskipTests```

Paso 5: Ejecutar ```docker-compose up --build```

Paso 6: Acceder a http://localhost:8080/swagger-ui/index.html para probar la API





## Autor

- Zacariaz, Leandro - [Linkedin](https://www.linkedin.com/in/leandro-zacariaz-39b47a323/)

