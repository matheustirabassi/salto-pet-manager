package br.com.saltopetmanager.matheustirabassi.saltopetmanager.repositories;

import br.com.saltopetmanager.matheustirabassi.saltopetmanager.domain.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TutorRepository extends JpaRepository<Tutor, Long> {

}
