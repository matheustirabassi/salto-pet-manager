package br.com.saltopetmanager.matheustirabassi.saltopetmanager;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.saltopetmanager.matheustirabassi.saltopetmanager.domain.BatherGroomer;
import br.com.saltopetmanager.matheustirabassi.saltopetmanager.domain.Login;
import br.com.saltopetmanager.matheustirabassi.saltopetmanager.domain.Scheduling;
import br.com.saltopetmanager.matheustirabassi.saltopetmanager.domain.Tutor;
import br.com.saltopetmanager.matheustirabassi.saltopetmanager.repositories.BatherGroomerRepository;
import br.com.saltopetmanager.matheustirabassi.saltopetmanager.repositories.LoginRepository;
import br.com.saltopetmanager.matheustirabassi.saltopetmanager.repositories.SchedulingRepository;
import br.com.saltopetmanager.matheustirabassi.saltopetmanager.repositories.TutorRepository;

@SpringBootApplication
public class SaltoPetManagerApplication implements CommandLineRunner {

	@Autowired
	private TutorRepository tutorRepository;
	@Autowired
	private LoginRepository loginRepository;
	@Autowired
	private SchedulingRepository schedulingRepository;
	@Autowired
	private BatherGroomerRepository batherGroomerRepository;

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public static void main(String[] args) {
		SpringApplication.run(SaltoPetManagerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Login login1 = new Login(null, "admin", "123");
		Login login2 = new Login(null, "user", "12345");

		loginRepository.saveAll(Arrays.asList(login1, login2));

		BatherGroomer batherGroomer1 = new BatherGroomer(Long.parseLong("43464837394"), "Suellem Peçanha Morais",
				"suellem.morais@geradornv.com.br", sdf.parse("22/02/1986"), "F");
		batherGroomer1.getCellphones().addAll(Arrays.asList("(88) 97928-8376", "159974244"));
		batherGroomerRepository.save(batherGroomer1);
		Tutor tutor1 = new Tutor(Long.parseLong("48386036818"), "Matheus", "tirabassi.matheus@aluno.ifsp.edu.br",
				sdf.parse("16/04/2000"), "M");
		Tutor tutor2 = new Tutor(Long.parseLong("79268354209"), "Honoria Spilman Barbosa", "HonoriaSpilman@gmail.com",
				sdf.parse("31/10/1984"), "F");
		tutor2.getCellphones().addAll(Arrays.asList("159915123", "151233"));
		tutor1.setLogin(login1);
		tutor2.setLogin(login2);
		tutorRepository.saveAll(Arrays.asList(tutor1, tutor2));

		Scheduling scheduling1 = new Scheduling(null, new Date(), "Importante");
		batherGroomer1.getCustomerServices().add(scheduling1);
		tutor1.getSchedulings().add(scheduling1);
		scheduling1.setTutor(tutor1);
		scheduling1.setBatherGroomer(batherGroomer1);

		schedulingRepository.save(scheduling1);
	}

}
