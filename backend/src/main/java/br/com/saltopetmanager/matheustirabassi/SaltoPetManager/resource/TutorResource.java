package br.com.saltopetmanager.matheustirabassi.SaltoPetManager.resource;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.saltopetmanager.matheustirabassi.SaltoPetManager.domain.Tutor;

@RestController
@RequestMapping(value = "/tutors")
public class TutorResource {

	@RequestMapping(method = RequestMethod.GET)
	public List<Tutor> list() throws NumberFormatException, ParseException {
		List<Tutor> tutors = new ArrayList<>();
		Tutor tutor1 = new Tutor(Long.parseLong("48386036818"), "Matheus", 
				"tirabassi.matheus@aluno.ifsp.edu.br", new SimpleDateFormat("dd/MM/yyyy").parse("16/04/2000"), "M");
		tutors.add(tutor1);
		
		return tutors;
	}
}
