package br.com.saltopetmanager.matheustirabassi.SaltoPetManager.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.saltopetmanager.matheustirabassi.SaltoPetManager.domain.Login;
import br.com.saltopetmanager.matheustirabassi.SaltoPetManager.services.LoginService;

@RestController
@RequestMapping(value = "/logins")
public class LoginResource {
	@Autowired
	private LoginService service;

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Login obj = service.find(id);

		return ResponseEntity.ok().body(obj);
	}
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> findAll() {
		List<Login> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
}
