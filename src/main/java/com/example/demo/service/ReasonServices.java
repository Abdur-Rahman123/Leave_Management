package com.example.demo.service;

import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.Employee;
import com.example.demo.model.Reason;
import com.example.demo.repo.EmpRepo;
import com.example.demo.repo.ReasonRepo;
import org.springframework.stereotype.Service;

@Service
public class ReasonServices {
    private final ReasonRepo reasonRepo;
    public ReasonServices(ReasonRepo reasonRepo){
        this.reasonRepo=reasonRepo;
    }
    public Reason findReasonById(Long id){
        return reasonRepo.findById(id).orElseThrow(()->new UserNotFoundException("user by id "+id+"not found"));
    }

}
