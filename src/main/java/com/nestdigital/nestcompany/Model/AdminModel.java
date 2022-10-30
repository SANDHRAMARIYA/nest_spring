package com.nestdigital.nestcompany.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "employee")
public class AdminModel {

    @Id
    @GeneratedValue

    private int id;
    private int empcode;
    private String name;
    private String dob;
    private String doj;
    private String address;
    private String phnum;
    private String designation;
    private String email;
    private String password;

    public AdminModel() {
    }

    public AdminModel(int id, int empcode, String name, String dob, String doj, String address, String phnum, String designation, String email, String password) {
        this.id = id;
        this.empcode = empcode;
        this.name = name;
        this.dob = dob;
        this.doj = doj;
        this.address = address;
        this.phnum = phnum;
        this.designation = designation;
        this.email = email;
        this.password = password;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getDoj() {
        return doj;
    }

    public void setDoj(String doj) {
        this.doj = doj;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhnum() {
        return phnum;
    }

    public void setPhnum(String phnum) {
        this.phnum = phnum;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
