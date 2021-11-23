package br.com.saltopetmanager.matheustirabassi;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import br.com.saltopetmanager.matheustirabassi.domain.Address;
import br.com.saltopetmanager.matheustirabassi.domain.BatherGroomer;
import br.com.saltopetmanager.matheustirabassi.domain.City;
import br.com.saltopetmanager.matheustirabassi.domain.Scheduling;
import br.com.saltopetmanager.matheustirabassi.domain.State;
import br.com.saltopetmanager.matheustirabassi.domain.Tutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.saltopetmanager.matheustirabassi.repositories.AdressRepository;
import br.com.saltopetmanager.matheustirabassi.repositories.BatherGroomerRepository;
import br.com.saltopetmanager.matheustirabassi.repositories.CityRepository;
import br.com.saltopetmanager.matheustirabassi.repositories.SchedulingRepository;
import br.com.saltopetmanager.matheustirabassi.repositories.StateRepository;
import br.com.saltopetmanager.matheustirabassi.repositories.TutorRepository;

@SpringBootApplication
public class SaltoPetManagerApplication implements CommandLineRunner {

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	@Autowired
	private TutorRepository tutorRepository;

	@Autowired
	private SchedulingRepository schedulingRepository;

	@Autowired
	private BatherGroomerRepository batherGroomerRepository;

	@Autowired
	private AdressRepository addressRepository;

	@Autowired
	private StateRepository stateRepository;

	@Autowired
	private CityRepository cityRepository;

	public static void main(String[] args) {
		SpringApplication.run(SaltoPetManagerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		State s1 = new State(null, "São Paulo");

		City c1 = new City(null, "Cerquilho", s1);
		City c2 = new City(null, "Salto", s1);

		s1.getCities().addAll(Arrays.asList(c1, c2));

		stateRepository.saveAll(Arrays.asList(s1));
		cityRepository.saveAll(Arrays.asList(c1, c2));

		BatherGroomer batherGroomer1 = new BatherGroomer(Long.parseLong("43464837394"), "Suellem Peçanha Morais",
				"suellem.morais@geradornv.com.br", sdf.parse("22/02/1986"), "F");
		batherGroomer1.getCellphones().addAll(Arrays.asList("(88) 97928-8376", "159974244"));

		batherGroomerRepository.saveAll(Arrays.asList(batherGroomer1));

		Tutor t1 = new Tutor(Long.parseLong("48386036818"), "matheus", "matheus@gmail.com");
		t1.getCellphones().addAll(Arrays.asList("15991096801", "15991097479"));

		Address a1 = new Address(null, "R. Humberto de campos", "118", "casa", "Jardim Esplanada", "18520-000");
		Address a2 = new Address(null, "Avenida Matos", "105", "Sala 800", "Centro", "18520-000");
		a1.setCity(c1);
		a2.setCity(c2);
		t1.getAddresses().addAll(Arrays.asList(a1, a2));

		tutorRepository.saveAll(Arrays.asList(t1));
		addressRepository.saveAll(Arrays.asList(a1, a2));

		Scheduling scheduling1 = new Scheduling(null, new Date(), "Importante");
		batherGroomer1.getCustomerServices().add(scheduling1);
		t1.getSchedules().add(scheduling1);
		scheduling1.setTutor(t1);
		scheduling1.setBatherGroomer(batherGroomer1);

		schedulingRepository.saveAll(Arrays.asList(scheduling1));
	}

}
