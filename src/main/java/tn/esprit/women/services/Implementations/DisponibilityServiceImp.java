package tn.esprit.women.services.Implementations;

import java.security.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.women.repositories.DisponibilityRepository;
import tn.esprit.women.services.interfaces.IDisponibiltyService;


@Service
public class DisponibilityServiceImp implements IDisponibiltyService {
	
	@Autowired
	DisponibilityRepository disponibilityRepository;
	@Override
	public List<String> afficherDispo(Timestamp datet , Timestamp datee) {
		return disponibilityRepository.afficherDispo(datet,datee);
	}

}
