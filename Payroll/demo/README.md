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

## Building links into your REST API

To grow your API and better serve your clients, you need to embrace the concept of Hypermedia as the Engine of Application State.

Business logic inevitably builds up rules that involve processes. The risk of such systems is we often carry such server-side logic into clients and build up strong coupling. REST is about breaking down such connections and minimizing such coupling.

- Order.java
- Status.java
- OrderRepository.java
- OrderController.java
- OrderModelAssembler.java
- OrderNotFoundException.java


## Summary

REST is not just about pretty URIs and returning JSON instead of XML.

Instead, the following tactics help make your services less likely to break existing clients you may or may not control:

- Do not remove old fields. Instead, support them.

- Use rel-based links so clients need not hard code URIs.

- Retain old links as long as possible. Even if you have to change the URI, keep the rels so that older clients have a path to the newer features.

- Use links, not payload data, to instruct clients when various state-driving operations are available.

This concludes our tutorial on how to build RESTful services using Spring. Each section of this tutorial is managed as a separate subproject in a single github repo:

- nonrest — Simple Spring MVC app with no hypermedia

- rest — Spring MVC + Spring HATEOAS app with HAL representations of each resource

- evolution — REST app where a field is evolved but old data is retained for backward compatibility

- links — REST app where conditional links are used to signal valid state changes to clients