package br.com.saltopetmanager.matheustirabassi.domain.enums;

public enum PaymentStatus {

	PENDING(1, "Pending"), PAID(2, "Paid"), CANCELED(3, "Canceled");

	private int id;
	private String description;

	private PaymentStatus(int id, String description) {
		this.id = id;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public String getDescricao() {
		return description;
	}

	public static PaymentStatus toEnum(Integer type) {
		if (type == null) {
			return null;
		}
		for (PaymentStatus x : PaymentStatus.values()) {
			if (type.equals(x.getId())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Invalid id: " + type);
	}
}
