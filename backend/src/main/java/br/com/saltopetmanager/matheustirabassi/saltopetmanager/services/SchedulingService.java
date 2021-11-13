package br.com.saltopetmanager.matheustirabassi.saltopetmanager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.saltopetmanager.matheustirabassi.saltopetmanager.domain.Scheduling;
import br.com.saltopetmanager.matheustirabassi.saltopetmanager.repositories.SchedulingRepository;

@Service
public class SchedulingService {

	@Autowired
	private SchedulingRepository repo;

	public Scheduling find(Integer id) {
		Optional<Scheduling> obj = repo.findById(id);
		return obj.orElse(null);
	}

	public List<Scheduling> findAll() {
		return repo.findAll();
	}
}
