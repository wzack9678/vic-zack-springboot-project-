package com.viclab.demo_services.service;

import com.viclab.demo_services.payload.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO createUser (UserDTO userDto);

    List<UserDTO> getAllUsers();

    UserDTO getUserById(long id);

    UserDTO updateUser(UserDTO userDTO, long id);

    void  deleteUserById(long id);

}
