# orm-learn

Demo project for Spring Data JPA and Hibernate, built from the ORM / Hibernate / Spring Data JPA training module.

## What's inside

- `Country` entity mapped to a `country` MySQL table (`model/Country.java`)
- `CountryRepository` — Spring Data JPA repository (`repository/CountryRepository.java`)
- `CountryService` — service layer with `@Transactional` methods:
  - `getAllCountries()`
  - `findCountryByCode(code)`
  - `addCountry(country)`
  - `updateCountry(code, name)`
  - `deleteCountry(code)`
  - `findCountriesByPartialName(text)`
- `CountryNotFoundException` — custom checked exception
- `OrmLearnApplication` — main class with sample test methods exercising each service method

## Prerequisites

- JDK 11+
- Maven 3.6+
- MySQL Server 8.0
- (Optional) MySQL Workbench

## Setup

1. **Create the database and table**

   Run the script in `sql/country-setup.sql` against your MySQL server. It creates the `ormlearn` schema, the `country` table, and populates it with the full list of countries.

   ```
   mysql -u root -p < sql/country-setup.sql
   ```

2. **Configure the database connection**

   Edit `src/main/resources/application.properties` if your MySQL username/password/host differ from the defaults (`root` / `root` / `localhost:3306`).

3. **Build**

   ```
   mvn clean package
   ```

4. **Run**

   ```
   mvn spring-boot:run
   ```

   Or run `OrmLearnApplication` directly from your IDE. The console log will show the SQL Hibernate executes and the results of each test method in `main()`.

## Notes

- `spring.jpa.hibernate.ddl-auto=validate` is used, so the table must already exist (via the SQL script) before starting the app — Hibernate will only validate the schema, not create it.
- Change `ddl-auto` to `update` during development if you'd rather let Hibernate manage schema changes for you.
