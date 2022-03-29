package tn.esprit.women.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.women.entities.Event;

@Repository
public interface EventRepository extends CrudRepository<Event , Integer>{

}
