package com.viclab.demo_services.service.impl;

import com.viclab.demo_services.payload.UserDTO;
import com.viclab.demo_services.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("dummyUserService")
public class DummyUserServiceImpl implements UserService {
    private final Map<Long, UserDTO> dummyUsers = new HashMap<>();
    private  Long currentId = 1L;  //todo why 1L


    @Override
    public UserDTO createUser(UserDTO userDto) {
        userDto.setId(currentId++);
        userDto.setStatus("ACTIVE");
        dummyUsers.put(userDto.getId(),userDto);
        return userDto;
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return new ArrayList<>(dummyUsers.values());
    }

    @Override
    public UserDTO getUserById(long id) {

        return dummyUsers.getOrDefault(id,null);
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO, long id) {
        if (dummyUsers.containsKey(id)) {
            userDTO.setId(id);
            dummyUsers.put(id,userDTO);
            return userDTO;
        }
        return null;
    }

    @Override
    public void deleteUserById(long id) {
        dummyUsers.remove(id);
    }
}
