package tn.esprit.women.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import tn.esprit.women.entities.Appointement;
import tn.esprit.women.entities.Member;
import tn.esprit.women.entities.Supervisor;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

@Service
public class EmailServiceImpl implements IEmailService{

    @Autowired
    private JavaMailSender emailSender;


    @Override
    public void sendMailToSuperviserAndMember(Supervisor supervisor, Member member, Appointement appointement) {

        // Email to supervisor
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(supervisor.getEmail());
        message.setSubject("You have a new appointment!");
        message.setText(String.format(
                "Hello Mr. %s," +
                "\n\nThank you for your confidence!" +
                "\nAccording to your collaboration, You have chosen to be a supervisor for our client Mr. %s. His phone number is %s." +
                "\nThe appointment is set at %s."+
                "\nDon't hesitate to contact us for any further details." +
                "\n\nCordially,",
                supervisor.getLastName() + " " + supervisor.getFirstName(),
                member.getNom() + " "+ member.getPrenom(),
                member.getNumtel(),
                appointement.getDate()
                ));
        emailSender.send(message);

        // Email to member
        message.setTo(member.getEmail());
        message.setSubject("An appointement has been set for you!");
        message.setText(String.format(
                "Hello Mr. %s," +
                "\n\nThank you for your confidence!" +
                "\nAccording to your claim, we have settled you an appointment with our supervisor Mr. %s. You can call him on %s." +
                "\nThe appointment date is : %s." +
                "\nDon't hesitate to contact us for any further details." +
                "\n\nCordially,",
                member.getNom() + " "+ member.getPrenom(),
                supervisor.getLastName() + " " + supervisor.getFirstName(),
                supervisor.getPhoneNumber(),
                appointement.getDate()
        ));
        emailSender.send(message);

    }
}
