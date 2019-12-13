# reactive-redis
Proyecto que se encarga de guardar y consultar una entidad cliente en un cache.

## Tecnologías
- springboot 2.0
- Webflux con endpoints funcionales
- Spring data redis con lettuce
- Java 11
- Gradle
- Redis
- Docker
- Rest/Restful

## Requisitos
1. Tener instalado Docker

2. Descargar la imagen de docker:

https://hub.docker.com/_/redis

  
3. Tener un IDE instalado (eclipse, intellij, netbeans, etc)


## Contexto

Redis: Es una base de datos open source con estructura de datos en memoria. Comunmente es usada como base de datos, cache y message brocker. Soporta estructura de datos como String,hashes, listas, set, sorted set, bipmaps, hyperlogs, geospatial indexes, queries y streams.

https://redis.io/

## Ejercicio
Se requiere un servicio que me permita guardar una entidad cliente en cache y que pueda consultar dicha entidad

## Solución
Se crea un microservicio reactivo en Java11 con Endpoints funcionales que expone 2 endpoint, uno para almacenar la entidad en cache y otra para consultar una entidad en base a su llave. La entidad Cliente tiene los atributos documento, tipo de documento, nombre, llave.

# Estructura de la solución
