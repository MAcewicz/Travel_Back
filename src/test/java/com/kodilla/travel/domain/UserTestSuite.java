package com.kodilla.travel.domain;

import com.kodilla.travel.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTestSuite {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testCreateUser() {
        //Given
        List<Trip> trips = new ArrayList<>();
        Trip trip1 = new Trip();
        Trip trip2 = new Trip();
        trips.add(trip1);
        trips.add(trip2);
        User user = new User();
        //When
        //Then
        //CleanUp
    }
}
