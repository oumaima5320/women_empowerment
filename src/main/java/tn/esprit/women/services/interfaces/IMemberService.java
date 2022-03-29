package tn.esprit.women.services.interfaces;

import java.util.List;

import tn.esprit.women.entities.Member;

public interface IMemberService {

void ajouterMember(Member member);
List<Member> listAll();
Member get(Long id);


}
