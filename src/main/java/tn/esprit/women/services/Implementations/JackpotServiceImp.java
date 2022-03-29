package tn.esprit.women.services.Implementations;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import tn.esprit.women.entities.Jackpot;

import tn.esprit.women.repositories.JackpotRepository;
import tn.esprit.women.services.interfaces.IJackpotService;


@Service
public class JackpotServiceImp implements IJackpotService {

@Autowired
JackpotRepository jackpotRepository;

@Override
public void ajouterJackpot(Jackpot jackpot) {
jackpotRepository.save(jackpot);
}

public List<Jackpot> listAll() {
return (List<Jackpot>) jackpotRepository.findAll();
}

public Jackpot get(Integer id) {
return jackpotRepository.findById(id).get();
}

@Override
public Jackpot saveJackpot(Jackpot jackpot) {
// TODO Auto-generated method stub
return jackpotRepository.save(jackpot) ;
}

@Override
public Jackpot updateJackpot(Jackpot jackpot) {
// TODO Auto-generated method stub
return jackpotRepository.save(jackpot);
}

@Override
public List<Jackpot> findAllJackpots() {
// TODO Auto-generated method stub
return (List<Jackpot>)jackpotRepository.findAll();
}

@Override
public void deleteJackpot(int id) {
// TODO Auto-generated method stub
jackpotRepository.deleteById(id);
}


}
