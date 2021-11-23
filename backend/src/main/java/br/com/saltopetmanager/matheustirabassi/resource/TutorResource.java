package br.com.saltopetmanager.matheustirabassi.resource;

import java.util.List;

import br.com.saltopetmanager.matheustirabassi.domain.Tutor;
import br.com.saltopetmanager.matheustirabassi.services.TutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/tutors")
public class TutorResource {
	@Autowired
	private TutorService service;

	@GetMapping(value = "{cpf}")
	public ResponseEntity<Tutor> find(@PathVariable Long cpf) {
		Tutor obj = service.find(cpf);

		return ResponseEntity.ok().body(obj);
	}

	@GetMapping
	public ResponseEntity<List<Tutor>> findAll() {
		List<Tutor> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
}
