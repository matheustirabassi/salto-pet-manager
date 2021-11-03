package br.com.saltopetmanager.matheustirabassi.SaltoPetManager.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Scheduling implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Date dateTimeSheduled;
	private String observation;
	
	@ManyToOne
	@JoinColumn(name = "tutorId")
	private Tutor tutor;
	
	public Scheduling() {
	}
	public Scheduling(Integer id, Date dateTimeSheduled, String observation) {
		this.id = id;
		this.dateTimeSheduled = dateTimeSheduled;
		this.observation = observation;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getDateTimeSheduled() {
		return dateTimeSheduled;
	}
	public void setDateTimeSheduled(Date dateTimeSheduled) {
		this.dateTimeSheduled = dateTimeSheduled;
	}
	public String getObservation() {
		return observation;
	}
	public void setObservation(String observation) {
		this.observation = observation;
	}
	
	public Tutor getTutor() {
		return tutor;
	}
	public void setTutor(Tutor tutor) {
		this.tutor = tutor;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Scheduling other = (Scheduling) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
