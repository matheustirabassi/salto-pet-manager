package br.com.saltopetmanager.matheustirabassi.saltopetmanager.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class BoletoPayment extends Payment implements Serializable {

	private static final long serialVersionUID = 1L;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dueDate;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date paymentDate;

	public BoletoPayment(Integer id, Integer status) {
		super(id, status);
	}

	public BoletoPayment(Integer id, Integer status, Date dueDate, Date paymentDate) {
		super(id, status);
		this.dueDate = dueDate;
		this.paymentDate = paymentDate;
	}

}
