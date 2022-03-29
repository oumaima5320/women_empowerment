package tn.esprit.women.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.women.entities.Appointement;
import tn.esprit.women.entities.Claim;

import java.util.Optional;

@Repository
public interface ClaimRepository extends CrudRepository<Claim, Integer> {

}
