package tn.esprit.women.services.Implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.women.entities.Member;
import tn.esprit.women.repositories.MemberRepository;
import tn.esprit.women.services.interfaces.IMemberService;

@Service
public class MemberServiceImp implements IMemberService {

@Autowired
MemberRepository memberRepository;

@Override
public void ajouterMember(Member member) {
memberRepository.save(member);
}


public List<Member> listAll() {
return (List<Member>) memberRepository.findAll();
}

public Member get(Integer id) {
return memberRepository.findById(id).get();
}


@Override
public Member get(Long id) {
// TODO Auto-generated method stub
return null;
}




public MemberServiceImp() {
super();
// TODO Auto-generated constructor stub
}

}