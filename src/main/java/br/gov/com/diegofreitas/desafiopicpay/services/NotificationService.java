package br.gov.com.diegofreitas.desafiopicpay.services;


import br.gov.com.diegofreitas.desafiopicpay.domain.user.User;

public interface NotificationService {

    void sendNotification(User userModel, String message) throws Exception;
}
