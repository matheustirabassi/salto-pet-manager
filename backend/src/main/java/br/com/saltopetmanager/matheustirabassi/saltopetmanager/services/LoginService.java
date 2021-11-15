package br.com.saltopetmanager.matheustirabassi.saltopetmanager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.saltopetmanager.matheustirabassi.saltopetmanager.domain.Login;
import br.com.saltopetmanager.matheustirabassi.saltopetmanager.repositories.LoginRepository;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class LoginService {

	@Autowired
	private LoginRepository repo;

	public Login findById(Integer id) {
		log.info("Finding login by id..");
		Optional<Login> obj = repo.findById(id);
		return obj.orElse(null);
	}

	public Login findByLogin(String user) {
		log.info("Finding login by user..");
		Optional<Login> obj = repo.findByUser(user);
		return obj.orElse(null);
	}

	public List<Login> findAll() {
		log.info("Finding all logins..");
		return repo.findAll();
	}

	public Login save(Login login) {
		log.info("Saving class login...");
		return repo.save(login);
	}

}
