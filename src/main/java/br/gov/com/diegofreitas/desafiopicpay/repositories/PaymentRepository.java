package br.gov.com.diegofreitas.desafiopicpay.repositories;

import br.gov.com.diegofreitas.desafiopicpay.domain.transaction.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment,Long> {

}
