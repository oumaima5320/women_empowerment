package tn.esprit.women.services.Implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.women.entities.Appointement;
import tn.esprit.women.entities.Supervisor;
import tn.esprit.women.repositories.AppointementRepository;
import tn.esprit.women.repositories.SupervisorRepository;
import tn.esprit.women.services.interfaces.IAppointementService;
import tn.esprit.women.services.interfaces.ISupervisorService;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class SupervisorServiceImpl implements ISupervisorService {

    @Autowired
    private SupervisorRepository supervisorRepository;

    @Autowired
    private AppointementRepository appointementRepository;

    @Autowired
    private IAppointementService appointementService;

    @Override
    public List<Supervisor> findAllSupervisors() {
        return (List<Supervisor>) supervisorRepository.findAll();
    }

    @Override
    public Supervisor findSupervisorById(int supervisorId) throws Exception {
        return supervisorRepository.findById(supervisorId)
                .orElseThrow(() -> new Exception("Supervisor is not found!"));
    }

    @Override
    public Supervisor addSupervisor(Supervisor supervisor) throws Exception{
        if(supervisor.getCin().length() != 8){
            throw new Exception("The CIN must be 8 digits!");
        } else if(supervisor.getPhoneNumber().length() != 8){
            throw new Exception("The phone number must be 8 digits!");
        } else {
            return supervisorRepository.save(supervisor);
        }
    }

    @Override
    public Supervisor updateSupervisor(Supervisor supervisor) throws Exception{
        Optional<Supervisor> supervisor1 = supervisorRepository.findById(supervisor.getId());
        if(supervisor.getCin().length() != 8){
            throw new Exception("The CIN must be 8 digits!");
        } else if(supervisor.getPhoneNumber().length() != 8){
            throw new Exception("The phone number must be 8 digits!");
        } else if(supervisor1.isPresent()){
            List<Appointement> appointements = supervisor1.get().getAppointements();
            supervisor.setAppointements(appointements);
            return supervisorRepository.save(supervisor);
        } else {
            throw new Exception("Supervisor to be updated is not found!");
        }
    }

    @Override
    public String deleteSupervisor(int supervisorId) throws Exception{
        Optional<Supervisor> supervisor = supervisorRepository.findById(supervisorId);
        if(supervisor.isPresent()){
            List<Appointement> appointements = supervisor.get().getAppointements();
            for (int i = 0; i < appointements.size(); i++) {
                appointementService.deleteAppointement(appointements.get(i).getId());
            }
            supervisorRepository.deleteById(supervisorId);
            return "Supervisor has been deleted successfully!";
        } else {
            throw new Exception("Supervisor to be deleted is not found!");
        }
    }
}
