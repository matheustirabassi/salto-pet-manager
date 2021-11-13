package br.com.saltopetmanager.matheustirabassi.saltopetmanager.domain;

import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Embeddable
public class Scheduling {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Date dateTimeSheduled;
	private String observation;


	@ManyToOne
	@JoinColumn(name = "tutor_id")
	private Tutor tutor;


	@ManyToOne
	@JoinColumn(name = "bathergroomer_id")
	private BatherGroomer batherGroomer;
	public Scheduling(Integer id, Date dateTimeSheduled, String observation) {
		this.id = id;
		this.dateTimeSheduled = dateTimeSheduled;
		this.observation = observation;
	}

}
