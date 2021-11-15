package br.com.saltopetmanager.matheustirabassi.saltopetmanager.domain;

import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.Entity;

import br.com.saltopetmanager.matheustirabassi.saltopetmanager.domain.enums.PaymentStatus;

@Embeddable
@Entity
public class CashSlips extends Payment {

	private Date dueDate;
	private Date paymentDate;

	public CashSlips(Integer id, PaymentStatus status, Date dueDate, Date paymentDate) {
		super(id, status);
		this.dueDate = dueDate;
		this.paymentDate = paymentDate;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

}
