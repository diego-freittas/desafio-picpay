package br.gov.com.diegofreitas.desafiopicpay.services.impl;


import br.gov.com.diegofreitas.desafiopicpay.domain.user.User;
import br.gov.com.diegofreitas.desafiopicpay.repositories.UserRepository;
import br.gov.com.diegofreitas.desafiopicpay.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(UUID userId) {
        return userRepository.findById(userId);
    }

    @Transactional
    @Override
    public void delete(User userModel) {
        userRepository.delete(userModel);
    }

    @Override
    public User save(User userModel) {
        return userRepository.save(userModel);
    }

    @Override
    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public Page<User> findAll(Specification<User> spec, Pageable pageable) {
        return userRepository.findAll(spec, pageable);
    }

    @Transactional
    @Override
    public User saveUser(User userModel){
        userModel = save(userModel);
        return userModel;
    }

    @Transactional
    @Override
    public void deleteUser(User userModel) {
        delete(userModel);
    }

    @Transactional
    @Override
    public User updateUser(User userModel) {
        userModel = save(userModel);
        return userModel;
    }

    @Override
    public User updatePassword(User userModel) {
        return save(userModel);
    }
}
