package br.com.saltopetmanager.matheustirabassi.repositories;

import br.com.saltopetmanager.matheustirabassi.domain.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepository extends JpaRepository<State, Integer> {

}
