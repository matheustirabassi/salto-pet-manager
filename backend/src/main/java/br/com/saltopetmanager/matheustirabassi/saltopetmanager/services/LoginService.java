package br.com.saltopetmanager.matheustirabassi.saltopetmanager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.saltopetmanager.matheustirabassi.saltopetmanager.domain.Login;
import br.com.saltopetmanager.matheustirabassi.saltopetmanager.repositories.LoginRepository;

@Service
public class LoginService {

	@Autowired
	private LoginRepository repo;

	public Login find(Integer id) {
		Optional<Login> obj = repo.findById(id);
		return obj.orElse(null);
	}

	public List<Login> findAll() {
		return repo.findAll();
	}
}
