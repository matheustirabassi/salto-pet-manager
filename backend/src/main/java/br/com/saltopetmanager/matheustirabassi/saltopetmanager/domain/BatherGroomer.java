package br.com.saltopetmanager.matheustirabassi.saltopetmanager.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class BatherGroomer implements Serializable {

    private static final long serialVersionUID = 1L;
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
