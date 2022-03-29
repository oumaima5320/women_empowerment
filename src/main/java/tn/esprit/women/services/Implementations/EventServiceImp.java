package tn.esprit.women.services.Implementations;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import tn.esprit.women.entities.Event;
import tn.esprit.women.repositories.EventRepository;
import tn.esprit.women.services.interfaces.IEventService;


@Service
public class EventServiceImp implements IEventService {

@Autowired
EventRepository eventRepository;

@Override
public void ajouterEvent(Event event) {
eventRepository.save(event);
}


public List<Event> listAll() {
return (List<Event>) eventRepository.findAll();
}

public Event get(Integer id) {
return eventRepository.findById(id).get();
}


@Override
public Event saveEvent(Event event) {
// TODO Auto-generated method stub
return eventRepository.save(event) ;
}


@Override
public Event updateEvent(Event event) {
// TODO Auto-generated method stub
return eventRepository.save(event);
}


@Override
public List<Event> findAllEvents() {
// TODO Auto-generated method stub
return (List<Event>)eventRepository.findAll();
}


@Override
public void deleteEvent(int id) {
// TODO Auto-generated method stub
eventRepository.deleteById(id);

}
}
