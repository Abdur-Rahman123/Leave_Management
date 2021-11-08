package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "LeaveApplication")
public class LeaveApplication implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "lid")
    private Long lid;

    @ManyToOne
    @JoinColumn(name = "emp_id", nullable = false)
    private Employee employees;
    @ManyToOne
   @JoinColumn(name = "reason_id", nullable = false)
    private Reason reason;
    //test
    //@OneToMany(mappedBy = "leaveApplication")
  //private Set<Reason> reason;
    @Column(name = "status")
    private boolean status;

    public Long getLid() {
        return lid;
    }

    public void setLid(Long lid) {
        this.lid = lid;
    }

    public Employee getEmployees() {
        return employees;
    }

    public void setEmployees(Employee employees) {
        this.employees = employees;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Reason getReason() {
        return reason;
    }

    public void setReason(Reason reason) {
        this.reason = reason;
    }
}
