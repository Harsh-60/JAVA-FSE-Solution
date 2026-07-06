# Library Management - Spring Exercises

Two projects here:

**LibraryManagement/** - covers exercises 1, 2, 3, 5, 6, 7, 8 (plain Spring, XML + annotation
config, AOP logging). Run `LibraryManagementApplication.java` as a Java app.

**LibraryManagementBoot/** - covers exercise 9 (Spring Boot + JPA + H2). Run with
`mvn spring-boot:run` or just run `LibraryManagementApplication.java` in that folder.
Hit `http://localhost:8080/api/books` once it's up.

## Notes on how the exercises map to the code

- Ex 1/5: `applicationContext.xml` + `BookService`/`BookRepository` classes
- Ex 2/7: setter injection is the `setBookRepository` method on `BookService`, constructor
  injection is the `@Autowired` constructor right above it
- Ex 3/8: `LoggingAspect` - the `@Around` method is the one that times execution, `@Before`/
  `@After` just print when a method starts/ends
- Ex 4: pom.xml has spring-context, spring-aop, spring-webmvc, compiler plugin set to 1.8
- Ex 6: `<context:component-scan>` in the XML + `@Service`/`@Repository` on the classes
- Ex 9: separate Boot project, `Book` entity, `BookRepository` extends JpaRepository,
  `BookController` has the CRUD endpoints

To build either project: `mvn clean install` from inside its folder.
