package tn.esprit.women.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tn.esprit.women.entities.Supervisor;
import tn.esprit.women.services.interfaces.ISupervisorService;

import javax.xml.ws.Response;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/Supervisors")
public class SupervisorController {

    @Autowired
    private ISupervisorService supervisorService;

    @GetMapping("/findAllSupervisors")
    public ResponseEntity findAllSupervisors(){
        try{
            return new ResponseEntity(supervisorService.findAllSupervisors(), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/findSupervisorById/{id}")
    public ResponseEntity findSupervisorById(@PathVariable("id") int supervisorId){
        try{
            return new ResponseEntity(supervisorService.findSupervisorById(supervisorId), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/addSupervisor")
    public ResponseEntity addSupervisor(@RequestBody Supervisor supervisor){
        try{
            return new ResponseEntity(supervisorService.addSupervisor(supervisor), HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/updateSupervisor")
    public ResponseEntity updateSupervisor(@RequestBody Supervisor supervisor){
        try{
            return new ResponseEntity(supervisorService.updateSupervisor(supervisor), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteSupervisor/{id}")
    public ResponseEntity deleteSupervisor(@PathVariable("id") int supervisorId){
        try{
            return new ResponseEntity(supervisorService.deleteSupervisor(supervisorId), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
