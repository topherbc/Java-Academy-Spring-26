What did you learn yesterday?

1. Spring Framework != Springboot
2. Spring Framework - framework that needs to be configured
   1. DI - Dependency Injection
   2. IoC - Inversion of Control
3. Springboot - is out of the box, preconfigured spring application
4. JSON - Javascript Object Notation
5. @Annotations - provide the compiler with information on the following property/method/class
6. Model - data structure / represents entrys in tables
7.  @Repository - handle db operations
   1. extend JPARepository interface to use built in methods
      1. findAll()
      2. count()
      3. findByID()
      4. save()
8.  @Service - business logic
9.  @Controller - manages services
10. API 

Today's Objectives

1. API's
2. Endpoints
3. Controllers
4. HTTP Methods
5. Query Parameters
6. Insomnia

Agenda Today

1. Intro and Recap
2. API's Explained
3. Calling API's exercise
4. Break
5. Demo Frontend
6. Using Insomnia and HTTP Methods
7. Using Insomnia exercise
8. Lunch
9. Changing controllers / Making our own endpoints
10. Changing an endpoint exercise
11. Break
12. Endpoints continued
13. Recap and Q&A



Uniform Resource Locator - URL

https://yearup.brightspace.com/d2l/le/lessons/11438/topics/499450

HTTP S
HTTP -> Hypertext Transfer Protocol
HTTPS -> Hypertext Transfer Protocol secure
protocol -> https://
subdomain -> yearup.
domain -> brightspace.com
path -> /d2l/le/lessons/11438/topics/499450
endpoint -> /d2l/



Brightspace.com -> resolves to an IP address
  192.2.2.1
IP - Internet Protocol
DNS - Domain Name Service
  translates domain to ip

http://127.0.0.1:8080/api/internships


localhost -> 127.0.0.1
port -> 8080
port for http -> 80
port for https -> 443
localhost -> building


jdbc:mysql://localhost:3306/internships
.




What did you learn today?

1. API - Application Programming Interface
2. CRUD
   1. CREATE - POST
   2. READ - GET
   3. UPDATE - PUT
   4. DELETE - DELETE
3. localhost = 127.0.0.1
4. DNS - Domain Name Service
   1. translating domains to ip addresses
5. HTTP - Hypertext Transfer Protocol
6. HTTPS - Hypertext Transfer Protocol Secure - Encrypted http
7. HTTP Status Codes
   1. 200 Ok
   2. 201 Create
   3. 2xx - Success
   4. 418 - I am a Teapot
8. HTML - Hypertext Markup Language
9.  Ports
10. IP - Internet Protocol
11. URL - Uniform Resource Locator
12. 418 RFC
13. Spring Annotations
    1.  @PathVariable
    2.  @GetMapping, @PostMapping, @PutMapping, @DeleteMapping
14. %20 - space in the URL
15. Developer tools / Inspector / Console
16. How to bypass paywalls
