package br.com.saltopetmanager.matheustirabassi.saltopetmanager.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.saltopetmanager.matheustirabassi.saltopetmanager.domain.BatherGroomer;
import br.com.saltopetmanager.matheustirabassi.saltopetmanager.services.BatherGroomerService;

@RestController
@RequestMapping(value = "/bathergroomers")
public class BatherGroomerResource {
	@Autowired
	private BatherGroomerService service;

	@GetMapping(value = "{id}")
	public ResponseEntity<BatherGroomer> find(@PathVariable Long id) {
		BatherGroomer obj = service.find(id);

		return ResponseEntity.ok().body(obj);
	}

	@GetMapping()
	public ResponseEntity<List<BatherGroomer>> findAll() {
		List<BatherGroomer> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
}
