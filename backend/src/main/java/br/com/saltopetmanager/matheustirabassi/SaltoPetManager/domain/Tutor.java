package br.com.saltopetmanager.matheustirabassi.SaltoPetManager.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Tutor implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	private Long cpf;
	private String name;
	private String email;
	private Date birthDate;
	private String gender;

	@ElementCollection
	@CollectionTable(name = "cellphone")
	private Set<String> cellphones = new HashSet<>();

	@JsonManagedReference
	@OneToOne(mappedBy = "tutor")
	private Login login;

	@JsonIgnore
	@OneToMany(mappedBy = "tutor")
	private List<Scheduling> schedulings;

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

	public Set<String> getCellphones() {
		return cellphones;
	}

	public void setCellphones(Set<String> cellphones) {
		this.cellphones = cellphones;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public List<Scheduling> getSchedulings() {
		return schedulings;
	}

	public void setSchedulings(List<Scheduling> schedulings) {
		this.schedulings = schedulings;
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
