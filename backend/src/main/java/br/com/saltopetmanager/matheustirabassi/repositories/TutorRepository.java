package br.com.saltopetmanager.matheustirabassi.repositories;

import br.com.saltopetmanager.matheustirabassi.domain.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TutorRepository extends JpaRepository<Tutor, Long> {

}
