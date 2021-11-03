package br.com.saltopetmanager.matheustirabassi.SaltoPetManager;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.saltopetmanager.matheustirabassi.SaltoPetManager.domain.Login;
import br.com.saltopetmanager.matheustirabassi.SaltoPetManager.domain.Tutor;
import br.com.saltopetmanager.matheustirabassi.SaltoPetManager.repositories.LoginRepository;
import br.com.saltopetmanager.matheustirabassi.SaltoPetManager.repositories.TutorRepository;

@SpringBootApplication
public class SaltoPetManagerApplication implements CommandLineRunner{

	@Autowired
	private TutorRepository tutorRepository;
	@Autowired
	private LoginRepository loginRepository;
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	
	public static void main(String[] args) {
		SpringApplication.run(SaltoPetManagerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Tutor tutor1 = new Tutor(Long.parseLong("48386036818"), "Matheus", "tirabassi.matheus@aluno.ifsp.edu.br", sdf.parse("16/04/2000"), "M");
		Tutor tutor2 = new Tutor(Long.parseLong("79268354209"), "Honoria Spilman Barbosa", "HonoriaSpilman@gmail.com", sdf.parse("31/10/1984"), "F");
		tutor1.getCellphones().addAll(Arrays.asList("15991246121", "96989244225"));
		tutor2.getCellphones().addAll(Arrays.asList("(96) 98924-4225", "(96) 3379-2631"));
		Login login1 = new Login(null, "admin", "123");
		Login login2 = new Login(null, "user", "12345");
		
		login1.setTutor(tutor1);
		login2.setTutor(tutor2);
		tutorRepository.saveAll(Arrays.asList(tutor1, tutor2));
		tutor1.setLogin(login1);
		tutor2.setLogin(login2);
		loginRepository.saveAll(Arrays.asList(login1, login2));
		
	}

}
