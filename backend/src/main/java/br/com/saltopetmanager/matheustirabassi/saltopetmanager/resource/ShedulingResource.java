package br.com.saltopetmanager.matheustirabassi.saltopetmanager.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.saltopetmanager.matheustirabassi.saltopetmanager.domain.Scheduling;
import br.com.saltopetmanager.matheustirabassi.saltopetmanager.services.SchedulingService;

@RestController
@RequestMapping(value = "/schedulings")
public class ShedulingResource {
	@Autowired
	private SchedulingService service;

	@GetMapping(value = "{id}")
	public ResponseEntity<Scheduling> find(@PathVariable Integer id) {
		Scheduling obj = service.find(id);

		return ResponseEntity.ok().body(obj);
	}

	@GetMapping
	public ResponseEntity<List<Scheduling>> findAll() {
		List<Scheduling> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
}
