package tn.esprit.women.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;




@Entity
public class Member implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_member;
	private String prenom;
	private String nom;
	private String age;
	private Integer cin;
	private String adresse;
	private String email;
	private Integer numtel;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy="member")
    private List<Claim> claims;

	@ManyToMany
	private List<Jackpot> jackpots;

	public Member() {
	}

	public Member(Integer id_member, String prenom, String nom, String age, Integer cin, String adresse, String email, Integer numtel, List<Claim> claims, List<Jackpot> jackpots) {
		this.id_member = id_member;
		this.prenom = prenom;
		this.nom = nom;
		this.age = age;
		this.cin = cin;
		this.adresse = adresse;
		this.email = email;
		this.numtel = numtel;
		this.claims = claims;
		this.jackpots = jackpots;
	}

	public Integer getId_member() {
		return id_member;
	}

	public void setId_member(Integer id_member) {
		this.id_member = id_member;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public Integer getCin() {
		return cin;
	}

	public void setCin(Integer cin) {
		this.cin = cin;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getNumtel() {
		return numtel;
	}

	public void setNumtel(Integer numtel) {
		this.numtel = numtel;
	}

	public List<Claim> getClaims() {
		return claims;
	}

	public void setClaims(List<Claim> claims) {
		this.claims = claims;
	}

	public List<Jackpot> getJackpots() {
		return jackpots;
	}

	public void setJackpots(List<Jackpot> jackpots) {
		this.jackpots = jackpots;
	}
}
