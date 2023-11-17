package br.gov.com.diegofreitas.desafiopicpay.services;

import br.gov.com.diegofreitas.desafiopicpay.domain.enuns.RoleType;
import br.gov.com.diegofreitas.desafiopicpay.domain.user.Role;

import java.util.Optional;

public interface RoleService {
    Optional<Role> findByRoleName(RoleType roleType);
}
