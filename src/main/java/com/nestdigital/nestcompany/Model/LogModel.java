package com.nestdigital.nestcompany.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "logs")
public class LogModel {

    @Id
    @GeneratedValue
    private int id;
    private int empcode;
    private int login_security_code;
    private int logout_security_code;
    private String login_time;
    private String logout_time;

    public LogModel() {
    }

    public LogModel(int id, int empcode, int login_security_code, int logout_security_code, String login_time, String logout_time) {
        this.id = id;
        this.empcode = empcode;
        this.login_security_code = login_security_code;
        this.logout_security_code = logout_security_code;
        this.login_time = login_time;
        this.logout_time = logout_time;
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

    public int getLogin_security_code() {
        return login_security_code;
    }

    public void setLogin_security_code(int login_security_code) {
        this.login_security_code = login_security_code;
    }

    public int getLogout_security_code() {
        return logout_security_code;
    }

    public void setLogout_security_code(int logout_security_code) {
        this.logout_security_code = logout_security_code;
    }

    public String getLogin_time() {
        return login_time;
    }

    public void setLogin_time(String login_time) {
        this.login_time = login_time;
    }

    public String getLogout_time() {
        return logout_time;
    }

    public void setLogout_time(String logout_time) {
        this.logout_time = logout_time;
    }
}