package br.com.saltopetmanager.matheustirabassi.repositories;

import br.com.saltopetmanager.matheustirabassi.domain.Scheduling;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchedulingRepository extends JpaRepository<Scheduling, Integer> {
}
