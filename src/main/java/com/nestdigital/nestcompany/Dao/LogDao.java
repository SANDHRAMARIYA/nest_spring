package com.nestdigital.nestcompany.Dao;

import com.nestdigital.nestcompany.Model.LogModel;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Map;

public interface LogDao extends CrudRepository<LogModel,Integer> {

    @Modifying
    @Query(value = "UPDATE `logs` SET `logout_time`=:logoutTime ,`logout_security_code`=:logout_security_code WHERE id = :log_id",nativeQuery = true)
    public void updateLogDetails(String logoutTime,int logout_security_code,int log_id);

    @Query(value = "SELECT l.`id`, l.`empcode`, l.`login_time`, l.`login_security_code`, l.`logout_time`, l.`logout_security_code`, e.name as emp_name,s1.name as login_sec_name, s2.name as logout_sec_name FROM `logs` l JOIN employee e JOIN security s1 JOIN security s2 ON l.empcode = e.empcode AND l.login_security_code = s1.security_code AND l.logout_security_code = s2.security_code ",nativeQuery = true)
    public List<Map<String,String>> viewAllLogs();

    @Query(value="SELECT l.`id`, l.`empcode`, l.`login_time`, l.`login_security_code`, l.`logout_time`, l.`logout_security_code`,e.name as emp_name,s1.name as login_sec_name, s2.name as logout_sec_name FROM `logs` l JOIN employee e JOIN security s1 JOIN security s2 ON l.empcode = e.empcode AND l.login_security_code = s1.security_code AND l.logout_security_code = s2.security_code WHERE l.empcode = :empcode",nativeQuery = true)
    public List<Map<String,String>> viewLogByEmpId(Integer empcode);
}


