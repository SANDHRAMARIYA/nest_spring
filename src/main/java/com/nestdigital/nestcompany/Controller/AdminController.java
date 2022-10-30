package com.nestdigital.nestcompany.Controller;

import com.nestdigital.nestcompany.Dao.AdminDao;
import com.nestdigital.nestcompany.Model.AdminModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
public class AdminController {
   @Autowired
   private AdminDao dao;


   @CrossOrigin(origins = "*")
    @PostMapping(path = "/empAdd",consumes = "application/json",produces = "application/json")
    public String empadd(@RequestBody AdminModel admin){
       DateTimeFormatter dt=DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
       LocalDateTime now=LocalDateTime.now();
       String currentdate=String.valueOf(dt.format(now));
       admin.setDoj(currentdate);
       System.out.println(admin.toString());
       dao.save(admin);
       return "{status:'success}";
   }
   @CrossOrigin(origins = "*")
    @GetMapping("/empView")
    public List<AdminModel> empview(){
       return (List<AdminModel>) dao.findAll();
   }

   @CrossOrigin(origins = "*")
    @PostMapping(path = "/search",consumes = "application/json",produces = "application/json")
    public  List<AdminModel> search(@RequestBody AdminModel emp){
       return (List<AdminModel>) dao.search(emp.getEmpcode());
   }

   @Transactional
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/delete",consumes = "application/json",produces = "application/json")
    public String delete(@RequestBody AdminModel delete){
       dao.deleteEmpById(delete.getEmpcode());
       return "{status:'success'}";
   }

   @CrossOrigin(origins = "*")
    @Transactional
    @PostMapping(path = "/edit",consumes = "application/json",produces = "application/json")
    public String edit(@RequestBody AdminModel editt){
       dao.update(editt.getName(),editt.getDob(),editt.getDoj(),editt.getAddress(),editt.getPhnum(),editt.getDesignation(),editt.getEmail(),editt.getPassword(),editt.getEmpcode());
       return  "{status='success'}";
   }

   @CrossOrigin(origins = "*")
    @PostMapping(path = "/emplogin",consumes = "application/json",produces = "application/json")
    public List<AdminModel> login(@RequestBody AdminModel employee){
       return (List<AdminModel>) dao.login(employee.getEmail(),employee.getPassword());
   }
}
