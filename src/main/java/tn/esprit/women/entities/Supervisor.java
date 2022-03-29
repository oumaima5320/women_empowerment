package tn.esprit.women.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
public class Supervisor implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String firstName;

	private String lastName;

	private String cin;

	private String email;

	private String phoneNumber;

	@Enumerated(EnumType.STRING)
	private SupervisorType type;

	@OneToMany(mappedBy = "supervisor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Appointement> appointements;

	public Supervisor() {
	}

	public Supervisor(int id, String firstName, String lastName, String cin, String email, String phoneNumber, SupervisorType type, List<Appointement> appointements) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.cin = cin;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.type = type;
		this.appointements = appointements;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public SupervisorType getType() {
		return type;
	}

	public void setType(SupervisorType type) {
		this.type = type;
	}

	public List<Appointement> getAppointements() {
		return appointements;
	}

	public void setAppointements(List<Appointement> appointements) {
		this.appointements = appointements;
	}
}
