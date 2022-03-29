package tn.esprit.women.services.interfaces;

import tn.esprit.women.entities.Supervisor;

import java.util.Date;
import java.util.List;

public interface ISupervisorService {

    List<Supervisor> findAllSupervisors();
    Supervisor findSupervisorById(int supervisorId) throws Exception;
    Supervisor addSupervisor(Supervisor supervisor) throws Exception;
    Supervisor updateSupervisor(Supervisor supervisor) throws Exception;
    String deleteSupervisor(int supervisorId) throws Exception;

}
