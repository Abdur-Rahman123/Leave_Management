package com.example.demo.resource;

import com.example.demo.model.Employee;
import com.example.demo.service.EmpServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeResource {
    private final EmpServices empServices;

    public EmployeeResource(EmpServices empServices) {
        this.empServices = empServices;
    }
    @GetMapping("/allemployee")
    public ResponseEntity<List<Object[]>> allEmployee(){
        List<Object[]> emp=empServices.findAllEmployee();
        return new ResponseEntity<>(emp, HttpStatus.OK);
    }
}
