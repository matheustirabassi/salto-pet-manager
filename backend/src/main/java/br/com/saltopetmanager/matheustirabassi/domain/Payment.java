package br.com.saltopetmanager.matheustirabassi.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import br.com.saltopetmanager.matheustirabassi.domain.enums.PaymentStatus;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Payment implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;
	private Integer status;

	protected Payment(Integer id, Integer status) {
		super();
		this.id = id;
		this.status = status;

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public PaymentStatus getStatus() {
		return PaymentStatus.toEnum(status);
	}

	public void setStatus(PaymentStatus status) {
		this.status = status.getId();
	}

}
