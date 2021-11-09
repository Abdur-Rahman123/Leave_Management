package com.example.demo.service;

import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.Employee;
import com.example.demo.repo.EmpRepo;
import net.bytebuddy.TypeCache;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.JpaSort;
import org.springframework.stereotype.Service;

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

    public List<Object[]> findAllEmployee(){
        return empRepo.AllUser();
    }
}
