package br.com.saltopetmanager.matheustirabassi.repositories;

import java.util.Optional;

import br.com.saltopetmanager.matheustirabassi.domain.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<Login, Integer> {

	public Optional<Login> findByUser(String user);
}
