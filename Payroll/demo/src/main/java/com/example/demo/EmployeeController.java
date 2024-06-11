package com.example.demo;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.hateoas.CollectionModel;
// Add new imports
import org.springframework.hateoas.EntityModel;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
class EmployeeController{

    private final EmployeeRepository repository;

    // Injecting EmployeeModelAssembler
    private final EmployeeModelAssembler assembler;


    EmployeeController(EmployeeRepository repository, EmployeeModelAssembler assembler){
        this.repository = repository;
        this.assembler = assembler;
    }

    // Aggregate root
    // tag :: get - aggregate - root[]
    // Getting an aggregate root resource
    @GetMapping("/employees")
    CollectionModel<EntityModel<Employee>> all() {

    List<EntityModel<Employee>> employees = repository.findAll().stream()
      .map(assembler::toModel) // Getting aggregate root resource using the assembler
        // employee -> EntityModel.of(employee,
        //  linkTo(methodOn(EmployeeController.class).one(employee.getId())).withSelfRel(),
        //  linkTo(methodOn(EmployeeController.class).all()).withRel("employees"))
      .collect(Collectors.toList());

     return CollectionModel.of(employees, linkTo(methodOn(EmployeeController.class).all()).withSelfRel());
    }
   

    // end::get-aggregate-root

    @PostMapping
    Employee newEmployee(@RequestBody Employee newEmployee){
        return repository.save(newEmployee);
    }

    // Single item

    // To make your controller more RESTful, 
    // add links like the following to the existing one method

    @GetMapping("/employees/{id}")
    EntityModel<Employee> one(@PathVariable Long id){

        Employee employee = repository.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id));


        // Getting single item resource using the assembler
        return assembler.toModel(employee);

        // EntityModel.of(employee, //
            // linkTo(methodOn(EmployeeController.class).one(id)).withSelfRel(),
            // linkTo(methodOn(EmployeeController.class).all()).withRel("employees")
        //);
    }

    

    @PutMapping("/employees/{id}")
    Employee replacEmployee(@RequestBody Employee newEmployee, @PathVariable Long id){
        
        return repository.findById(id).map(
                        employee -> {employee.setName(newEmployee.getName());
                                    employee.setRole(newEmployee.getRole());
                                    return repository.save(employee);


            }).orElseGet(() -> {
                return repository.save(newEmployee);
            });
        
    }

    @DeleteMapping("/employees/{id}")
    void deleteEmployee(@PathVariable Long id){
        repository.deleteById(id);
    }

}
