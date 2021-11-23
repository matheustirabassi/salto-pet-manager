package br.com.saltopetmanager.matheustirabassi.repositories;


import br.com.saltopetmanager.matheustirabassi.domain.BatherGroomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BatherGroomerRepository extends JpaRepository<BatherGroomer, Long> {

}
