package tn.esprit.women.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tn.esprit.women.entities.Appointement;
import tn.esprit.women.entities.Supervisor;
import tn.esprit.women.services.interfaces.IAppointementService;

import java.util.List;

@Controller
@RequestMapping("/Appointement")
public class AppointementController {

    @Autowired
    private IAppointementService appointementService;

    @GetMapping("/findAllAppointements")
    public ResponseEntity findAllAppointements(){
        try{
            return new ResponseEntity(appointementService.findAllAppointements(), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/findAppointementById/{id}")
    public ResponseEntity findAppointementById(@PathVariable("id") int appointementId){
        try{
            return new ResponseEntity(appointementService.findAppointementById(appointementId), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/findAppointementsBySupervisorId/{id}")
    public ResponseEntity findAppointementsBySupervisorId(@PathVariable("id") int idSupervisor){
        try{
            return new ResponseEntity(appointementService.findAppointementsBySupervisorId(idSupervisor), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/addAppointement")
    public ResponseEntity addAppointement(@RequestBody Appointement appointement, @RequestParam("idSupervisor") int supervisorId, @RequestParam("idClaim") int idClaim){
        try{
            return new ResponseEntity(appointementService.addAppointement(appointement, supervisorId, idClaim), HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/updateAppointement")
    public ResponseEntity updateAppointement(@RequestBody Appointement appointement, @RequestParam("idSupervisor") int supervisorId, @RequestParam("idClaim") int idClaim){
        try{
            return new ResponseEntity(appointementService.updateAppointement(appointement, supervisorId, idClaim), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteAppointement/{id}")
    public ResponseEntity deleteAppointement(@PathVariable("id") int appointementId){
        try{
            return new ResponseEntity(appointementService.deleteAppointement(appointementId), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
