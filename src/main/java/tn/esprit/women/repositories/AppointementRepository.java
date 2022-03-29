package tn.esprit.women.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.women.entities.Appointement;
import tn.esprit.women.entities.Claim;

import javax.swing.text.html.Option;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface AppointementRepository extends CrudRepository <Appointement, Integer> {
    List<Appointement> findBySupervisorId(int idSupervisor);
    Optional<Appointement> findBySupervisorIdAndDate(int idSupervisor, LocalDate  date);
}
