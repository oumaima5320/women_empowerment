package tn.esprit.women.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
public class Claim implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String subject;
	
	private String content;

	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date date;
	
	@ManyToOne
    @JoinColumn(name="id_member", nullable=false)
	@JsonIgnore
    private Member member;
	
	@OneToOne(mappedBy = "claim", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Appointement appointement;


	public Claim() {
	}
	
	


	public Claim(Integer id, String subject, String content, Date date, Member member, Appointement appointement) {
		super();
		this.id = id;
		this.subject = subject;
		this.content = content;
		this.date = date;
		this.member = member;
		this.appointement = appointement;
	}




	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getSubject() {
		return subject;
	}


	public void setSubject(String subject) {
		this.subject = subject;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public Member getMember() {
		return member;
	}


	public void setMember(Member member) {
		this.member = member;
	}


	public Appointement getAppointement() {
		return appointement;
	}


	public void setAppointement(Appointement appointement) {
		this.appointement = appointement;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
