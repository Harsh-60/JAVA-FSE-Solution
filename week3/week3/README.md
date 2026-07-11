# Week 3 — Spring REST using Spring Boot 3

A single Spring Boot 3 (Java 17) Maven project, `spring-learn`, covering the hands-on exercises below. Each exercise lives in its own file, one class/config per concept.

## Exercise → File map

| Module | Exercise | File |
|---|---|---|
| 1. spring-rest-handson | Create a Spring Web Project using Maven | `src/main/java/com/cognizant/springlearn/SpringLearnApplication.java` |
| 1. spring-rest-handson | Spring Core – Load Country from Spring Configuration XML | `src/main/java/com/cognizant/springlearn/model/Country.java` + `src/main/resources/country.xml` |
| 2. spring-rest-handson | Hello World RESTful Web Service | `src/main/java/com/cognizant/springlearn/controller/HelloController.java` |
| 2. spring-rest-handson | REST - Country Web Service | `src/main/java/com/cognizant/springlearn/controller/CountryController.java` |
| 2. spring-rest-handson | REST - Get country based on country code | `src/main/java/com/cognizant/springlearn/controller/CountryCodeController.java` (supported by `service/CountryService.java` and `service/exception/CountryNotFoundException.java`) |
| 5. JWT-handson | Create authentication service that returns JWT | `src/main/java/com/cognizant/springlearn/security/AuthenticationController.java` (supported by `security/SecurityConfig.java`) |

## Prerequisites

- JDK 17+
- Maven 3.8+

## Build & Run

```
mvn clean package
mvn spring-boot:run
```

The app starts on port `8090` (configured in `application.properties`).

## Try each exercise

**1. Hello World**
```
curl http://localhost:8090/hello
```

**2. Country web service (India)**
```
curl http://localhost:8090/country
```

**3. Country by code (case-insensitive)**
```
curl http://localhost:8090/countries/in
curl http://localhost:8090/countries/az   # 404 Country not found
```

**4. Authenticate and get a JWT**
```
curl -s -u user:pwd http://localhost:8090/authenticate
```
Default in-memory users (configured in `SecurityConfig.java`): `admin` / `pwd` (role `ADMIN`) and `user` / `pwd` (role `USER`). Both roles can call `/authenticate`.

## Notes

- This project uses Spring Boot 3 / Spring Security 6, so security is configured with a `SecurityFilterChain` bean rather than the deprecated `WebSecurityConfigurerAdapter` used in older Spring Boot 2 tutorials.
- The JWT library used is `jjwt` 0.11.5 (`jjwt-api`/`jjwt-impl`/`jjwt-jackson`), with the signing key built via `Keys.hmacShaKeyFor(...)` as required by newer `jjwt` versions.
- `SecurityConfig.java` is included as a supporting file (not an explicitly listed exercise) because the `/authenticate` service can't run without it.
