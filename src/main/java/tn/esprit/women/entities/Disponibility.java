package tn.esprit.women.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.*;


@Entity
public class Disponibility  implements Serializable {
	private static final long serialVersionUID = 1L;
	@Temporal(TemporalType.TIMESTAMP)
	private Date date_debut_dis;
	@Temporal(TemporalType.TIMESTAMP)
	private Date date_fin_dis;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_supervisor;

	public Disponibility(Date date_debut_dis, Date date_fin_dis, Integer id_supervisor) {
		super();
		this.date_debut_dis = date_debut_dis;
		this.date_fin_dis = date_fin_dis;
		this.id_supervisor = id_supervisor;
	}

	public Date getDate_debut_dis() {
		return date_debut_dis;
	}

	public void setDate_debut_dis(Date date_debut_dis) {
		this.date_debut_dis = date_debut_dis;
	}

	public Date getDate_fin_dis() {
		return date_fin_dis;
	}

	public void setDate_fin_dis(Date date_fin_dis) {
		this.date_fin_dis = date_fin_dis;
	}

	public Integer getId_supervisor() {
		return id_supervisor;
	}

	public void setId_supervisor(Integer id_supervisor) {
		this.id_supervisor = id_supervisor;
	}

	public Disponibility() {
		super();
	} 

	
}
