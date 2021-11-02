package br.com.saltopetmanager.matheustirabassi.SaltoPetManager.resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/tutors")
public class TutorResource {
	
	@RequestMapping(method = RequestMethod.GET)
	public String  list() {
		return "REST is working!";
	}
}
