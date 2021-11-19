package br.com.saltopetmanager.matheustirabassi.saltopetmanager.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.saltopetmanager.matheustirabassi.saltopetmanager.domain.BatherGroomer;

import java.util.List;

@Repository
public interface BatherGroomerRepository extends JpaRepository<BatherGroomer, Long> {

}
