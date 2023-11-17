package br.gov.com.diegofreitas.desafiopicpay.services.impl;

import br.gov.com.diegofreitas.desafiopicpay.domain.transaction.Payment;
import br.gov.com.diegofreitas.desafiopicpay.repositories.PaymentRepository;
import br.gov.com.diegofreitas.desafiopicpay.services.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    PaymentRepository repository;


    @Override
    public boolean checkIfPaymentExist(Long transactionId) {
        return repository.existsById(transactionId);
    }

    @Override
    public void process(Long transactionId, Double value) {
        repository.save(new Payment(transactionId,value));
        logger.info("Payment processed !");
    }
}
