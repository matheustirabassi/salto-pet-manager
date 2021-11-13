package br.com.saltopetmanager.matheustirabassi.saltopetmanager.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.saltopetmanager.matheustirabassi.saltopetmanager.domain.Login;
import br.com.saltopetmanager.matheustirabassi.saltopetmanager.services.LoginService;

@RestController
@RequestMapping(value = "/logins")
public class LoginResource {
	@Autowired
	private LoginService service;

	@GetMapping(value = "{id}")
	public ResponseEntity<Login> find(@PathVariable Integer id) {
		Login obj = service.find(id);

		return ResponseEntity.ok().body(obj);
	}

	@GetMapping
	public ResponseEntity<List<Login>> findAll() {
		List<Login> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
}
