package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "Reason")
public class Reason implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "rid")
    private Long id;
    @JsonIgnore
    @OneToMany(mappedBy = "reason")
    private Set<LeaveApplication> leaveApplication;
    private String reason;
public Reason(){}
    public Reason(Long id, String reason) {
        this.id = id;
        this.reason = reason;
    }

    public Long getId() {
        return id;
    }

    public String getReason() {
        return reason;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Set<LeaveApplication> getLeaveApplication() {
        return leaveApplication;
    }

    public void setLeaveApplication(Set<LeaveApplication> leaveApplication) {
        this.leaveApplication = leaveApplication;
    }


    @Override
    public String toString() {
        return "Reason{" +
                "id=" + id +
                ", reason='" + reason + '\'' +
                '}';
    }
}
