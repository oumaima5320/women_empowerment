package tn.esprit.women.services.interfaces;


import java.util.List;

import tn.esprit.women.entities.Appointement;
import tn.esprit.women.entities.Claim;



public interface IClaimService {

    List<Claim> findAllClaims();
    Claim findClaimById(int claimId) throws Exception;
    Claim addClaim(Claim claim, int idMember) throws Exception;
    Claim updateClaim(Claim claim, int idMember) throws Exception;
    String deleteClaim(int claimId) throws Exception;
}
