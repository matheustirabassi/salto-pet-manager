package br.com.saltopetmanager.matheustirabassi.saltopetmanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.saltopetmanager.matheustirabassi.saltopetmanager.domain.City;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {

}
