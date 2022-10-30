package com.nestdigital.nestcompany.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "leaves")
public class LeaveModel {

    @Id
    @GeneratedValue

    private int id;
    private int empcode;
    private String date;
    private String reason;
    private String applydate;
    private String type;
    private int Status;

    public LeaveModel() {
    }

    public LeaveModel(int id, int empcode, String date, String reason, String applydate, String type, int status) {
        this.id = id;
        this.empcode = empcode;
        this.date = date;
        this.reason = reason;
        this.applydate = applydate;
        this.type = type;
        Status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmpcode() {
        return empcode;
    }

    public void setEmpcode(int empcode) {
        this.empcode = empcode;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getApplydate() {
        return applydate;
    }

    public void setApplydate(String applydate) {
        this.applydate = applydate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }
}