package tn.esprit.women.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.women.entities.Member;


@Repository
public interface MemberRepository extends CrudRepository<Member, Integer> {

}
