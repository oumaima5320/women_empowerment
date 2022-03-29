package tn.esprit.women.services.interfaces;


import java.util.List;




import tn.esprit.women.entities.Event;



public interface IEventService {

void ajouterEvent(Event event);


List<Event> listAll();
Event get(Integer id);



public Event saveEvent(Event event);

//update
public Event updateEvent(Event event);

//fetch

public List<Event> findAllEvents();

//delete

public void deleteEvent(int id);
//
}
