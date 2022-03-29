package tn.esprit.women.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tn.esprit.women.entities.Claim;
import tn.esprit.women.services.interfaces.IClaimService;

import javax.persistence.PostRemove;
import java.util.List;

@Controller
@RequestMapping("/Claims")
public class ClaimController {

    @Autowired
    private IClaimService claimService;

    @GetMapping("/findAllClaims")
    public ResponseEntity findAllClaims() {
        try{
            return new ResponseEntity(claimService.findAllClaims(), HttpStatus.OK);
        } catch (Exception e){
            return  new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("findClaimById")
    public ResponseEntity findClaimById(@RequestParam("idClaim") int claimId){
        try{
            return new ResponseEntity(claimService.findClaimById(claimId), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/addClaim")
    public ResponseEntity addClaim(@RequestBody Claim claim, @RequestParam("idMember") int idMember){
       try{
           return new ResponseEntity(claimService.addClaim(claim, idMember), HttpStatus.CREATED);
       } catch (Exception e){
           return new ResponseEntity(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
       }
    }

    @PutMapping("updateClaim")
    public ResponseEntity updateClaim(@RequestBody Claim claim, @RequestParam("idMember") int idMember){
        try{
            return new ResponseEntity(claimService.updateClaim(claim, idMember), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("deleteClaim")
    public ResponseEntity deleteClaim(@RequestParam("idClaim") int idClaim) {
        try{
            return new ResponseEntity(claimService.deleteClaim(idClaim), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
