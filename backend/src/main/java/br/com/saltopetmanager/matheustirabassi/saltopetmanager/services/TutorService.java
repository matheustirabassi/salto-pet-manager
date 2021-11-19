package br.com.saltopetmanager.matheustirabassi.saltopetmanager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.saltopetmanager.matheustirabassi.saltopetmanager.domain.Tutor;
import br.com.saltopetmanager.matheustirabassi.saltopetmanager.repositories.TutorRepository;
import lombok.extern.log4j.Log4j2;

import javax.persistence.Query;

@Log4j2
@Service
public class TutorService {

    @Autowired
    private TutorRepository repo;

    public Tutor find(Long cpf) {
        log.info("Finding tutor by id...");
        Optional<Tutor> obj = repo.findById(cpf);
        return obj.orElse(null);
    }

    public List<Tutor> findAll() {
        log.info("Finding all tutors...");
        return repo.findAll();
    }
}
