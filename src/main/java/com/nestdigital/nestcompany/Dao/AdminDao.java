package com.nestdigital.nestcompany.Dao;

import com.nestdigital.nestcompany.Model.AdminModel;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AdminDao extends CrudRepository<AdminModel,Integer> {
@Modifying
@Query(value = "DELETE FROM `employee` WHERE `empcode`=:empcode",nativeQuery = true)
void deleteEmpById(Integer empcode);
    @Query(value = "SELECT `id`, `address`, `designation`, `dob`, `doj`, `email`, `empcode`, `name`, `password`, `phnum` FROM `employee` WHERE `empcode`=:empcode",nativeQuery = true)
    List<AdminModel> search(Integer empcode);

    @Modifying
    @Query(value = "UPDATE `employee` SET `name`=:name,`dob`=:dob,`doj`=:doj,`address`=:address,`phnum`=:phnum,`designation`=:designation,`email`=:email,`password`=:password WHERE `empcode`=:empcode",nativeQuery = true)
    void update(String name,String dob,String doj,String address,String phnum,String designation,String email,String password,Integer empcode);

@Query(value = "SELECT `id`, `address`, `designation`, `dob`, `doj`, `email`, `empcode`, `name`, `password`, `phnum` FROM `employee` WHERE `email`=:email AND `password`=:password",nativeQuery = true)
    List<AdminModel> login(String email,String password);

}
