# Todo-Red-Turismo
===================

Proyecto full-stack de desarrollo de sitio web para red de turismo. Implementacion del front-end con boostrap 4 y Angular 5. Implementacion del back-end con microservicios rest con SpringBoot y base de datos PostgreSql.

Gestion de compilacion con Maven y Java 1.8.

> **Proyectos:**
> 
> - giftcard-bbdd
> - giftcard-services
> - giftcards-frontend

> **Tecnologias:**
> 
> - Maven 3
> - Java 1.8
> - Spring boot
> - Typescript
> - Boostrap 4
> - Angular 5


===================
## red-turismo-bbdd

- Limpiar bbdd
  > mvn flyway:clean

- Cargar bbdd
  > mvn flyway:migrate
  
===================
## red-turismo-back-end

- Limpiar y compilar
  > mvn clean install

- Levantar servicios rest
  > mvn spring-boot:run

===================
## red-turismo-front-end

- Instalar dependencias
  > npm install

- Compilar aplicacion
  > npm build

- Levantar aplicacion
  > npm serve --open
  
===================