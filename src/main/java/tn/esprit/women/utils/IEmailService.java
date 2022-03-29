package tn.esprit.women.utils;

import tn.esprit.women.entities.Appointement;
import tn.esprit.women.entities.Member;
import tn.esprit.women.entities.Supervisor;

public interface IEmailService {
    void sendMailToSuperviserAndMember(Supervisor supervisor, Member member, Appointement appointement);
}
