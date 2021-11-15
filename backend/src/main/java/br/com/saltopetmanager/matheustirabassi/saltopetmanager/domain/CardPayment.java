package br.com.saltopetmanager.matheustirabassi.saltopetmanager.domain;

import java.io.Serializable;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class CardPayment extends Payment implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer installmentsNumber;

	public CardPayment(Integer id, Integer status, Integer installmentsNumber) {
		super(id, status);
		this.installmentsNumber = installmentsNumber;
	}

	public CardPayment(Integer id, Integer status) {
		super(id, status);
	}

}
