package com.nestdigital.nestcompany.Controller;

import com.nestdigital.nestcompany.Dao.LogDao;
import com.nestdigital.nestcompany.Model.LogModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

@RestController
public class LogController {

    @Autowired
    private LogDao dao;

    @PostMapping("/checkIn")
    public String addLogDetails(@RequestBody LogModel model){
        DateTimeFormatter date=DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now=LocalDateTime.now();
        model.setLogin_time((String.valueOf(date.format(now))));
        dao.save(model);
        return "Success";
    }

    @Transactional
    @CrossOrigin(origins = "*")
    @PostMapping("/checkOut")
    public String updateLogDetails(@RequestBody LogModel logModel){
        DateTimeFormatter date = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        logModel.setLogout_time((String.valueOf(date.format(now))));
        dao.updateLogDetails(logModel.getLogout_time(), logModel.getLogout_security_code(), logModel.getId());
        return "Success";
    }



    @CrossOrigin(origins = "*")
    @GetMapping("/viewAllLog")
    public List<Map<String,String>> viewAllLog(){
        return (List<Map<String, String>>) dao.viewAllLogs();
    }


    @CrossOrigin(origins = "*")
    @PostMapping("/viewLogById")
    public List<Map<String,String>> viewLogById(@RequestBody LogModel logModel){
        return (List<Map<String, String>>) dao.viewLogByEmpId(logModel.getEmpcode());
    }


}

