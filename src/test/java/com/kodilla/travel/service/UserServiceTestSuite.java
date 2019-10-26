package com.kodilla.travel.service;


import com.kodilla.travel.domain.User;
import com.kodilla.travel.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTestSuite {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    private User getUser() {
        return new User(2L,
                "Jan",
                "Kowalski",
                "123456789000",
                "jan@test.pl",
                "123123123",
                "test");
    }

    @Test
    public void shouldFetchAllUsers() {
        //Given
        List<User> users = new ArrayList<>();
        users.add(getUser());

        when(userRepository.findAll()).thenReturn(users);
        //When
        List<User> resultList = userService.getUsers();
        //Then
        assertEquals(resultList.size(), 1);
    }

    @Test
    public void shouldFetchUserById() {
        //Given
        when(userRepository.findById(2L)).thenReturn(java.util.Optional.of(getUser()));
        //When
        Optional<User> result = userService.getUserById(2L);
        //Then
        assertNotNull(result);
    }

    @Test
    public void shouldFetchUserByEmail() {
        //Given
        when(userRepository.findByEmail("jan@test.pl")).thenReturn(java.util.Optional.of(getUser()));
        //When
        Optional<User> result = userService.getUserByEmail("jan@test.pl");
        //Then
        assertNotNull(result);
    }

    @Test
    public void shouldUpdateUser() {
        //Given
        User user = getUser();
        when(userRepository.save(user)).thenReturn(getUser());
        //When
        User result = userService.createUser(user);
        //Then
        assertEquals(result.getId(), user.getId());
        assertEquals(result.getName(), user.getName());
        assertEquals(result.getSurname(), user.getSurname());
        assertEquals(result.getPesel(), user.getPesel());
        assertEquals(result.getEmail(), user.getEmail());
        assertEquals(result.getPhoneNumber(), user.getPhoneNumber());
        assertEquals(result.getPassword(), user.getPassword());
    }
}
