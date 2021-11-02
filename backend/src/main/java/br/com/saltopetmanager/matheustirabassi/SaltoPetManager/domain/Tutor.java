package br.com.saltopetmanager.matheustirabassi.SaltoPetManager.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Tutor implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long cpf;
	private String name;
	private String email;
	private Date birthDate;
	private String gender;
	
	public Tutor() {
	}
	public Tutor(Long cpf, String name, String email, Date birthDate, String gender) {
		this.cpf = cpf;
		this.name = name;
		this.email = email;
		this.birthDate = birthDate;
		this.gender = gender;
	}
	public Long getCpf() {
		return cpf;
	}
	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(cpf);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tutor other = (Tutor) obj;
		return Objects.equals(cpf, other.cpf);
	}
	
	
	
}
