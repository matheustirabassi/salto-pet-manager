package br.com.saltopetmanager.matheustirabassi.saltopetmanager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.saltopetmanager.matheustirabassi.saltopetmanager.domain.Address;
import br.com.saltopetmanager.matheustirabassi.saltopetmanager.repositories.AdressRepository;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class AdressService {

	@Autowired
	private AdressRepository repo;

	public Optional<Address> findById(Integer id) {
		return repo.findById(id);
	}

	public List<Address> findAll() {
		log.info("Finding all addresss..");
		return repo.findAll();
	}

	public Address save(Address address) {
		log.info("Saving class address...");
		return repo.save(address);
	}

}
