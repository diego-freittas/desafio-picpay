package br.gov.com.diegofreitas.desafiopicpay.services.impl;

import br.gov.com.diegofreitas.desafiopicpay.domain.transaction.Transaction;
import br.gov.com.diegofreitas.desafiopicpay.domain.user.User;
import br.gov.com.diegofreitas.desafiopicpay.dtos.TransactionDTO;
import br.gov.com.diegofreitas.desafiopicpay.repositories.TransactionRepository;
import br.gov.com.diegofreitas.desafiopicpay.services.AuthorizationService;
import br.gov.com.diegofreitas.desafiopicpay.services.NotificationService;
import br.gov.com.diegofreitas.desafiopicpay.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private TransactionRepository repository;

    @Autowired
    private AuthorizationService authService;

    @Autowired
    private NotificationService notificationService;

    @Override
    @Transactional
    public Transaction createTransaction(TransactionDTO transaction) throws Exception {
        User sender = this.userService.findById(transaction.senderId()).get();
        User receiver = this.userService.findById(transaction.receiverId()).get();

        //userService.validateTransaction(sender, transaction.value());

        boolean isAuthorized = this.authService.authorizeTransaction(sender, transaction.value());
        if(!isAuthorized){
            throw new Exception("Transação não autorizada");
        }

        Transaction newTransaction = new Transaction();
        newTransaction.setAmount(transaction.value());
        newTransaction.setSender(sender);
        newTransaction.setReceiver(receiver);
        newTransaction.setTimestamp(LocalDateTime.now());

        //sender.setBalance(sender.getBalance().subtract(transaction.value()));
        //receiver.setBalance(receiver.getBalance().add(transaction.value()));

        this.repository.save(newTransaction);
        this.userService.saveUser(sender);
        this.userService.saveUser(receiver);

        this.notificationService.sendNotification(sender, "Transação realizada com sucesso");
        this.notificationService.sendNotification(receiver, "Transação recebida com sucesso");

        return newTransaction;
    }
}
