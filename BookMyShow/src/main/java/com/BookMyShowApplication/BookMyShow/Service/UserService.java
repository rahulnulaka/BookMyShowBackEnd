package com.BookMyShowApplication.BookMyShow.Service;

import com.BookMyShowApplication.BookMyShow.DTO.UserDto;
import com.BookMyShowApplication.BookMyShow.Entity.User;
import com.BookMyShowApplication.BookMyShow.Repository.UserRepository;
import com.BookMyShowApplication.BookMyShow.Transformers.UserTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public String addUser(UserDto userDto) throws Exception{
        User user= UserTransformer.convertDtoToEntity(userDto);
        userRepository.save(user);
        return "User has been added successfully to the db";
    }
}
