package br.com.saltopetmanager.matheustirabassi.services;

import br.com.saltopetmanager.matheustirabassi.domain.BatherGroomer;
import br.com.saltopetmanager.matheustirabassi.repositories.BatherGroomerRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Log4j2
@Service
public class BatherGroomerService {

    @Autowired
    private BatherGroomerRepository repo;

    public BatherGroomer find(Long id) {
        log.info("finding BatherGroomer...");
        Optional<BatherGroomer> obj = repo.findById(id);
        return obj.orElse(null);
    }

    public List<BatherGroomer> findAll() {
        return repo.findAll();
    }
}