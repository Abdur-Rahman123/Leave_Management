package com.example.demo.resource;

import com.example.demo.exception.CustomException;
import com.example.demo.model.Employee;
import com.example.demo.model.LeaveApplication;
import com.example.demo.model.Reason;
import com.example.demo.repo.LeaveRepo;
import com.example.demo.service.EmpServices;
import com.example.demo.service.LeaveServices;
import com.example.demo.service.ReasonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LeaveResource {
    @Autowired
    private final LeaveServices leaveServices;
    private final EmpServices empServices;
    private final ReasonServices reasonServices;
    public LeaveResource(LeaveServices leaveServices,EmpServices empServices,ReasonServices reasonServices){
        this.leaveServices=leaveServices;
        this.empServices=empServices;
        this.reasonServices=reasonServices;
    }
    @PostMapping("/leave")
    public ResponseEntity<LeaveApplication> addEmployee(@RequestBody LeaveApplication leaveApplication) throws CustomException {
        try {
            leaveServices.addLeaveApplication(leaveApplication);
            return new ResponseEntity<>(leaveApplication, HttpStatus.CREATED);
        } catch (Exception ex){
            throw new CustomException(ex.getMessage(),"not found");
        }
    }
    @GetMapping("/allleave")
    public ResponseEntity<List<LeaveApplication>> getAllLeave() throws CustomException {
            List<LeaveApplication> leave= leaveServices.findAllLeave();
            return new ResponseEntity<>(leave, HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<LeaveApplication> updateLeaveApplication(@RequestBody LeaveApplication leaveApplication){
        LeaveApplication update=leaveServices.updateLeave(leaveApplication);
        return new ResponseEntity<>(update,HttpStatus.OK);
    }
}
