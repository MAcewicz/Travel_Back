//package com.kodilla.travel.service;
//
//import com.kodilla.travel.com.kodilla.travel.controller.domain.User;
//import com.kodilla.travel.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class UserService {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    public List<User> getUsers() {
//        return userRepository.findAll();
//    }
//
//    public Optional<User> getUserById(long id) {
//        return userRepository.findById(id);
//    }
//
//    public Optional<User> getUserByEmail(String email) {
//        return userRepository.findByEmail(email);
//    }
//
//    public Optional<User> getUserByPesel(String pesel) {
//        return userRepository.findByPesel(pesel);
//    }
//
//    public User createUser(User user) {
//        return userRepository.save(user);
//    }
//
//    public void deleteUser(long id) {
//        userRepository.deleteById(id);
//    }
//}
