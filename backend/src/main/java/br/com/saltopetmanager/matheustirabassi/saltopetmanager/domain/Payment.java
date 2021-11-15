package br.com.saltopetmanager.matheustirabassi.saltopetmanager.domain;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import br.com.saltopetmanager.matheustirabassi.saltopetmanager.domain.enums.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Embeddable
@AllArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Data
public abstract class Payment {
	@Id
	private Integer id;
	private Integer status;
	@OneToOne
	@MapsId
	private Scheduling scheduling;

	protected Payment(Integer id, PaymentStatus status) {
		super();
		this.id = id;
		this.status = status.getId();
	}

	public PaymentStatus getStatus() {
		return PaymentStatus.toEnum(status);
	}

	public void setEstado(PaymentStatus status) {
		this.status = status.getId();
	}

}
