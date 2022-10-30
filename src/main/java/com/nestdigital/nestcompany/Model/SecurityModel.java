package com.nestdigital.nestcompany.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "security")
public class SecurityModel {

    @Id
    @GeneratedValue

    private int id;
    private int security_code;
    private String name;
    private String doj;
    private String email;
    private String password;

    public SecurityModel() {
    }

    public SecurityModel(int id, int security_code, String name, String doj, String email, String password) {
        this.id = id;
        this.security_code = security_code;
        this.name = name;
        this.doj = doj;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSecurity_code() {
        return security_code;
    }

    public void setSecurity_code(int security_code) {
        this.security_code = security_code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDoj() {
        return doj;
    }

    public void setDoj(String doj) {
        this.doj = doj;
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
