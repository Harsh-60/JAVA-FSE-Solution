# Week 4 - Microservices: Account & Loan with Eureka Discovery

Covers two hands-on exercises from the microservices course material:
- Creating Microservices for account and loan
- Create Eureka Discovery Server and register microservices

## Projects

```
microservices/
  account/                  -> GET /accounts/{number}, port 8080
  loan/                     -> GET /loans/{number}, port 8081
  eureka-discovery-server/  -> registry UI at :8761, port 8761
```

All three are separate Maven projects (Spring Boot 3.2, Java 17, Spring Cloud 2023.0.1),
each with its own `pom.xml`, matching how they'd be created from
[start.spring.io](https://start.spring.io) individually.

## Running order

Eureka needs to be up first, otherwise account/loan will just retry their registration
until it becomes available - so easiest is to start it first:

1. `cd microservices/eureka-discovery-server && mvn spring-boot:run`
   - once it's up, http://localhost:8761 shows the registry, empty at first
2. `cd microservices/account && mvn spring-boot:run`
3. `cd microservices/loan && mvn spring-boot:run`
4. Refresh http://localhost:8761 - both `ACCOUNT-SERVICE` and `LOAN-SERVICE` should show
   up under "Instances currently registered with Eureka"

## Testing the endpoints

```
GET http://localhost:8080/accounts/00987987973432
-> { "number": "00987987973432", "type": "savings", "balance": 234343 }

GET http://localhost:8081/loans/H00987987972342
-> { "number": "H00987987972342", "type": "car", "loan": 400000, "emi": 3258, "tenure": 18 }
```

Neither service talks to a real database yet - the controllers just return a fixed
dummy object matching the sample response from the exercise, same as the original
hands-on called for.

## Notes

- `account` and `loan` use `@EnableDiscoveryClient` explicitly. On newer Spring Cloud
  versions this is auto-configured just by having the eureka-client dependency on the
  classpath, but it's kept explicit here to match the steps in the exercise.
- `eureka.client.service-url.defaultZone` in account/loan points at
  `http://localhost:8761/eureka/` - update this if you run the discovery server
  somewhere other than localhost.
- Build any one of them individually with `mvn clean package` from inside its folder.
