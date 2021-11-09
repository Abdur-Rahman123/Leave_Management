package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Employee")
public class Employee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "empId")
    private Long empId;

    @JsonIgnore
    @OneToMany(mappedBy = "employees")
    private Set<LeaveApplication> leaveApplication;
    @Column(name = "name")
    private String name;

      public Employee(){}

    public Employee(Long empId, String name) {
        this.empId = empId;
        this.name = name;
    }

    public Employee(Long empId, Set<LeaveApplication> leaveApplication, String name) {
        this.empId = empId;
        this.leaveApplication = leaveApplication;
        this.name = name;
    }

    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    public Set<LeaveApplication> getLeaveApplication() {
        return leaveApplication;
    }

    public void setLeaveApplication(Set<LeaveApplication> leaveApplication) {
        this.leaveApplication = leaveApplication;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
