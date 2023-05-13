Proyecto: APIREST con Spring Boot, Maven, Java y MySQL con JPA
Este proyecto es una APIREST que utiliza Spring Boot, Maven, Java y MySQL con JPA. La APIREST permite trabajar con tópicos a través de las peticiones GET, PUT, POST y DELETE. También se asegura de que no se pueda crear un tópico que tenga el mismo título o mensaje que uno que ya existe.

Requisitos
Java JDK 8 o superior
Maven 3.2 o superior
MySQL 5.6 o superior
Eclipse o cualquier IDE de su preferencia
Configuración
Para configurar la base de datos MySQL, debe seguir los siguientes pasos:

Cree una base de datos con el nombre "topicos_db".
Cree la tabla "topicos" con los campos "id", "titulo" y "mensaje".
Configure la conexión a la base de datos en el archivo application.properties. Asegúrese de que los valores de "spring.datasource.username" y "spring.datasource.password" coincidan con los que se han configurado para su base de datos.
properties

spring.datasource.url=jdbc:mysql://localhost:3306/topicos_db?useSSL=false
spring.datasource.username=root
spring.datasource.password=1234
spring.datasource.driver-class-name=com.mysql.jdbc.Driver

#hibernate properties
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=create-drop
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5Dialect
Uso
La APIREST cuenta con los siguientes endpoints:

Consultar todos los tópicos
GET /topicos

Consultar un tópico por ID
GET /topicos/{id}

Crear un nuevo tópico
POST /topicos
{
    "titulo": "Nuevo tópico",
    "mensaje": "Este es un nuevo tópico"
    "estatus": "enable"
     "autor": "nombre"
    "curso": "curso de springboot"
}

Actualizar un tópico existente
PUT /topicos/{id}
{
    "titulo": "tópico actualizado",
    "mensaje": "Este es un tópico actualizado"
    "estatus": "enable"
     "autor": "nombre"
    "curso": "curso de springboot"
}

Eliminar un tópico existente
DELETE /topicos/{id}

