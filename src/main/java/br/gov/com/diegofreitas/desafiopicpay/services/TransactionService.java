package br.gov.com.diegofreitas.desafiopicpay.services;

import br.gov.com.diegofreitas.desafiopicpay.domain.transaction.Transaction;
import br.gov.com.diegofreitas.desafiopicpay.dtos.TransactionDTO;

public interface TransactionService {


    Transaction createTransaction(TransactionDTO transaction) throws Exception;
}
