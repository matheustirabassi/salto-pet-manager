package br.com.saltopetmanager.matheustirabassi.saltopetmanager.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Scheduling implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@JsonFormat(pattern = "dd/MM/yyyy hh:mm")
	private Date dateTimeSheduled;
	private String observation;

	@ManyToOne
	@JoinColumn(name = "tutor_id")
	private Tutor tutor;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "bathergroomer_id")
	private BatherGroomer batherGroomer;

	@OneToOne
	private Payment payment;

	public Scheduling(Integer id, Date dateTimeSheduled, String observation) {
		this.id = id;
		this.dateTimeSheduled = dateTimeSheduled;
		this.observation = observation;
	}

}
