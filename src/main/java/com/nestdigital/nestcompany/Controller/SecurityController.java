package com.nestdigital.nestcompany.Controller;

import com.nestdigital.nestcompany.Dao.SecurityDao;
import com.nestdigital.nestcompany.Model.AdminModel;
import com.nestdigital.nestcompany.Model.SecurityModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
public class SecurityController {

    @Autowired
    private SecurityDao dao;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/addsecurity", consumes = "application/json", produces = "application/json")
    public String addSecurity(@RequestBody SecurityModel add) {
        DateTimeFormatter dt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String currentdate = String.valueOf(dt.format(now));
        add.setDoj(currentdate);
        System.out.println(add.toString());
        dao.save(add);
        return "{status:'success}";
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/viewsecurity")
    public List<SecurityModel> viewSecurity() {
        return (List<SecurityModel>) dao.findAll();
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/searchsecurity", consumes = "application/json", produces = "application/json")
    public List<SecurityModel> searchSecurity(@RequestBody SecurityModel security) {
        return (List<SecurityModel>) dao.searchSecurity(security.getSecurity_code());
    }

    @Transactional
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/deletesecurity", consumes = "application/json", produces = "application/json")
    public String deleteSecurity(@RequestBody SecurityModel deleteSecurity) {
        dao.deleteSecurityById(deleteSecurity.getSecurity_code());
        return "{status:'success'}";
    }

    @CrossOrigin(origins = "*")
    @Transactional
    @PostMapping(path = "/editsecurity",consumes = "application/json",produces = "application/json")
    public String editSecurity(@RequestBody SecurityModel editSecurity){
dao.update(editSecurity.getDoj(),editSecurity.getEmail(),editSecurity.getName(),editSecurity.getPassword(),editSecurity.getSecurity_code());
    return "{status:'success'}";
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/loginsecurity",consumes = "application/json",produces = "application/json")
    public List<SecurityModel> login(@RequestBody SecurityModel security){
        return (List<SecurityModel>) dao.login(security.getEmail(),security.getPassword());
    }
}
