package br.com.saltopetmanager.matheustirabassi.SaltoPetManager.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.saltopetmanager.matheustirabassi.SaltoPetManager.domain.Tutor;
import br.com.saltopetmanager.matheustirabassi.SaltoPetManager.services.TutorService;

@RestController
@RequestMapping(value = "/tutors")
public class TutorResource {
	@Autowired
	private TutorService service;
	
	@RequestMapping(value = "{cpf}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Long cpf){
		Tutor obj = service.find(cpf);
		
		return ResponseEntity.ok().body(obj);
	}
}
