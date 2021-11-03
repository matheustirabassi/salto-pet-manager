package br.com.saltopetmanager.matheustirabassi.SaltoPetManager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.saltopetmanager.matheustirabassi.SaltoPetManager.domain.Tutor;

@Repository
public interface TutorRepository extends JpaRepository<Tutor, Long>{

}
