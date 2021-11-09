package com.example.demo.resource;

import com.example.demo.model.Employee;
import com.example.demo.repo.EmpRepo;
import com.example.demo.service.EmpServices;
import org.hibernate.mapping.Join;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeResource {
    private final EmpServices empServices;
    private final EmpRepo empRepo;

    public EmployeeResource(EmpServices empServices,EmpRepo empRepo) {

        this.empServices = empServices;
        this.empRepo=empRepo;
    }
    @GetMapping("/allemployee")
    public List<Employee> allEmployee(){
        return empServices.All();

    }
}
