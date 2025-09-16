package com.viclab.demo_services.controller;


import com.viclab.demo_services.payload.UserDTO;
import com.viclab.demo_services.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    @Qualifier("postgresUserService")
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserDTO> saveUser (@RequestBody UserDTO userDTO) {
        UserDTO userResponse = userService.createUser(userDTO);
        return new ResponseEntity<>(userResponse, HttpStatus.CREATED);
    }

    @GetMapping
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable(name = "id") long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUserById(@RequestBody UserDTO userDTO, @PathVariable(name = "id") long id) {
        UserDTO userResponse = userService.updateUser(userDTO, id);
        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable(name = "id") long id) {
        userService.deleteUserById(id);
        return new ResponseEntity<>("User entity deleted successfully.", HttpStatus.OK);
    }
}
