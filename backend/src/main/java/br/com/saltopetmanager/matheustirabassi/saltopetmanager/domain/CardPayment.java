package br.com.saltopetmanager.matheustirabassi.saltopetmanager.domain;

import javax.persistence.Embeddable;
import javax.persistence.Entity;

import br.com.saltopetmanager.matheustirabassi.saltopetmanager.domain.enums.PaymentStatus;

@Entity
@Embeddable
public class CardPayment extends Payment {

	private Integer installmentsNumber;

	public CardPayment(Integer id, PaymentStatus status, Integer installmentsNumber) {
		super(id, status);
		this.installmentsNumber = installmentsNumber;
	}

	public Integer getInstallmentsNumber() {
		return installmentsNumber;
	}

	public void setInstallmentsNumber(Integer installmentsNumber) {
		this.installmentsNumber = installmentsNumber;
	}

}
