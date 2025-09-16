package com.viclab.demo_services.service.impl;

import com.viclab.demo_services.dao.UserRepository;
import com.viclab.demo_services.entity.User;
import com.viclab.demo_services.exception.ResourceNotFoundException;
import com.viclab.demo_services.payload.UserDTO;
import com.viclab.demo_services.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("postgresUserService")
public class PostgreSqlUserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDTO createUser(UserDTO userDto) {
        User user = new User(
                userDto.getName(),
                userDto.getEmail(),
                userDto.getPhone(),
                userDto.getStatus()
        );

        User savedUser = userRepository.save(user);

        UserDTO response = new UserDTO();
        response.setId(savedUser.getId());
        response.setName(savedUser.getName());
        response.setEmail(savedUser.getEmail());
        response.setPhone(savedUser.getPhone());
        response.setStatus(savedUser.getStatus());

        return response;
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        List<UserDTO> userDTOS = users.stream()
                .map(user -> mapToDTO(user))
                .collect(Collectors.toUnmodifiableList());
        return userDTOS;
    }

    @Override
    public UserDTO getUserById(long id) {
        User user = userRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException("User","id",id));

        return mapToDTO(user);
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO, long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPhone(userDTO.getPhone());
        user.setStatus(userDTO.getStatus());

        User updateUser = userRepository.save(user);

        return mapToDTO(updateUser);
    }

    @Override
    public void deleteUserById(long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
        userRepository.delete(user);
    }

    private UserDTO mapToDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setEmail(user.getEmail());
        userDTO.setPhone(user.getPhone());
        userDTO.setStatus(user.getStatus());

        return userDTO;
    }
}
