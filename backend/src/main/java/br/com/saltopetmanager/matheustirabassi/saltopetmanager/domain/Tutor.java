package br.com.saltopetmanager.matheustirabassi.saltopetmanager.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Tutor implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@NonNull
	@Column(unique = true)
	private Long cpf;
	private String name;
	@Column(unique = true)
	private String email;
	@JsonFormat(pattern = "dd/MM/yyyy")
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
	@JsonIgnore
	@OneToMany(mappedBy = "tutor")
	private List<Address> addresses = new ArrayList<>();

	public Tutor(Long cpf, String name, String email) {
		this.cpf = cpf;
		this.name = name;
		this.email = email;
	}

}
