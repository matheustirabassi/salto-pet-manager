package br.com.saltopetmanager.matheustirabassi.saltopetmanager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.saltopetmanager.matheustirabassi.saltopetmanager.domain.BatherGroomer;
import br.com.saltopetmanager.matheustirabassi.saltopetmanager.repositories.BatherGroomerRepository;
import lombok.extern.log4j.Log4j2;
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
