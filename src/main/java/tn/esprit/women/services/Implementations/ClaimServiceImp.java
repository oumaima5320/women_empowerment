package tn.esprit.women.services.Implementations;



import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.women.entities.Appointement;
import tn.esprit.women.entities.Claim;
import tn.esprit.women.entities.Member;
import tn.esprit.women.repositories.AppointementRepository;
import tn.esprit.women.repositories.ClaimRepository;
import tn.esprit.women.repositories.MemberRepository;
import tn.esprit.women.services.interfaces.IAppointementService;
import tn.esprit.women.services.interfaces.IClaimService;


@Service
public class ClaimServiceImp implements IClaimService {

	@Autowired
	private ClaimRepository claimRepository;

	@Autowired
	private MemberRepository memberRepository;

	@Autowired
	private IAppointementService appointementService;


	@Override
	public List<Claim> findAllClaims() {
		return (List<Claim>) claimRepository.findAll();
	}

	@Override
	public Claim findClaimById(int claimId) throws Exception {
		return claimRepository.findById(claimId)
				.orElseThrow(() ->  new Exception("Claim is not found!"));
	}

	@Override
	public Claim addClaim(Claim claim, int idMember) throws Exception{
		Optional<Member> member = memberRepository.findById(idMember);
		if(member.isPresent()){
			claim.setDate(new Date());
			claim.setMember(member.get());
			return claimRepository.save(claim);
		} else {
			throw new Exception("Member is not found!");
		}
	}

	@Override
	public Claim updateClaim(Claim claim, int idMember) throws Exception {
		Optional<Claim> claim1 = claimRepository.findById(claim.getId());
		Optional<Member> member = memberRepository.findById(idMember);
		if(claim1.isPresent()){
			if(member.isPresent()){
				Appointement appointement = claim1.get().getAppointement();
				claim.setAppointement(appointement);
				claim.setDate(new Date());
				claim.setMember(member.get());
				return claimRepository.save(claim);
			} else {
				throw new Exception("Member is not found!");
			}
		} else {
			throw new Exception("Claim is not found!");
		}
	}

	@Override
	public String deleteClaim(int claimId) throws Exception {
		Optional<Claim> claim = claimRepository.findById(claimId);
		if(claim.isPresent()){
			Member member = claim.get().getMember();
			member.setClaims(null);
			memberRepository.save(member);
			if(claim.get().getAppointement() != null){
				appointementService.deleteAppointement(claim.get().getAppointement().getId());
			}
			claimRepository.deleteById(claimId);
			return "Claim is deleted successfully!";
		} else {
			throw new Exception("Claim is not found!");
		}
	}
}
