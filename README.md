# reactive-redis
Proyecto que se encarga de guardar y consultar una entidad cliente en un cache.

## Tecnologías

### JDK Java 11
Versión de Java 11 para desarrollo de aplicaciones en lenguaje de programación Java
https://www.oracle.com/technetwork/java/javase/downloads/jdk11-downloads-5066655.html

### Springboot 2.0: 
Componente que permite crear aplicaciones autocontenidas que permiten ejecutarse en su mismo proceso
https://spring.io/projects/spring-boot

### Webflux con endpoints funcionales:
Framework de spring que implementa el modelo reactivo. La versión de entpoints funcionales permite la implementación del crontrolador en el modelo funcional apalancado en routes y handles
https://docs.spring.io/spring/docs/current/spring-framework-reference/web-reactive.html

### Spring Data Redis con lettuce
Proporciona una fácil configuración para acceso a la aplicación Redis desde aplicaciones Spring utilizando todas sus operaciones.
https://spring.io/projects/spring-data-redis

### Gradle
Gradle ayuda a los equipos a construir, automatizar, testear y entregar mejor software y de manera rápida.
https://gradle.org/

### Redis
Es una base de datos open source con estructura de datos en memoria. Comunmente es usada como base de datos, cache y message broker. Soporta estructura de datos como String,hashes, listas, set, sorted set, bipmaps, hyperlogs, geospatial indexes, queries y streams.
https://redis.io/

### Docker
Permite la contenerización de aplicaciones para que estas sean desplegadas en cualqueir plataforma
https://www.docker.com/

### Lombok
Libreria que permite automatizar mediante anotaciones la escritura de getters, setters y constructores en tiempo de compilación
https://projectlombok.org/

## Requisitos
1. Tener instalado Docker

2. Descargar la imagen oficial de redis en docker:

https://hub.docker.com/_/redis

3. Tener un IDE instalado (eclipse, intellij, netbeans, etc)


## Ejercicio
Se requiere un servicio que me permita guardar una entidad cliente en cache y que pueda consultar dicha entidad

## Solución
Se crea un microservicio reactivo en Java11 con Endpoints funcionales que expone 2 endpoint, uno para almacenar la entidad en cache y otra para consultar una entidad en base a su llave. La entidad Cliente tiene los atributos documento, tipo de documento, nombre, llave.

## Estructura de la solución

### Paquete: 
co.com.giosoft.redis

### Clases

**Cliente:** Clase entidad que representa un cliente de una institución. Esta anotada con lombok para su simplicidad. Sus atributos:
- documentId
- documentType
- name
- mdmKey

**Application:** Clase principal del microservicio que se encarga de lanzar springboot

**ReactiveRedisConfig:** Clase encargadas de configurar el acceso a redis y las operaciones básicas usando Jackson2JsonRedisSerializer para serializar las entidades permitiendo leer y escribir en redis en formato json.

**Route:** Clase encargada de recibir las peticiones rest y redireccionarlas al correspondiente handler que resolverá la peticion. Equivale al controlador en el modelo reactivo orientado a anotaciones

**Handler:** Clase encargada de procesar la operación de consulta y guardado en redis.

