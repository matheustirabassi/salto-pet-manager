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
@Embeddable
@Entity
public class BatherGroomer {
    @Id
    @NonNull
    private Long cpf;
    private String name;
    private String email;
    private Date birthDate;
    private String gender;

    @ElementCollection
    @CollectionTable(name = "bathergroomer_cellphone", joinColumns = @JoinColumn(name = "cpf_bathergroomer"))
    @Fetch(FetchMode.JOIN)
    private Set<String> cellphones = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "batherGroomer")
    private final List<Scheduling> customerServices = new ArrayList<>();

    public BatherGroomer(Long cpf, String name, String email, Date birthDate, String gender) {
	this.cpf = cpf;
	this.name = name;
	this.email = email;
	this.birthDate = birthDate;
	this.gender = gender;
    }

}
