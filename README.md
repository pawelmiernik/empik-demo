# EMPIK DEMO

## Opis
Pobiera dane o użytkownikach z https://api.github.com/users/{login}, 
zwraca informacje o użytkowniku, z wyliczona wartością "calculations".

## Wykorzystane technologie 
* Java 11
* SpringBoot 2.5.15
* DB: H2
* Spock Framework
* Lombok
* Mapstruct
* Swagger
* Openapi generator
* Maven

## Budowanie i uruchomienie 

* Wejść do folderu z projektem
* Zbudować projekt

>  .\mvnw clean package

* Uruchomić projekt

>  java -jar .\target\epmik-demo-0.0.1-SNAPSHOT.jar

## Swagger

Po uruchomieniu projektu swagger dostępny pod linkiem http://localhost:8080/empikdemo/swagger-ui/index.html

## H2 Console

Konsola DB: H2 dostępna pod linkiem http://localhost:8080/empikdemo/h2-console
> User: user

> Password: user
