package com.example.demo.service;

import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.Employee;
import com.example.demo.repo.EmpRepo;
import net.bytebuddy.TypeCache;
import org.hibernate.mapping.Join;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.JpaSort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmpServices {

private final EmpRepo empRepo;
    public EmpServices(EmpRepo empRepo){
        this.empRepo=empRepo;
    }
    public Employee findEmployeeById(Long id){
        return empRepo.findById(id).orElseThrow(()->new UserNotFoundException("user by id "+id+"not found"));
    }
    public List<Employee> All(){
        List<Employee> employeeList = new ArrayList<>();
        List<Object[]> obj=empRepo.AllUser();
        for(Object[] objects: obj){
            Employee emp=new Employee();
            emp.setEmpId(Long.valueOf(objects[0].toString()));
            emp.setName(objects[1].toString());
            employeeList.add(emp);
        }
        return employeeList;

    }

}
