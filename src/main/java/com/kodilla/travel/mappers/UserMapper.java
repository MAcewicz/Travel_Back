//package com.kodilla.travel.mappers;
//
//import com.kodilla.travel.com.kodilla.travel.controller.domain.User;
//import com.kodilla.travel.dto.UserDto;
//import com.kodilla.travel.exception.UserNotFoundException;
//import com.kodilla.travel.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Component
//public class UserMapper {
//
//    @Autowired
//    private TripMapper tripMapper;
//
//    @Autowired
//    private UserService userService;
//
//    public User mapToUser(UserDto userDto) throws UserNotFoundException {
//        return new User(userDto.getId(),
//                userDto.getName(),
//                userDto.getSurname(),
//                userService.getUserById(userDto.getId()).orElseThrow(UserNotFoundException::new).getPesel(),
//                userDto.getEmail(),
//                userDto.getPhoneNumber(),
//                userService.getUserById(userDto.getId()).orElseThrow(UserNotFoundException::new).getPassword(),
//                tripMapper.mapToTripList(userDto.getTripDtos()));
//    }
//
//    public UserDto mapToUserDto(User user) {
//        return new UserDto(user.getId(),
//                user.getName(),
//                user.getSurname(),
//                user.getEmail(),
//                user.getPhoneNumber(),
//                tripMapper.mapToTripDtoList(user.getTrips()));
//    }
//
//    public List<UserDto> mapToUserDtoList(List<User> users) {
//        return users.stream()
//                .map(user -> new UserDto(
//                        user.getId(),
//                        user.getName(),
//                        user.getSurname(),
//                        user.getEmail(),
//                        user.getPhoneNumber(),
//                        tripMapper.mapToTripDtoList(user.getTrips())
//                ))
//                .collect(Collectors.toList());
//    }
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
