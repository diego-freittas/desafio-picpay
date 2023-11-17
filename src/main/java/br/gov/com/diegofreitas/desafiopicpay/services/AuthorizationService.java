package br.gov.com.diegofreitas.desafiopicpay.services;

import br.gov.com.diegofreitas.desafiopicpay.domain.user.User;

import java.math.BigDecimal;

public interface AuthorizationService {

    boolean authorizeTransaction(User sender, BigDecimal value);
}
