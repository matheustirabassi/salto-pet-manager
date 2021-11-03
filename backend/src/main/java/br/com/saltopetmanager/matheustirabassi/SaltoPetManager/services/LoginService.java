package br.com.saltopetmanager.matheustirabassi.SaltoPetManager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.saltopetmanager.matheustirabassi.SaltoPetManager.domain.Login;
import br.com.saltopetmanager.matheustirabassi.SaltoPetManager.repositories.LoginRepository;
@Service
public class LoginService {
	
	@Autowired
	private LoginRepository repo;
	
	public Login find(Integer id) {
		Optional<Login> obj = repo.findById(id);
		return obj.orElse(null);
	}
	public List<Login> findAll(){
		List<Login> obj = repo.findAll();
		return obj;
	}
}
