package tn.esprit.women.repositories;

import java.security.Timestamp;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.women.entities.Disponibility;
import org.springframework.data.repository.query.Param; 
import org.springframework.data.jpa.repository.Query;
@Repository
public interface DisponibilityRepository extends CrudRepository <Disponibility, String> {
	@Query(value="SELECT id_supervisor FROM Disponibility WHERE  DATEDIFF(:datet, Disponibility.date_debut_dis  )=0 AND DATEDIFF(:datee, Disponibilty.date_fin_dis)=0",nativeQuery=true)
	public List<String> afficherDispo(@Param(value = "datet") Timestamp datet,@Param(value = "datee") Timestamp datee);
}
