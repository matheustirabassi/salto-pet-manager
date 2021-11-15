package br.com.saltopetmanager.matheustirabassi.saltopetmanager.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.saltopetmanager.matheustirabassi.saltopetmanager.domain.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, Integer> {

	public Optional<Login> findByUser(String user);
}
