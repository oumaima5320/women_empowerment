package tn.esprit.women.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

import java.util.Date;
import java.util.List;


import javax.persistence.*;

@Entity
public class Jackpot implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Integer id_jakpot;
	private Integer amount_reached;
	@Temporal(TemporalType.DATE)
	private Date dated;
	private Date datef;

	@ManyToMany(mappedBy = "jackpots",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Member> members;

	//private Integer id_member;
	//private Integer id_Event;


	public Jackpot() {
	}

	public Jackpot(Integer id_jakpot, Integer amount_reached, Date dated, Date datef, List<Member> members) {
		this.id_jakpot = id_jakpot;
		this.amount_reached = amount_reached;
		this.dated = dated;
		this.datef = datef;
		this.members = members;
	}

	public Integer getId_jakpot() {
		return id_jakpot;
	}

	public void setId_jakpot(Integer id_jakpot) {
		this.id_jakpot = id_jakpot;
	}

	public Integer getAmount_reached() {
		return amount_reached;
	}

	public void setAmount_reached(Integer amount_reached) {
		this.amount_reached = amount_reached;
	}

	public Date getDated() {
		return dated;
	}

	public void setDated(Date dated) {
		this.dated = dated;
	}

	public Date getDatef() {
		return datef;
	}

	public void setDatef(Date datef) {
		this.datef = datef;
	}

	public List<Member> getMembers() {
		return members;
	}

	public void setMembers(List<Member> members) {
		this.members = members;
	}
}
