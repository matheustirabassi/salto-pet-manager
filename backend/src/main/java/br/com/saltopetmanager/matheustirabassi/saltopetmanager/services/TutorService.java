package br.com.saltopetmanager.matheustirabassi.saltopetmanager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.saltopetmanager.matheustirabassi.saltopetmanager.domain.Tutor;
import br.com.saltopetmanager.matheustirabassi.saltopetmanager.repositories.TutorRepository;

@Service
public class TutorService {

    @Autowired
    private TutorRepository repo;

    public Tutor find(Long cpf) {
	Optional<Tutor> obj = repo.findById(cpf);
	return obj.orElse(null);
    }

    public List<Tutor> findAll() {
	return repo.findAll();
    }
}
