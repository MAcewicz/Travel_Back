package com.kodilla.travel.mappers;

import com.kodilla.travel.domain.User;
import com.kodilla.travel.dto.UserDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class UserMapper {


    public List<UserDto> mapToUserDtoList(List<User> users) {
        return users.stream()
                .map(user -> new UserDto(user.getId(),
                        user.getName(),
                        user.getSurname(),
                        user.getPesel(),
                        user.getEmail(),
                        user.getPhoneNumber(),
                        user.getPassword()))
                .collect(Collectors.toList());
    }

    public UserDto mapToUserDto(User user) {
        return new UserDto(user.getId(),
                user.getName(),
                user.getSurname(),
                user.getPesel(),
                user.getEmail(),
                user.getPhoneNumber(),
                user.getPassword());
    }

    public User mapToUser(UserDto userDto) {
        return new User(userDto.getId(),
                userDto.getName(),
                userDto.getSurname(),
                userDto.getPesel(),
                userDto.getEmail(),
                userDto.getPhoneNumber(),
                userDto.getPassword());
    }
}























































