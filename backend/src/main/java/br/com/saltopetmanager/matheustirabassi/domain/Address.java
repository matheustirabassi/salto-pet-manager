package br.com.saltopetmanager.matheustirabassi.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Address implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String street;
	private String number;
	private String complement;
	private String district;
	private String cep;

	@ManyToOne
	private City city;

	public Address(Integer id, String street, String number, String complement, String district, String cep) {
		this.id = id;
		this.street = street;
		this.number = number;
		this.complement = complement;
		this.district = district;
		this.cep = cep;
	}

}
