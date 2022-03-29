package tn.esprit.women.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.women.entities.Jackpot;

@Repository
public interface JackpotRepository extends CrudRepository<Jackpot, Integer> {

}
