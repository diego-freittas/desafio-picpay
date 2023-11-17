package br.gov.com.diegofreitas.desafiopicpay.repositories;


import br.gov.com.diegofreitas.desafiopicpay.domain.enuns.RoleType;
import br.gov.com.diegofreitas.desafiopicpay.domain.user.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface RoleRepository extends JpaRepository<Role, UUID> {
    Optional<Role> findByRoleName(RoleType name);
}
