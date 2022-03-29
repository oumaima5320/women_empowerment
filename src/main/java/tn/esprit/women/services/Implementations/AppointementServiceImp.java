package tn.esprit.women.services.Implementations;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import net.bytebuddy.implementation.bind.annotation.Super;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import tn.esprit.women.entities.Appointement;
import tn.esprit.women.entities.Claim;
import tn.esprit.women.entities.Supervisor;
import tn.esprit.women.repositories.AppointementRepository;
import tn.esprit.women.repositories.ClaimRepository;
import tn.esprit.women.repositories.SupervisorRepository;
import tn.esprit.women.services.interfaces.IAppointementService;
import tn.esprit.women.utils.EmailServiceImpl;
import tn.esprit.women.utils.IEmailService;

import javax.swing.text.html.Option;


@Service
public class AppointementServiceImp implements IAppointementService {

	@Autowired
	private AppointementRepository appointementRepository;

	@Autowired
	private SupervisorRepository supervisorRepository;

	@Autowired
	private ClaimRepository claimRepository;

	@Autowired
	private IEmailService emailService;


	@Override
	public List<Appointement> findAllAppointements() {
		return (List<Appointement>) appointementRepository.findAll();
	}

	@Override
	public Appointement findAppointementById(int appointementId) throws Exception {
		return appointementRepository.findById(appointementId)
				.orElseThrow(() -> new Exception("Appointement is not found!"));
	}

	@Override
	public List<Appointement> findAppointementsBySupervisorId(int idSupervisor) throws Exception {
		Optional<Supervisor> supervisor = supervisorRepository.findById(idSupervisor);
		if(supervisor.isPresent()){
			return appointementRepository.findBySupervisorId(idSupervisor);
		} else {
			throw new Exception("Supervisor is not found");
		}

	}

	@Override
	public Appointement addAppointement(Appointement appointement, int idSupervisor, int idClaim) throws Exception {
		Optional<Supervisor> supervisor = supervisorRepository.findById(idSupervisor);
		Optional<Claim> claim = claimRepository.findById(idClaim);
		if (supervisor.isPresent()){
			if(claim.isPresent()){
				Optional<Appointement> app = appointementRepository.findBySupervisorIdAndDate(idSupervisor, appointement.getDate());
				if(!app.isPresent()){
					//Setting up appointement
					appointement.setClaim(claim.get());
					appointement.setSupervisor(supervisor.get());
					appointementRepository.save(appointement);

					 // Setting up supervisor
					List<Appointement> appointements = supervisor.get().getAppointements();
					appointements.add(appointement);
					supervisor.get().setAppointements(appointements);
//					supervisorRepository.save(supervisor.get());

					// Setting up claim
					claim.get().setAppointement(appointement);
//					claimRepository.save(claim.get());

					emailService.sendMailToSuperviserAndMember(supervisor.get(),claim.get().getMember(),appointement);
					return appointement;
				} else {
					throw new Exception("Appointment is already taken!");
				}

			} else {
				throw new Exception("Claim is not Found!");
			}

		} else {
			throw new Exception("Supervisor is not Found!");
		}
	}

	@Override
	public Appointement updateAppointement(Appointement appointement, int idSupervisor, int idClaim) throws Exception {
		Optional<Appointement> appointement1 = appointementRepository.findById(appointement.getId());
		if(appointement1.isPresent()){
			Optional<Supervisor> supervisor = supervisorRepository.findById(idSupervisor);
			Optional<Claim> claim = claimRepository.findById(idClaim);
			if (supervisor.isPresent()){
				if(claim.isPresent()){
					// Setting up supervisor
					List<Appointement> appointements = new ArrayList<>();
					if(!appointements.contains(appointement)){
						appointements.add(appointement);
						supervisor.get().setAppointements(appointements);
						supervisorRepository.save(supervisor.get());
					}

					// Setting up claim
					claim.get().setAppointement(appointement);
					claimRepository.save(claim.get());

					//Setting up appointement
					appointement.setClaim(claim.get());
					appointement.setSupervisor(supervisor.get());
					return appointementRepository.save(appointement);
				} else {
					throw new Exception("Claim is not Found!");
				}

			} else {
				throw new Exception("Supervisor is not Found!");
			}
		} else {
			throw new Exception("Appointement to be updated is not found!");
		}

	}

	@Override
	public String deleteAppointement(int appointementId) throws Exception {
		Optional<Appointement> appointement = appointementRepository.findById(appointementId);
		if(appointement.isPresent()){
			Optional<Supervisor> supervisor = supervisorRepository.findById(appointement.get().getSupervisor().getId());
			Optional<Claim> claim = claimRepository.findById(appointement.get().getClaim().getId());
			List<Appointement> appointements = supervisor.get().getAppointements();

			// Setting up supervisor
			appointements.remove(appointement.get());
			supervisor.get().setAppointements(appointements);
			supervisorRepository.save(supervisor.get());

			// Setting up claim
			claim.get().setAppointement(null);
			claimRepository.save(claim.get());

			// Delete appointement
			appointementRepository.delete(appointement.get());
			return "Appointement has been deleted successfully!";
		} else {
			throw new Exception("Appointement to be deleted is not found!");
		}
	}
}
