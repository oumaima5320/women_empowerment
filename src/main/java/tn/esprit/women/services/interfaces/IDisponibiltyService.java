package tn.esprit.women.services.interfaces;

import java.security.Timestamp;
import java.util.List;



public interface IDisponibiltyService  {
	public List<String> afficherDispo(Timestamp datet,Timestamp datee);

}
