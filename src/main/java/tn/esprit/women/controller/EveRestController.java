package tn.esprit.women.controller;


import java.security.Timestamp;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.web.bind.annotation.*;

import tn.esprit.women.entities.Member;
import tn.esprit.women.services.interfaces.IMemberService;
import tn.esprit.women.services.interfaces.IAppointementService;
import tn.esprit.women.services.interfaces.IClaimService;
import tn.esprit.women.services.interfaces.IDisponibiltyService;
import tn.esprit.women.services.interfaces.IEventService;
import tn.esprit.women.services.interfaces.IJackpotService;
import tn.esprit.women.entities.Appointement;
import tn.esprit.women.entities.Claim;
import tn.esprit.women.entities.Event;
import tn.esprit.women.entities.Jackpot;


@RestController
@RequestMapping("/eve")
public class EveRestController {


	@Autowired
	IDisponibiltyService disponibilityService;


	@Autowired
	IMemberService memberService;

	@Autowired
	IEventService eventService;

	@Autowired
	IJackpotService jackpotService;

	@Autowired
	IClaimService claimService;

	@Autowired
	IAppointementService appointementService;

	@PostMapping("/ajouter-member")
	public void ajouterMember(@RequestBody Member member){
		memberService.ajouterMember(member);
	}

	@PostMapping("/ajouter-event")
	public void ajouterEvent(@RequestBody Event event){
		eventService.ajouterEvent(event);
	}

	@PostMapping("/ajouter-jackpot")
	public void ajouterjackpot(@RequestBody Jackpot jackpot){
		jackpotService.ajouterJackpot(jackpot);
	}

/*	@PostMapping("/ajouter-Claim")
	public void ajouterclaim(@RequestBody Claim claim){
		claimService.ajouterClaim (claim);
	}*/



/*	@GetMapping("getAllClaims")
	public List<Claim> findAllClaim(){
		return claimService.findAllClaims();
	}*/
	
/*	@PutMapping("updateClaim")
	public Claim updateClaim(@RequestBody Claim claim){
		return claimService.Update(claim);
	}*/

	
/*	@DeleteMapping("deleteClaim")
	public String deleteClaim(@RequestParam int id){
		claimService.deleteClaim(id);
		return "claim deleted";

	}*/


	@GetMapping("/List-member")
	public List<Member> list() {
		return memberService.listAll();
	}


	@GetMapping("getAllEvents")
	public List<Event> findAllEvent(){
		return eventService.findAllEvents();

	}
	@PutMapping("updateEvent")
	public Event updateEvent(@RequestBody Event event){
		return eventService.updateEvent(event);
	}

	@DeleteMapping("deleteEvent")
	public String deleteEvent(@RequestParam int id){
		eventService.deleteEvent(id);
		return "event deleted";

	}




	@GetMapping("getAllJackpots")
	public List<Jackpot> findAllJackpot(){
		return jackpotService.findAllJackpots();

	}
	@PutMapping("updateJackpot")
	public Jackpot updateJackpot(@RequestBody Jackpot jackpot){
		return jackpotService.updateJackpot(jackpot);
	}

	@DeleteMapping("deleteJackpot")
	public String deleteJackpot(@RequestParam int id){
		jackpotService.deleteJackpot(id);
		return "jackpot deleted";

	}
/*	@PostMapping("/ajouter-Appointement")
	public void ajouterappointement(@RequestBody Appointement appointement){
		appointementService.ajouterAppointement (appointement);
	}*/

	@GetMapping("getAllAppointements")
	public List<Appointement> findAllAppointement(){
		return appointementService.findAllAppointements();
	}

/*	@PutMapping("updateAppointement")
	public Appointement updateAppointement(@RequestBody Appointement appointement){
		return appointementService.updateAppointement(appointement);
	}*/

/*	@DeleteMapping("deleteAppointement")
	public String deleteAppointement(@RequestParam int id){
		appointementService.deleteAppointement(id);
		return "appointement deleted";

	}*/
	@GetMapping("/afficheDispo/{datet}/{datee}")
	@ResponseBody
	public List<String> afficherDispo(@PathVariable("datet")Timestamp datet,@PathVariable("datee")Timestamp datee) {
		return disponibilityService.afficherDispo(datet,datee);		
	}
	
	
	
	
	
	
	
}