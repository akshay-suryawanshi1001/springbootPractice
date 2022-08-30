# springbootPractice
1. @SpringBootApplication
has to be on the main class and it consists of  @SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan(excludeFilters = { @Filter(type = FilterType.CUSTOM, classes = TypeExcludeFilter.class),

not this -- @Filter(type = FilterType.CUSTOM, classes = AutoConfigurationExcludeFilter.class) })
public @interface SpringBootApplication {

2. @controller
Indicates that an annotated class is a "Controller" (e.g. a web controller). 

This annotation serves as a specialization of @Component,allowing for implementation classes to be autodetected through classpath scanning.It is typically used in combination with annotated handler methods based on the org.springframework.web.bind.annotation.RequestMapping annotation.

3.@restcontroller
Indicates that an annotated class is a "Controller" (e.g. a web controller). 

This annotation serves as a specialization of @Component,allowing for implementation classes to be autodetected through classpath scanning.It is typically used in combination with annotated handler methods based on the org.springframework.web.bind.annotation.RequestMapping annotation.


4. @RequestMapping(value = "/", method = RequestMethod.GET )   ===  @getmapping("/")

if we want to run using maven --> go to path --> mvn spring-boot:run

5.@service
6. @repository

validation using starter-validation dependency
@Length
	@Size
	@Positive
	@PositiveOrZero
	@NegativeOrZero
	@Past
	@PastOrPresent
	@Future
	@FutureOrPresent   use these annos on models and use @valid while getting request in api methods before that model
	
boot comes with default slf4j as logging library
files based logging, rolling based(new log everyday)

@controllerAdvice ---we can use this on the generic class which we will be sending back in case of any error or exception 
@exceptionhandler  --- use this on the method where we define for which type of exception we are handling in the controller advice class

unit testing
@SpringBootTest------Annotation that can be specified on a test class that runs Spring Boot based tests.Provides the following features over and above the regular Spring TestContextFramework: •Uses SpringBootContextLoader as the default ContextLoader when nospecific @ContextConfiguration(loader=...) isdefined.
•Automatically searches for a @SpringBootConfiguration when nested @Configuration is not used, and no explicit classes arespecified.
•Allows custom Environment properties to be defined using the properties attribute.
•Allows application arguments to be defined using the argsattribute.
•Provides support for different webEnvironment modes,including the ability to start a fully running web server listening on a defined or random port.
Can register the following beans for web tests that are using a fully running webserver: 
•TestRestTemplate
•WebTestClient
•HttpGraphQlTester

@beforeeach
@DataJpaTest --- to mock the jpa apis
we will need TestEntityManager class also, we can use this entityManager.persist(Entity) to store entity temporarily in db

@WebMvcTest(DepartmentController.class)                              //to test this class by calling the endpoint through code
@MockBean
	private DepartmentService departmentService;   ---> use this to mock web request
	
	
we can have different profiles for dev,qa and prod
we can run the selected jar for a particular profile ---> java -jar myproject.jar --spring.profiles.active=prod

enable all different actuator endpoints
management:
  endpoints:
    web:
      exposure:
        include: "*"
		exclude: "env,beans"              //exclude actuator endpoint
we have also create one customer endpoint in this app

