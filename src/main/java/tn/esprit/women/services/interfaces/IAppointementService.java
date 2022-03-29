package tn.esprit.women.services.interfaces;


import java.util.List;


import tn.esprit.women.entities.Appointement;


public interface IAppointementService {

    List<Appointement> findAllAppointements();
    Appointement findAppointementById(int appointementId) throws Exception;
    List<Appointement> findAppointementsBySupervisorId(int idSupervisor) throws Exception;
    Appointement addAppointement(Appointement appointement, int supervisorId, int idClaim) throws Exception;
    Appointement updateAppointement(Appointement appointement, int supervisorId, int idClaim) throws Exception;
    String deleteAppointement(int appointementId) throws Exception;
}

