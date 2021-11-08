package com.example.demo.service;

import com.example.demo.model.Employee;
import com.example.demo.model.LeaveApplication;
import com.example.demo.repo.LeaveRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaveServices {

    private final LeaveRepo leaveRepo;
    public LeaveServices(LeaveRepo leaveRepo){
        this.leaveRepo=leaveRepo;
    }
    public LeaveApplication addLeaveApplication(LeaveApplication leaveApplication){
        return leaveRepo.save(leaveApplication);
    }
    public List<LeaveApplication> findAllLeave(){
        return leaveRepo.findAll();
    }
    public LeaveApplication updateLeave(LeaveApplication leaveApplication){
        return leaveRepo.save(leaveApplication);
    }
}
