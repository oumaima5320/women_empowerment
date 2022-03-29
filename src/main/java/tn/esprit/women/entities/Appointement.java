package tn.esprit.women.entities;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Appointement  {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate date;

	@ManyToOne()
	@JoinColumn(name = "id_supervisor")
	@JsonIgnore
	private Supervisor supervisor;
	
	@OneToOne
	@JsonIgnore
    private Claim claim;


	public Appointement() {
	}

	public Appointement(Integer id, LocalDate date, Supervisor supervisor, Claim claim) {
		this.id = id;
		this.date = date;
		this.supervisor = supervisor;
		this.claim = claim;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Supervisor getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(Supervisor supervisor) {
		this.supervisor = supervisor;
	}

	public Claim getClaim() {
		return claim;
	}

	public void setClaim(Claim claim) {
		this.claim = claim;
	}
}
