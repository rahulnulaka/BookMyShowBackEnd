package com.BookMyShowApplication.BookMyShow.Transformers;

import com.BookMyShowApplication.BookMyShow.DTO.UserDto;
import com.BookMyShowApplication.BookMyShow.Entity.User;

public class UserTransformer {
    public static User convertDtoToEntity(UserDto userDto){
        User user= User.builder()
                .age(userDto.getAge())
                .email(userDto.getEmail())
                .name(userDto.getName())
                .phoneNo(userDto.getPhoneNo())
                .build();
                return user;
    }
}
