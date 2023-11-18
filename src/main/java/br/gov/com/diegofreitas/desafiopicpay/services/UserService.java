package br.gov.com.diegofreitas.desafiopicpay.services;

import br.gov.com.diegofreitas.desafiopicpay.domain.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserService {
    List<User> findAll();
    Optional<User> findById(UUID userId);

    void delete(User userModel);

    User save(User userModel);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    Page<User> findAll(Pageable pageable);

    User saveUser(User userModel);
    void deleteUser(User userModel);
    User updateUser(User userModel);
    User updatePassword(User userModel);

}
