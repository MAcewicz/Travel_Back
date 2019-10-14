package com.kodilla.travel.repository;

import com.kodilla.travel.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    @Override
    List<User> findAll();

    @Override
    Optional<User> findById(Long id);

    Optional<User> findByEmail(String email);

    Optional<User> findByPesel(String pesel);

    @Override
    User save(User user);

    @Override
    void deleteById(Long id);
}




