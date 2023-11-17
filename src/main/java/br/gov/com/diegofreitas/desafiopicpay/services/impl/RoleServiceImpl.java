package br.gov.com.diegofreitas.desafiopicpay.services.impl;

import br.gov.com.diegofreitas.desafiopicpay.domain.enuns.RoleType;
import br.gov.com.diegofreitas.desafiopicpay.domain.user.Role;
import br.gov.com.diegofreitas.desafiopicpay.repositories.RoleRepository;
import br.gov.com.diegofreitas.desafiopicpay.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleRepository roleRepository;

    @Override
    public Optional<Role> findByRoleName(RoleType roleType) {
        return roleRepository.findByRoleName(roleType);
    }
}
