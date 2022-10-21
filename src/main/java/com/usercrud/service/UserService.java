package com.usercrud.service;

import com.usercrud.dao.UserRepository;
import com.usercrud.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
@org.springframework.stereotype.Service
@Transactional
public class UserService implements Service <User>{

    private final UserRepository userRepository;

    @Override
    public Optional<User> findById(Integer id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> findAll() {

       return userRepository.findAll();
    }

    @Override
    public void save(User user) {
 userRepository.save(user);
    }

    @Override
    public void delete(User user) {
userRepository.delete( user);
    }

    @Override
    public void deleteById(Integer id) {
 userRepository.deleteById(id);
    }
}
