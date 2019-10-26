package com.kodilla.travel.mapper;

import com.kodilla.travel.domain.User;
import com.kodilla.travel.dto.UserDto;
import com.kodilla.travel.mappers.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTestSuite {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testMapToUserDtoList() {
        //Given
        List<User> users = new ArrayList<>();
        users.add(new User(2L,
                "Jan",
                "Kowalski",
                "123456789000",
                "jan@test.pl",
                "123123123",
                "test"));
        //When
        List<UserDto> resultList = userMapper.mapToUserDtoList(users);
        //Then
        assertEquals(resultList.size(), 1);
    }

    @Test
    public void testMapToUserDto() {
        //Given
        User user = new User(2L,
                "Jan",
                "Kowalski",
                "123456789000",
                "jan@test.pl",
                "123123123",
                "test");
        //When
        UserDto result = userMapper.mapToUserDto(user);
        //Then
        assertEquals(result.getId(), user.getId());
        assertEquals(result.getName(), user.getName());
        assertEquals(result.getSurname(), user.getSurname());
        assertEquals(result.getPesel(), user.getPesel());
        assertEquals(result.getEmail(), user.getEmail());
        assertEquals(result.getPhoneNumber(), user.getPhoneNumber());
        assertEquals(result.getPassword(), user.getPassword());
    }

    @Test
    public void testMapToUser() {
        //Given
        UserDto userDto = new UserDto(2L,
                "Jan",
                "Kowalski",
                "123456789000",
                "jan@test.pl",
                "123123123",
                "test");
        //When
        User result = userMapper.mapToUser(userDto);
        //Then
        assertEquals(result.getId(), userDto.getId());
        assertEquals(result.getName(), userDto.getName());
        assertEquals(result.getSurname(), userDto.getSurname());
        assertEquals(result.getPesel(), userDto.getPesel());
        assertEquals(result.getEmail(), userDto.getEmail());
        assertEquals(result.getPhoneNumber(), userDto.getPhoneNumber());
        assertEquals(result.getPassword(), userDto.getPassword());
    }
}
