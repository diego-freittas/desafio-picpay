package br.gov.com.diegofreitas.desafiopicpay.services;

public interface PaymentService {

    boolean checkIfPaymentExist(Long transactionId);

    void process(Long transactionId, Double value);
}
