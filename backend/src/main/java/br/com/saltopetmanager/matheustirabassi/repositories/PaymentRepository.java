package br.com.saltopetmanager.matheustirabassi.repositories;

import br.com.saltopetmanager.matheustirabassi.domain.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {

}
