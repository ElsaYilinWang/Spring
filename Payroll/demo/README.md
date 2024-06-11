# Building REST services with Spring
This demo project is based on Spring tutorials (link below)
https://spring.io/guides/tutorials/rest

## Configuration
- Java 17 or later
- Maven
- Dependencies: Spring Web, Spring Data JPA and H2 Database

## Module 1: Non-REST part

Big picture: We are going to create a simple payroll service that manages the employees of a company. We store employee objects in a (H2 in-memory) database, and access them (through something called JPA). Then we wrap that with something that allows access over the internet (called the Spring MVC layer).

- Employee.java
- EmployeeRepository.java
- PayrollApplication.java
- LoadDatabase.java
- EmployeeController.java
- EmployeeNotFoundException.java
- EmployeeNotFoundAdvice.java

## Module 2: Spring HATEOAS

Add Spring HATEOAS dependency to pom.xml

- EmployeeModelAssembler.java


## Evolving REST APIs

REST is a collection of architectural constraints that, when adopted, make your application much more resilient. A key factor of resilience is that when you make upgrades to your services, your clients do not suffer downtime.

SOAP-based services and CORBA-based services were incredibly brittle. It was hard to roll out a server that could support both old and new clients. With REST-based practices, it is much easier, especially using the Spring stack.

ready for an upgrade that does not disturb existing clients while newer clients can take advantage of the enhancements.