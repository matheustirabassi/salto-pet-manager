package br.com.saltopetmanager.matheustirabassi.services;

import java.util.List;
import java.util.Optional;

import br.com.saltopetmanager.matheustirabassi.domain.Scheduling;
import br.com.saltopetmanager.matheustirabassi.repositories.SchedulingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class SchedulingService {

	@Autowired
	private SchedulingRepository repo;

	public Scheduling find(Integer id) {
		log.info("Finding Scheduling by id...");
		Optional<Scheduling> obj = repo.findById(id);
		return obj.orElse(null);
	}

	public List<Scheduling> findAll() {
		log.debug("Finding all Scheduling ...");
		return repo.findAll();
	}
}