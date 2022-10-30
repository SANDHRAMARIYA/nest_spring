package com.nestdigital.nestcompany.Dao;

import com.nestdigital.nestcompany.Model.LeaveModel;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Map;

public interface LeaveDao extends CrudRepository<LeaveModel,Integer> {

@Query(value = "SELECT l.`id`, l.`applydate`, l.`date`, l.`empcode`, l.`reason`, l.`type`,e.name FROM `leaves` l JOIN employee e ON e.empcode=l.empcode WHERE l.`empcode`=:empcode",nativeQuery = true)
    List<Map<String,String>> View(Integer empcode);

@Query(value = "SELECT l.`id`, l.`applydate`, l.`date`, l.`empcode`, l.`reason`, l.`type`,e.name FROM `leaves` l JOIN employee e ON e.empcode=l.empcode",nativeQuery = true)
    List<Map<String,String>> Post();

@Modifying
    @Query(value = "UPDATE `leaves` SET `status`=:status WHERE `empcode`=:empcode",nativeQuery = true)
    void  changeStatusOfLeave(Integer empcode,Integer status);
}
