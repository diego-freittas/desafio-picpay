package br.gov.com.diegofreitas.desafiopicpay.repositories;

import br.gov.com.diegofreitas.desafiopicpay.domain.transaction.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
