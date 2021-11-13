package br.com.saltopetmanager.matheustirabassi.saltopetmanager.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Embeddable
public class Tutor {
	@Id
	@NonNull
	private Long cpf;
	private String name;
	private String email;
	private Date birthDate;
	private String gender;

	@ElementCollection
	@CollectionTable(name = "tutor_cellphone", joinColumns = @JoinColumn(name = "cpf_tutor"))
	@Fetch(FetchMode.JOIN)
	private Set<String> cellphones = new HashSet<>();

	@OneToOne
	private Login login;

	@JsonIgnore
	@OneToMany(mappedBy = "tutor")
	private List<Scheduling> schedulings = new ArrayList<>();
	public Tutor(Long cpf, String name, String email, Date birthDate, String gender) {
		this.cpf = cpf;
		this.name = name;
		this.email = email;
		this.birthDate = birthDate;
		this.gender = gender;
	}

}
