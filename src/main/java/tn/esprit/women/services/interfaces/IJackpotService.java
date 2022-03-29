package tn.esprit.women.services.interfaces;

import java.util.List;


import tn.esprit.women.entities.Jackpot;

public interface IJackpotService  {

void ajouterJackpot(Jackpot jackpot);


public Jackpot saveJackpot(Jackpot jackpot);

//update
public Jackpot updateJackpot(Jackpot jackpot);

//fetch

public List<Jackpot> findAllJackpots();

//delete

public void deleteJackpot(int id);
//




}